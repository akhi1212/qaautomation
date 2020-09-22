package org.autodatacorp.vindescription.service.steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Shared;
import org.autodatacorp.vindescription.common.Endpoint;
import org.autodatacorp.vindescription.common.SchemaFileAccess;
import org.autodatacorp.vindescription.common.SharedContext;
import org.autodatacorp.vindescription.common.Util;
import org.autodatacorp.vindescription.service.tasks.*;

import java.io.File;
import java.security.NoSuchAlgorithmException;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.*;

public class RetrieveValidVersionRuntimeCrmSteps {

    @Shared
    private SharedContext context;
    private String restUrl = Util.getEnvironmentProperty("runtime.crm.base.url");
    private SchemaFileAccess schemaFile = new SchemaFileAccess();
    private String  endpoint = Endpoint.runtimecrmversion.getTemplatePath();

    @Given("(.*) wants to retrieve the runtime crm version number")
    public void wantsToRetrieveTheRuntimeCrmVersionNumber(String actor) throws NoSuchAlgorithmException {
        context.setActor(Actor.named(actor).whoCan(CallAnApi.at(restUrl)));
        context.setEndpoint(Endpoint.runtimecrmversion);
    }

    @When("^s?he calls the get version operation$")
    public void actorCallsTheGetVersionOperation() {
        context.getActor().attemptsTo(CallCPPWebService.withBasicEndpoint(endpoint));
    }


    @Then("he should see the version number in the response")
    public void actorShouldSeeVersionInResponse() {

         File f  = schemaFile.getSchemaFile(context.getEndpoint().getDefaultSchema());

        context.getActor().attemptsTo(
                Get.resource(context.getEndpoint().getTemplatePath())
                        .with(request -> request.contentType(ContentType.JSON))
        );


        context.getActor().should(seeThatResponse("Should return a valid response",
                response -> response.statusCode(200)
        ));

//        context.getActor().should(seeThatResponse("Follows the json schema",
//                response -> response
//                        .body(matchesJsonSchema(schemaFile.getSchemaFile(context.getEndpoint().getDefaultSchema())))
//        ));

        context.getActor().should(seeThatResponse("result is not empty", response -> response.assertThat().body("result", is(not(empty())))));



    }

}
