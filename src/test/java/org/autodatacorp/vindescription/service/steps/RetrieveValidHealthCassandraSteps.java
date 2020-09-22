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


import java.security.NoSuchAlgorithmException;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.is;

public class RetrieveValidHealthCassandraSteps {

    @Shared
    private SharedContext context;
    private String restUrl = Util.getEnvironmentProperty("vin.id.cassandra.base.url");
    private SchemaFileAccess schemaFile = new SchemaFileAccess();
    private String  endpoint = Endpoint.vinidcassandrahealth.getTemplatePath();


    @Given("(.*) wants to retrieve the health from vin id cassandra")
    public void wantsToRetrieveThehealthFromVinidCassandra(String actor) throws NoSuchAlgorithmException {
        context.setActor(Actor.named(actor).whoCan(CallAnApi.at(restUrl)));
        context.setEndpoint(Endpoint.vinidcassandrahealth);
    }

    @When("^s?he calls the get health operation$")
    public void actorCallsTheGetHealthOperation() {
        context.getActor().attemptsTo(CallCPPWebService.withBasicEndpoint(endpoint));
    }


    @Then("he should see the result in the response")
    public void actorShouldSeeResponse() {

        context.getActor().attemptsTo(
                Get.resource(context.getEndpoint().getTemplatePath())
                        .with(request -> request.contentType(ContentType.JSON))
        );


        context.getActor().should(seeThatResponse("Should return a valid health response for vin id cassandra",
                response -> response.statusCode(200)
        ));

//        context.getActor().should(seeThatResponse("Follows the health json schema",
//                response -> response
//                        .body(matchesJsonSchema(schemaFile.getSchemaFile(context.getEndpoint().getDefaultSchema())))
//        ));

        context.getActor().should(seeThatResponse(response -> response.assertThat().body("result", is("OK"))));


    }


}
