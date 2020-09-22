package org.autodatacorp.vindescription.service.steps;


import com.jayway.jsonpath.JsonPath;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import net.minidev.json.JSONArray;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Shared;
import org.autodatacorp.vindescription.common.Endpoint;
import org.autodatacorp.vindescription.common.SchemaFileAccess;
import org.autodatacorp.vindescription.common.SharedContext;
import org.autodatacorp.vindescription.common.Util;
import org.autodatacorp.vindescription.service.tasks.CallCPPWebService;

import java.util.ArrayList;
import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class RetrieveValidVinDescriptionHealthSteps {


    @Shared
    private SharedContext context;
    private String restUrl = Util.getEnvironmentProperty("vds.base.url");
    private SchemaFileAccess schemaFile = new SchemaFileAccess();
    private String  endpoint = Endpoint.vindescriptionservicehealth.getTemplatePath();


    @Given("(.*) wants to retrieve the health from vds webservice")
    public void wantsToRetrieveHealthFromVDS(String actor) {
        context.setActor(Actor.named(actor).whoCan(CallAnApi.at(restUrl)));
        context.setEndpoint(Endpoint.vindescriptionservicehealth);
    }

    @When("^s?he calls vds to get health operation$")
    public void actorCallsTheGetHealthOperation() {
        context.getActor().attemptsTo(CallCPPWebService.withBasicEndpoint(endpoint));
    }


    @Then("he should see the vds health result in the response")
    public void actorShouldSeeResultInResponse() {

        context.getActor().attemptsTo(
                Get.resource(context.getEndpoint().getTemplatePath())
                        .with(request -> request.contentType(ContentType.JSON))
        );


        context.getActor().should(seeThatResponse("Should return a valid response from vin description service",
                response -> response.statusCode(200)
        ));

        String responseBody = SerenityRest.lastResponse().getBody().prettyPrint();
        JSONArray jsonArray = JsonPath.parse(responseBody).read("$.result[*].id");
        List<String> results = new ArrayList<>();

        for (int i = 0; i < jsonArray.size(); i++) {
            results.add(jsonArray.get(i).toString());
        }

        context.getActor().should(seeThat("The result id should match route1", result -> (results.contains("route1"))));
        context.getActor().should(seeThat("The result id should match route2", result -> (results.contains("route2"))));
        context.getActor().should(seeThat("The result id should match route3", result -> (results.contains("route3"))));
      //results.forEach(object -> context.getActor().should(seeThat("The result id should match route1", result -> (results.contains("route1")))));



    }






}

