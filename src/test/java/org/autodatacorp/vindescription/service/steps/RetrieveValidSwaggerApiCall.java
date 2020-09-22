package org.autodatacorp.vindescription.service.steps;

import com.jayway.jsonpath.JsonPath;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.annotations.Shared;
import org.autodatacorp.vindescription.common.Endpoint;
import org.autodatacorp.vindescription.common.SharedContext;
import org.autodatacorp.vindescription.common.Util;
import org.autodatacorp.vindescription.service.tasks.CallVDSWebService;
import org.yaml.snakeyaml.Yaml;

import java.util.LinkedHashMap;
import java.util.Map;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.junit.Assert.assertFalse;

public class RetrieveValidSwaggerApiCall {

    @Shared
    private SharedContext context;
    @Shared
    private RequestSpecBuilder requestBuilder = new RequestSpecBuilder();
    private String restUrl = Util.getEnvironmentProperty("vds.base.url");
    private boolean yaml = false;

    @Given("(.*) wants to hit swagger api url")
    public void user_wants_to_hit_swagger_api_url(String actor) {
        context.setActor(Actor.named(actor).whoCan(CallAnApi.at(this.restUrl)));
    }

    @When("user hit valid swagger api url")
    public void user_hit_valid_swagger_api_url() {
        context.setEndpoint(Endpoint.vindescriptionserviceswagger);
        context.getActor().attemptsTo(CallVDSWebService.withVDSEndpoint(Endpoint.vindescriptionserviceswagger.getTemplatePath()));
    }

    @When("user hit valid swagger.json api url with {string}")
    public void user_hit_valid_swagger_api_url_with(String json) {
        context.setEndpoint(Endpoint.vindescriptionserviceswaggerwithparam);
        requestBuilder.addPathParam("swagger", json);
        context.getActor().attemptsTo(CallVDSWebService.withVDSEndpointParam(Endpoint.vindescriptionserviceswaggerwithparam.getTemplatePath(), requestBuilder));
    }

    @When("user hit valid swagger.yaml api url with {string}")
    public void user_hit_valid_swagger_yaml_api_url_with(String yml) {
        context.setEndpoint(Endpoint.vindescriptionserviceswaggerwithparam);
        requestBuilder.addPathParam("swagger", yml);
        this.yaml = true;
        context.getActor().attemptsTo(CallVDSWebService.withVDSEndpointParam(Endpoint.vindescriptionserviceswaggerwithparam.getTemplatePath(), requestBuilder));
    }

    @Then("user should see http status code {int} ok and content should be display")
    public void user_should_see_http_status_code_ok_and_content_should_be_display(Integer code) {

        context.getActor().should(seeThatResponse("Swagger API call should return a status of 200" ,
                response -> response.statusCode(code)
        ));

    }


    @SuppressWarnings("unchecked")
    @Then("user should see http status code {int} ok and content should not have id, server time, redis response.")
    public void user_should_see_http_status_code_ok_and_content_should_not_have_id_server_time_redisResponse(int code) {
        context.getActor().should(seeThatResponse("Swagger API call should return a status of 200",
                response -> response.statusCode(code)
        ));

        String responseBody = SerenityRest.lastResponse().getBody().prettyPrint();
        if(this.yaml){
            Yaml yaml = new Yaml();
            Map<String,Object> map = (Map<String, Object>) yaml.load(responseBody);
            Map<String,Object> definitions = (Map<String,Object>)map.get("definitions");
            Map<String,Object> vinDescriptionResponse = (Map<String,Object>)definitions.get("VinDescriptionResponse");
            Map<String,Object> responseProperties = (Map<String,Object>)vinDescriptionResponse.get("properties");
            checkProperties(responseProperties);
        } else {
            LinkedHashMap<String, Object> responseProperties = JsonPath.parse(responseBody).read("definitions.VinDescriptionResponse.properties");
            checkProperties(responseProperties);
        }

    }

    private void checkProperties(Map<String,Object> responseProperties){
        assertFalse("Response body should not contain server time", responseProperties.containsKey("serverTime"));
        assertFalse("Response body should not contain id", responseProperties.containsKey("id"));
        assertFalse("Response body should not contain redis", responseProperties.containsKey("redis"));
    }
}
