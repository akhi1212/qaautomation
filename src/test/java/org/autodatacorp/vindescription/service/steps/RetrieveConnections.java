package org.autodatacorp.vindescription.service.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.annotations.Shared;
import org.autodatacorp.vindescription.common.Endpoint;
import org.autodatacorp.vindescription.common.SharedContext;
import org.autodatacorp.vindescription.common.Util;
import org.autodatacorp.vindescription.service.tasks.CallVDSWebService;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;


public class RetrieveConnections {

    @Shared
    private SharedContext context;
    private final String restUrl = Util.getEnvironmentProperty("vds.base.url");

    @Given("(.*) hit url")
    public void userHitConnectionAPI(String actor) {
        context.setActor(Actor.named(actor).whoCan(CallAnApi.at(this.restUrl)));
        context.setEndpoint(Endpoint.vindescriptionserviceconnection);
    }

    @When("^user calls vds to see the response")
    public void callToVDSServiceForConnections(){
        context.getActor().attemptsTo(CallVDSWebService.withVDSEndpoint(Endpoint.vindescriptionserviceconnection.getTemplatePath()));
    }

    @Then("^user should not see '(.*)' and '(.*)'")
    public void result(String vehicleVac, String insuranceQuote){
        String responseBody = SerenityRest.lastResponse().getBody().prettyPrint();
        System.out.println(responseBody);
        context.getActor().should(seeThat("Unnecessary connections are removed", result -> (shouldNotContain(responseBody, vehicleVac, insuranceQuote))));
    }

    private boolean shouldNotContain(String responseBody, String vehicleVac, String insuranceQuote) {
        String[] vehicleVacConnectionDetails = vehicleVac.split(",");
        String[] insuranceQuoteConnectionDetails = insuranceQuote.split(",");
        String vehicleVacConnectionName = vehicleVacConnectionDetails[0]; //jdbc/vehicleVacDataSource
        String vehicleVacDatabase = vehicleVacConnectionDetails[3]; // "Database": vehicle_vac
        String insuranceConnectionName = insuranceQuoteConnectionDetails[0]; // jdbc/insuranceQuoteDataSource
        String insuranceDatabase = insuranceQuoteConnectionDetails[3]; // Database: insurancequote
        return !(responseBody.contains(vehicleVacConnectionName)
                && responseBody.contains(vehicleVacDatabase)
                && responseBody.contains(insuranceConnectionName)
                && responseBody.contains(insuranceDatabase));
    }

}
