package org.autodatacorp.vindescription.service.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import net.minidev.json.JSONArray;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.annotations.Shared;
import org.apache.commons.lang3.StringUtils;
import org.autodatacorp.vindescription.common.Endpoint;
import org.autodatacorp.vindescription.common.SchemaFileAccess;
import org.autodatacorp.vindescription.common.SharedContext;
import org.autodatacorp.vindescription.common.Util;
import org.autodatacorp.vindescription.service.domain.Feature;
import org.autodatacorp.vindescription.service.domain.TechnicalSpecification;
import org.autodatacorp.vindescription.service.domain.VdsResponse;
import org.autodatacorp.vindescription.service.tasks.CallVDSWebService;
import org.junit.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.asList;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RetrieveValidVehicleByVin {

    private static final String COMMA_SPACE = ",\\s*";

    @Shared
    private SharedContext context;

    @Shared
    private RequestSpecBuilder requestBuilder = new RequestSpecBuilder();

    private String restUrl = Util.getEnvironmentProperty("vds.base.url");
    private SchemaFileAccess schemaFile = new SchemaFileAccess();
    private String endpoint = Endpoint.vindescriptionservicevin.getTemplatePath();
    private String vin;

    @Given("(.*) wants to retrieve vin information for '(.*)'")
    public void wantsToRetrieveVinInfoFromVDS(String actor, String vin) {

        context.setActor(Actor.named(actor).whoCan(CallAnApi.at(restUrl)));
        context.setEndpoint(Endpoint.vindescriptionservicevin);
        this.vin = vin;
        requestBuilder.addPathParam("vin", vin);

    }

    @When("(.*) calls vds for vin$")
    public void actorCallsVdsVinOperation(String actor) {
        context.getActor().attemptsTo(CallVDSWebService.withVDSEndpoint(endpoint, requestBuilder));
    }

    @Then("User should see the '(.*)' service response the vin.")
    public void responseShouldIncludeTheSource(String source) throws Exception{
        VdsResponse vinResponse = getVdsResponse();
        context.getActor().should(seeThat("Expected build source should match the build source in response",
                result -> (source.equals(vinResponse.getResult().getSource()))));
    }

    private VdsResponse getVdsResponse() throws IOException {
        String responseBody = SerenityRest.lastResponse().getBody().prettyPrint();
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(responseBody, VdsResponse.class);
    }

    @Then("User should see the manufacture option codes as '(.*)' in service response.")
    public void responseShouldIncludeTheManufacturerOptionCodes(String optionCode) throws Exception {
        VdsResponse vinResponse = getVdsResponse();
        if(StringUtils.isNotBlank(optionCode)) {
            String[] optionCodes = optionCode.split(",");
            context.getActor().should(seeThat("Expected Vin option code should match the option codes in response",
                    result -> (asList(optionCodes).equals(vinResponse.getResult().getOptionCodes()))));
        }else {
            context.getActor().should(seeThat("Vin option codes should be empty in response",
                    result -> (vinResponse.getResult().getOptionCodes() == null
                            || vinResponse.getResult().getOptionCodes().isEmpty())));
        }

    }


    @Then("he should see the vin information in the response")
    public void actorShouldSeeVinResultInResponse() {

        String responseBody = SerenityRest.lastResponse().getBody().prettyPrint();
        String responseVin = JsonPath.parse(responseBody).read("result.vinProcessed");

        context.getActor().should(seeThatResponse("Should return a valid vin response from vin description service",
                response -> response.statusCode(200)
        ));


        context.getActor().should(seeThat("Vin should match the Vin in response", result -> (responseVin.equals(vin))));
    }

    @Then("^he should see the '(.*)' and '(.*)' in service response for '(.*)'$")
    public void theResponseShouldIncludeInteriorColors(String genericDesc, String description, String styleId) {

        context.getActor().should(
                seeThatResponse("The given genericDesc in interior colors is not included in the response",
                        response -> response.body("result.interiorColors.genericDesc", hasItems((genericDesc)))
                ));

        context.getActor().should(
                seeThatResponse("The given description in interior colors is not included in the response",
                        response -> response.body("result.interiorColors.description", hasItems((description)))
                ));
    }

    @Then("^user should see the '(.*)' and '(.*)' in service response for '(.*)'$")
    public void responseShouldIncludeExteriorColors(String genericDesc, String description, String styleId) {

        String[] genericDescription = genericDesc.split(COMMA_SPACE);
        String[] desc = description.split(COMMA_SPACE);

        List<String> styles = new ArrayList<>();
        styles.add(styleId);

        String responseBody = SerenityRest.lastResponse().getBody().prettyPrint();
        JSONArray responseExteriorColors = JsonPath.parse(responseBody).read("result.exteriorColors");

        context.getActor().should(seeThatResponse(
                "The expected genericDesc in exterior colors is not included in the response",
                response -> response.body("result.exteriorColors.genericDesc", hasItems((genericDescription)))));

        context.getActor()
                .should(seeThatResponse("The expected description in exterior colors is not included in the response",
                        response -> response.body("result.exteriorColors.description", hasItems((desc)))));

        for (Object responseExterior : responseExteriorColors) {
            LinkedHashMap<Object, Object> response = (LinkedHashMap) responseExterior;
            JSONArray jsonArray = (JSONArray) response.get("styles");
            for (int n = 0; n < jsonArray.size(); n++) {
                Object responseStyleId =  jsonArray.get(n);
                for (String style : styles) {
                    if(responseStyleId.equals(style)){
                        context.getActor().should(seeThat("The expected styleId in exterior colors is not included in the response", result -> (responseStyleId.equals(style))));
                    }
                }
            }
        }
    }

    @Then("^user should see the '(.*)','(.*)' and '(.*)' in service response$")
    public void responseShouldYearMakeAndModel(String year, String make, String model) {

        String responseBody = SerenityRest.lastResponse().getBody().prettyPrint();
        String responseYear = JsonPath.parse(responseBody).read("result.year");
        String responseMake = JsonPath.parse(responseBody).read("result.make");
        String responseModel = JsonPath.parse(responseBody).read("result.model");

        context.getActor().should(seeThat("The expected year is not included in the response", result -> (responseYear.equals(year))));
        context.getActor().should(seeThat("The expected make is not included in the response", result -> (responseMake.equalsIgnoreCase(make))));
        context.getActor().should(seeThat("The expected model is not included in the response", result -> (responseModel.equalsIgnoreCase(model))));
    }

    @Then("^user should see the boxStyle '(.*)' in service response for '(.*)'$")
    public void responseShouldIncludeBoxStyle(String boxStyle, Integer styleId) {

        if (StringUtils.isEmpty(boxStyle)) {
            context.getActor().should(seeThatResponse("The expected boxStyle is not included in the response",
                    response -> response.body("result.vehicles[0].boxStyle", isEmptyOrNullString())));
        } else {
            context.getActor().should(seeThatResponse("The expected boxStyle is not included in the response",
                    response -> response.body("result.vehicles.boxStyle", hasItem((boxStyle)))));
        }
        context.getActor()
                .should(seeThatResponse("The expected styleId for the boxStyle is not included in the response",
                        response -> response.body("result.vehicles.styleId", hasItem((styleId)))));
    }

    @Then("^user should see the country '(.*)' in service response for '(.*)'$")
    public void responseShouldIncludeCountry(String country, Integer styleId) {

        context.getActor().should(seeThatResponse(
                "The expected country for the styleId is not included in the response",
                response -> response.body("result.vehicles.country", hasItems((country)))));

        context.getActor()
                .should(seeThatResponse("The expected styleId is not included in the response",
                        response -> response.body("result.vehicles.styleId", hasItems((styleId)))));
    }

    @Then("^user should see the '(.*)' in the response")
    public void responseShouldIncludeDoors(Integer doors) {
        context.getActor().should(seeThatResponse("The expected doors are included in the response",
                response -> response.body("result.vehicles[0].doors", is(doors))));
    }

    @Then("^User should see the '(.*)', '(.*)', '(.*)', '(.*)', '(.*)' in service response the vin.")
    public void responseShouldIncludeBuildAndWmiInformation(String buildDate, String buildMSRPArg, String wmiCountry, String wmiManufacturer, String mfrModelCode) {
        String responseBody = SerenityRest.lastResponse().getBody().prettyPrint();
        String responseBuildDate = readFieldFromJson(responseBody,"result.buildDate");
        if(StringUtils.isNotBlank(buildDate)) {
            context.getActor().should(seeThatResponse("The expected build data is included in the response",
                    response -> buildDate.equals(responseBuildDate)));
        } else {
            context.getActor().should(seeThatResponse("The expected build data is not included in the response",
                    response -> StringUtils.isBlank(responseBuildDate)));
        }
        if(StringUtils.isNotBlank(buildMSRPArg)){
            Double buildMSRP = Double.parseDouble(buildMSRPArg);
            Double responseBuildMsrp = JsonPath.parse(responseBody).read("result.buildMSRP");
            context.getActor().should(seeThatResponse("The expected build msrp is included in the response",
                    response -> buildMSRP.equals(responseBuildMsrp)));
        } else {
            context.getActor().should(seeThatResponse("The expected build msrp is not included in the response",
                    response -> StringUtils.isBlank(readFieldFromJson(responseBody,"result.buildMSRP"))));
        }
        String responseCountry = JsonPath.parse(responseBody).read("result.wmiCountry");
        String responseManufacturer = JsonPath.parse(responseBody).read("result.wmiManufacturer");
        String responseMfrModelCode = JsonPath.parse(responseBody).read("result.vehicles[0].mfrModelCode");
        context.getActor().should(seeThatResponse("The expected wmi country is included in the response",
                response -> wmiCountry.equals(responseCountry)));
        context.getActor().should(seeThatResponse("The expected wmi manufacturer is included in the response",
                response -> wmiManufacturer.equals(responseManufacturer)));
        context.getActor().should(seeThatResponse("The expected model code is included in the response",
                response -> mfrModelCode.equals(responseMfrModelCode)));
    }

    @Then("^user should see the standardGVWR '(.*)' in service response$")
    public void responseShouldIncludeStandardGVWR(Integer standardGVWR) {

        context.getActor().should(seeThatResponse(
                "The expected standardGVWR is not included in the response",
                response -> response.body("result.vehicles.standardGVWR", hasItems((standardGVWR)))));
    }




    @Then("user should see the {string} in vehicles array in service response.")
    public void user_should_see_the_in_vehicles_array_in_service_response(String styleId) {

        List<String> addedStyles = Util.stringToList(styleId);

        String responseBody = SerenityRest.lastResponse().getBody().prettyPrint();
        JSONArray responseVehicles = JsonPath.parse(responseBody).read("result.vehicles");

        for (Object veh : responseVehicles) {
            LinkedHashMap<Object, Object> vehicle = (LinkedHashMap) veh;

            Integer styleValue = (Integer)vehicle.get("styleId");
            for(String styles : addedStyles){
                if(Integer.valueOf(styles).equals(styleValue)){
                    context.getActor()
                            .should(seeThat("The vehicle array in the response should match style id", result -> (vehicle.get("styleId").equals(styleValue))));
                }
            }
        }
    }

    @Then("user should see {string} with {string} in features array in service response.")
    public void user_should_see_with_in_features_array_in_service_response(String styleIds, String key) throws IOException {

        List<String> addedStyles = Util.stringToList(styleIds);

        String responseBody = SerenityRest.lastResponse().getBody().prettyPrint();
        JSONArray responseFeatures = JsonPath.parse(responseBody).read("result.features");

            for (Object responseFeature : responseFeatures) {
            LinkedHashMap<Object, Object> feature = (LinkedHashMap) responseFeature;
            if (feature.get("key").equals(key)) {
                context.getActor().should(seeThat("The key in the response should match key", result -> (feature.get("key").equals(key))));

                    LinkedHashMap<Object, Object> styles = (LinkedHashMap) feature;
                    JSONArray jsonArray = (JSONArray) styles.get("styles");
                    int count = 0;

                    for(int n = 0; n < jsonArray.size(); n++)
                    {
                        JSONArray toAdd =  (JSONArray)((LinkedHashMap) jsonArray.get(n)).get("styleIds");
                        count += toAdd.size();
                        checkStylesMatch(toAdd, addedStyles);
                    }
                    assertEquals("Number of styles for key in the response should match whats expected" , count, addedStyles.size());
            }
        }

    }


    @Then("user should see {string} with {string} & {string} in exterior color in service response.")
    public void user_should_see_styles_with_genericDesc_and_description_exterior_color_in_service_response(String styles, String genericDesc, String description) {

        List<String> addedStyles = Util.stringToList(styles);
        String responseBody = SerenityRest.lastResponse().getBody().prettyPrint();
        JSONArray responseExteriorColors = JsonPath.parse(responseBody).read("result.exteriorColors");

        for (Object responseExterior : responseExteriorColors) {
            LinkedHashMap<Object, Object> exterior = (LinkedHashMap) responseExterior;

            if(checkDescriptions(exterior, genericDesc, description)){
                JSONArray jsonArray = (JSONArray) exterior.get("styles");
                assertTrue("Generic description and description should be found in the response for vin" , exterior.get("genericDesc").equals(genericDesc) && exterior.get("description").equals(description));
                assertEquals("Number of styles for key in the response should match whats expected" , jsonArray.size(), addedStyles.size());
                break;
            }
        }
    }

    @Then("user should see {string} with {string} & {string} in interior color in service response.")
    public void user_should_see_with_in_interior_color_in_service_response(String styles, String genericDesc, String description) {

        List<String> addedStyles = Util.stringToList(styles);
        String responseBody = SerenityRest.lastResponse().getBody().prettyPrint();
        JSONArray responseInteriorColors = JsonPath.parse(responseBody).read("result.interiorColors");
        for (Object responseInterior : responseInteriorColors) {
            LinkedHashMap<Object, Object> interior = (LinkedHashMap) responseInterior;
            if(checkDescriptions(interior, genericDesc, description)){
                JSONArray jsonArray = (JSONArray) interior.get("styles");
                assertTrue("Generic description and description should be found in the response for vin" , interior.get("genericDesc").equals(genericDesc) && interior.get("description").equals(description));
                assertEquals("Number of styles for key in the response should match whats expected" , jsonArray.size(), addedStyles.size());
                break;
            }
        }

    }

    @Then("user should see {string} of {string} for vehicles, exteriorColors, interiorColors & features \\(single styleId) in service response.")
    public void user_should_see_of_for_vehicles_exteriorColors_interiorColors_features_single_styleId_in_service_response(String count, String result) {

        String responseBody = SerenityRest.lastResponse().getBody().prettyPrint();
        JSONArray response = JsonPath.parse(responseBody).read("result." + result);
        assertEquals( result + " array should have a count of " + count , String.valueOf(response.size()), count);

    }

    @Then("user should see {string}, {string} and {string} in exterior color in service response for {string}")
    public void user_should_see_and_in_exterior_color_in_service_response_for(String genericDesc, String description, String primary, String styleId) {
        List<String> addedStyles = Util.stringToList(styleId);
        String responseBody = SerenityRest.lastResponse().getBody().prettyPrint();
        JSONArray responseExteriorColors = JsonPath.parse(responseBody).read("result.exteriorColors");

        for (Object responseExt : responseExteriorColors) {
            LinkedHashMap<Object, Object> exterior = (LinkedHashMap) responseExt;
            String genericDescription = (String) exterior.get("genericDesc");
            String desc = (String) exterior.get("description");
            Boolean isPrimary = (Boolean) exterior.get("primary");

            if(genericDescription.equalsIgnoreCase(genericDesc) && desc.equalsIgnoreCase(description) && isPrimary.equals(Boolean.parseBoolean(primary))){
                context.getActor().should(seeThat("The list of styles in the response should match styles", result -> (genericDescription.equals(genericDesc)) &&
                        desc.equalsIgnoreCase(description) && isPrimary.equals(Boolean.parseBoolean(primary))));

                JSONArray jsonArray = (JSONArray) exterior.get("styles");
                int count = 0;
                for(int n = 0; n < jsonArray.size(); n++) {
                    String id = (String)jsonArray.get(n);
                    if(id.equalsIgnoreCase(styleId)){
                        context.getActor().should(seeThat("The list of styles in the response should match styles", result -> (id.equals(styleId))));
                    }
                    count++;
                }
                assertEquals("Number of styles for key in the response should match whats expected" , count, addedStyles.size());
            }
        }
    }

    @Then("user should  see packages value {string}, {string}, {string}, {string}, {string}, {string} in service response for {string}")
    public void user_should_see_packages_value_in_service_response_for(String id, String key, String sectionId, String subSectionId, String name, String description, String styles) {

        List<String> addedStyles = Util.stringToList(styles);
        String responseBody = SerenityRest.lastResponse().getBody().prettyPrint();
        JSONArray responsePackages = JsonPath.parse(responseBody).read("result.packages");

        int count = 0;
        for (Object obPackages : responsePackages) {
            LinkedHashMap<String, Object> packages = (LinkedHashMap<String, Object>) obPackages;
            if (packages.get("id").toString().equalsIgnoreCase(id) && packages.get("key").equals(key)
                    && packages.get("sectionId").equals(sectionId)
                    && packages.get("subSectionId").toString().equals(subSectionId)
                    && packages.get("name").equals(name)
                    && packages.get("description").equals(description)
            ){
                assertTrue("Packages should contain the following attributes " , packages.get("id").toString().equalsIgnoreCase(id)
                        && packages.get("key").equals(key) && packages.get("sectionId").equals(sectionId)
                        && packages.get("subSectionId").toString().equals(subSectionId)
                        && packages.get("name").equals(name)
                        && packages.get("description").equals(description));

                JSONArray jsonArray = (JSONArray) packages.get("styles");

                for(int n = 0; n < jsonArray.size(); n++) {
                    JSONArray styleIdToCheck = (JSONArray)((LinkedHashMap) jsonArray.get(n)).get("styleIds");
                    count += styleIdToCheck.size();
                    checkStylesMatch(styleIdToCheck, addedStyles);
                }
                assertEquals("Number of styles for key in the response should match whats expected" , count, addedStyles.size());
            }
        }
    }

    private void checkStylesMatch(JSONArray styleIdToCheck ,List<String> addedStyles){

        for(Object s : styleIdToCheck){
            for(String style : addedStyles){
                if(s.equals(style)) {
                    context.getActor().should(seeThat("The list of styles in the response should match styles", result -> (s.equals(style))));
                    break;
                }
            }
        }
    }


    private boolean checkDescriptions( LinkedHashMap<Object, Object> interiorOrExterior, String genericDesc, String description){

        boolean isFound = false;

        if (interiorOrExterior.get("genericDesc").equals(genericDesc) && interiorOrExterior.get("description").equals(description)) {
          isFound = true;
        }

        return isFound;
    }

    private String readFieldFromJson(String response, String path){
        String result = null;
        try{
            result = JsonPath.parse(response).read(path);
        }catch (Exception e){
            //Ignore
        }
        return result;
    }

    @Then("Actor should see the '(.*)', '(.*)', '(.*)', '(.*)' and '(.*)' in exterior colors in service response for '(.*)'$")
    public void actor_should_see_rooftop_stripe_exterior_color_in_response(String genericDesc, String description,  String rgbValue, String typeAttribute, String primary, String styleId) {

        List<String> addedStyles = Util.stringToList(styleId);
        context.getActor().should(seeThatResponse("Should return a valid response from vin description service",
                response -> response.statusCode(200)
        ));
        String responseBody = SerenityRest.lastResponse().getBody().prettyPrint();
        JSONArray exteriorColorResponse = JsonPath.parse(responseBody).read("result.exteriorColors");

        int count = 0;
        for (Object color : exteriorColorResponse) {
            LinkedHashMap<String, Object> exteriorColor = (LinkedHashMap<String, Object>) color;
            if (exteriorColor.get("genericDesc").toString().equalsIgnoreCase(genericDesc)
                    && exteriorColor.get("description").toString().equalsIgnoreCase(description)
                    && exteriorColor.get("type").toString().equals(typeAttribute)
                    && isEqual((exteriorColor.get("primary") != null ? exteriorColor.get("primary").toString() : null), (primary == null || primary.trim().length() == 0) ? null : primary)
                    && isEqual(exteriorColor.get("rgbValue"), (rgbValue == null || rgbValue.trim().length() == 0 ? null : rgbValue))
                    && exteriorColor.get("styles").equals(addedStyles)) {
                count++;
                break;
            }
        }
        assertTrue("Rooftop and stripe exterior color validated for exterior color", count > 0);
    }

    private boolean isEqual(Object one, Object two) {
        if(one == null && two == null) {
            return true;
        }else if(one != null && two != null) {
            return one.equals(two);
        }
        return false;
    }

    @Then("User should not see the id and server time in the service response.")
    public void user_should_not_see_the_id_and_serverTime_in_the_service_response() {
        String responseBody = SerenityRest.lastResponse().getBody().prettyPrint();
        Boolean serverTimeExists;
        try{
            JsonPath.parse(responseBody).read("serverTime");
            serverTimeExists = Boolean.TRUE;
        }catch (PathNotFoundException e) {
            serverTimeExists = Boolean.FALSE;
        }

        Boolean idExists;
        try{
            JsonPath.parse(responseBody).read("id");
            idExists = Boolean.TRUE;
        }catch (PathNotFoundException e) {
            idExists = Boolean.FALSE;
        }
        Assert.assertNotNull(serverTimeExists);
        Assert.assertNotNull(idExists);
        Assert.assertFalse("Server time removed",serverTimeExists);
        Assert.assertFalse("Id removed",idExists);
    }

    @Then("Actor should see the fuel economy techSpecs contains {string}, {string}, {string}, {string}, {string}, {string} in service response for {string} and fuel economy is separated by slash")
    public void actor_should_see_the_fuel_economy_is_separated_by_slash(String id, String key, String sectionId, String subSectionId, String name, String description, String styles) throws Exception {
        VdsResponse vinResponse = getVdsResponse();
        List<String> expectedStyles = Util.stringToList(styles);
        List<TechnicalSpecification> features =  vinResponse.getResult().getTechSpecs().stream()
                .filter(t -> t.getId().equals(id)
                        && t.getKey().equals(key)
                        && t.getSectionId().equals(sectionId.trim())
                        && t.getSubSectionId().equals(parseInt(subSectionId))
                        && t.getName().equals(name)
                        && t.getDescription().equals(description)
                        && t.getStyles().get(0).getStyleIds().equals(expectedStyles)).collect(Collectors.toList());
        Assert.assertNotNull(features);
        Assert.assertFalse(features.isEmpty());
    }

    @Then("Actor should see the cruise control feature contains {string}, {string}, {string}, {string}, {string}, {string} in service response for {string} and name is not having too many stops")
    public void actor_should_see_the_name_is_not_having_too_many_stops(String id, String key, String sectionId, String subSectionId, String name, String description, String styles) throws Exception {
        validateResponse(id, key, sectionId, subSectionId, name, description, styles);
    }

    @Then("Actor should see the sun roof feature contains {string}, {string}, {string}, {string}, {string}, {string} in service response for {string} and there is a space between tilting and glass text.")
    public void actor_should_see_the_there_is_a_space_between_tilting_and_glass_text(String id, String key, String sectionId, String subSectionId, String name, String description, String styles) throws Exception {
        validateResponse(id, key, sectionId, subSectionId, name, description, styles);
    }

    private void validateResponse(String id, String key, String sectionId, String subSectionId, String name, String description, String styles) throws IOException {
        VdsResponse vinResponse = getVdsResponse();
        List<String> expectedStyles = Util.stringToList(styles);
        List<Feature> features = vinResponse.getResult().getFeatures().stream()
                .filter(t -> t.getId().equals(id)
                        && t.getKey().equals(key)
                        && t.getSectionId().equals(sectionId.trim())
                        && t.getSubSectionId().equals(parseInt(subSectionId))
                        && t.getName().equals(name)
                        && t.getDescription().equals(description)
                        && t.getStyles().get(0).getStyleIds().equals(expectedStyles)).collect(Collectors.toList());
        Assert.assertNotNull(features);
        Assert.assertFalse(features.isEmpty());
    }
}
