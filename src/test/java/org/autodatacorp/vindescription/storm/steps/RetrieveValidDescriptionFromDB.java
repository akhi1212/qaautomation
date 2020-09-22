package org.autodatacorp.vindescription.storm.steps;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.thucydides.core.annotations.Shared;
import net.thucydides.core.annotations.Steps;
import org.autodatacorp.vindescription.common.SharedContext;
import org.autodatacorp.vindescription.common.Util;
import org.autodatacorp.vindescription.model.lookup.Color;
import org.autodatacorp.vindescription.model.lookup.LookupResponse;
import org.autodatacorp.vindescription.storm.database.DBConnection;
import org.autodatacorp.vindescription.storm.steplibraries.Vindescriptiondetails;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;


public class RetrieveValidDescriptionFromDB {


    @Shared
    private SharedContext context;

    @Steps
    private Vindescriptiondetails vindescriptiondetails;
    private List<String> currentResult = new ArrayList<>();
    private String[] styles;
    private String[] jsonNotation;
    private DBConnection dbConnect = null;
    private int styleid;
    private String expectedFeatureValueInSummary = null;
    private boolean isFound = false;
    private final String VEHICLES = "vehicles";
    private final String PACKAGES = "packages";
   
    @Given("(.*) wants to get a valid connection to the database")
    public void Actor_valid_connection_to_the_database(String actor) {
        dbConnect = vindescriptiondetails.getConnectionToDatabase();
        context.setActor(Actor.named(actor));
    }

    @When("Actor wants to retrieve vehicle information from the DB after starting ETL for {string}")
    public void actor_wants_to_retrieve_vehicle_information_from_the_DB_after_starting_ETL_for(String styleid) {
        String replaceAll = styleid.replaceAll("\\s+", "");
        styles = replaceAll.split(",");
        currentResult = vindescriptiondetails.getQueryForVehicleSummaryResponseAfterTopic(dbConnect, styles);
    }


    @When("Actor wants to retrieve vehicle information from the DB for {string}")
    public void actor_wants_to_retrieve_vehicle_information_from_the_DB_for(String styleid) {
        String replaceAll = styleid.replaceAll("\\s+", "");
        styles = replaceAll.split(",");
        currentResult = vindescriptiondetails.getQueryForVehicleSummaryResponse(dbConnect, styles);
    }

    @When("Actor wants to retrieve exterior color data from the DB for '(.*)'")
    public void actor_wants_to_retrieve_exterior_color_data_from_the_DB_for(String styleid) {
        String replaceAll = styleid.replaceAll("\\s+", "");
        styles = replaceAll.split(",");
        currentResult = vindescriptiondetails.getQueryForVehicleSummaryResponse(dbConnect, styles);
    }

    @When("Actor wants to retrieve techSpecs from the DB for '(.*)'")
    public void actor_wants_to_retrieve_techSpecs_from_the_DB_for(String styleid) {
        String replaceAll = styleid.replaceAll("\\s+", "");
        styles = replaceAll.split(",");
        currentResult = vindescriptiondetails.getQueryForVehicleSummaryResponse(dbConnect, styles);
    }

    @Then("user should see a response and the json {string} response should be {string}")
    public void user_should_see_a_response_and_the_json_response_should_be(String featureCode, String currentSetting) {
        expectedFeatureValueInSummary = currentSetting;
        jsonNotation = featureCode.split("\\.");
        assertEquals("jsonNotation field length is not what was expected!", 2, jsonNotation.length);
        String category = jsonNotation[0];
        JSONObject obj = new JSONObject();
        ObjectMapper objectMapper = new ObjectMapper();
        for (String valueJson : currentResult) {
            JsonNode actualObj = null;
            try {
                actualObj = objectMapper.readTree(valueJson);
                JsonNode initialNode = actualObj.get(category);
                assertNotNull(category + " is not found in the vehSummary json response", initialNode);
                traverse(initialNode);
                if (!isFound) {
                    assertTrue(expectedFeatureValueInSummary + " expected but not found", isFound);
                }
            } catch (IOException e) {
                throw new AssertionError(e.getMessage());
            }
        }
    }

    private void traverse(JsonNode root) {

        String expectedFieldName = jsonNotation[1];

        if (root.isObject()) {
            Iterator<String> fieldNames = root.fieldNames();

            while (fieldNames.hasNext()) {
                String fieldName = fieldNames.next();
                JsonNode fieldValue = root.get(fieldName);

                if (expectedFieldName.equalsIgnoreCase(fieldName) && expectedFeatureValueInSummary.equalsIgnoreCase(fieldValue.asText())) {
                    isFound = true;
                }

                if (expectedFieldName.equalsIgnoreCase(fieldName) && fieldValue == null) {
                    assertNotNull("Feature code value is null", fieldValue.asText());
                }
                traverse(fieldValue);
            }
        } else if (root.isArray()) {
            ArrayNode arrayNode = (ArrayNode) root;
            for (int i = 0; i < arrayNode.size(); i++) {
                JsonNode arrayElement = arrayNode.get(i);
                traverse(arrayElement);
            }
        }
    }


    @Then("he should see the styleid in the summary response")
    public void he_should_see_the_styleid_in_the_summary_response() {
        //vindescriptiondetails.forStyleIdInSummaryResponse(currentResult, styleId);
    }

    @Then("Actor wants to delete vehicle summary from vindescriptiondetails for styleid '(.*)'")
    public void Actor_wants_to_delete_vehicle_summary_from_db(String styleid) {
        String replaceAll = styleid.replaceAll("\\s+", "");
        styles = null;
        styles = replaceAll.split(",");
        vindescriptiondetails.deleteVehSummaryByStyle(dbConnect, styles);
    }


    private static String getTopologyFilePath(String fileName) {
        return MethodHandles.lookup().lookupClass().getClassLoader().getResource(fileName).getFile();
    }

    @Then("^user should see the '(.*)','(.*)' and '(.*)' in the query response$")
    public void user_should_see_year_make_model(String year, String make, String model) {
        ObjectMapper objectMapper = new ObjectMapper();
        for (String valueJson : currentResult) {
            JsonNode actualObj = null;
            try {
                actualObj = objectMapper.readTree(valueJson);
                ArrayNode vehicles = (ArrayNode) actualObj.get(VEHICLES);

                assertNotNull("vehicles is not found in the vehSummary json response", vehicles);
                assertNotNull("year is not found in the vehSummary json response", vehicles.get(0).path("year"));
                assertNotNull("make is not found in the vehSummary json response", vehicles.get(0).path("make"));
                assertNotNull("model is not found in the vehSummary json response", vehicles.get(0).path("model"));
                assertEquals(year, vehicles.get(0).path("year").textValue());
                assertEquals(make, vehicles.get(0).path("make").textValue());
                assertEquals(model, vehicles.get(0).path("model").textValue());
            } catch (IOException e) {
                throw new AssertionError(e.getMessage());
            }
        }
    }

    @Then("Actor should see the 'code' as '(.*)', 'name' as '(.*)', 'genericName' as '(.*)', 'primary' as '(.*)', 'rgbValue' as '(.*)', 'type' as '(.*)' in the query response")
    public void actor_should_see_the_exterior_color_attributes_in_the_query_response(String code, String name, String genericName, String primary, String rgbValue, Integer type) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        for (String valueJson : currentResult) {
            LookupResponse lookupResponse = objectMapper.readValue(valueJson, LookupResponse.class);
            long count = lookupResponse.getExteriorColors().stream().filter(t -> t.getCode().equals(code)
                    && t.getName().equals(name)
                    && t.getGenericName().equals(genericName)
                    && t.getType().equals(type)
                    && (isEqual((t.getPrimary() != null ? t.getPrimary().toString() : null), (primary == null || primary.trim().length() == 0) ? null : primary)
                    && isEqual(t.getRgbValue(), (rgbValue == null || rgbValue.trim().length() == 0 ? null : rgbValue)))).count();
            assertTrue(count > 0);

        }

    }

    private boolean isEqual(Object one, Object two) {
        if (one == null && two == null) {
            return true;
        } else if (one != null && two != null) {
            return one.equals(two);
        }
        return false;
    }

    @Then("Actor should see the {string} as {string} in the query response")
    public void Actor_should_see_box_style_in_query_response(String field, String expectedValue) {
        final String BOX_STYLE = "boxStyle";
        final String DOORS = "doors";
        final String COUNTRY = "country";
        final String STANDARD_GVWR = "standardGVWR";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(currentResult.get(0));
            ArrayNode vehicleNode = (ArrayNode) jsonNode.get(VEHICLES);
            String fetchedValue = "";
            ObjectNode node = (ObjectNode) vehicleNode.get(0);
            switch (field) {
                case BOX_STYLE:
                    if (node.has(BOX_STYLE)) {
                        fetchedValue = node.findValue(BOX_STYLE).asText();
                    }
                    assertEquals("Box Style does not match", expectedValue, fetchedValue);
                    break;
                case DOORS:
                    if (node.has(DOORS)) {
                        fetchedValue = node.findValue(DOORS).asText();
                    }
                    assertEquals("Number of Doors does not match", expectedValue, fetchedValue);
                    break;
                case COUNTRY:
                    if (node.has(COUNTRY)) {
                        fetchedValue = node.findValue(COUNTRY).asText();
                    }
                    assertEquals("Country does not match", expectedValue, fetchedValue);
                    break;
                case STANDARD_GVWR:
                    if (node.has(STANDARD_GVWR)) {
                        fetchedValue = node.findValue(STANDARD_GVWR).asText();
                    }
                    assertEquals("StandardGVWR does not match", expectedValue, fetchedValue);
                    break;
            }

        } catch (IOException e) {
            throw new AssertionError(e.getMessage());
        }
    }

    @Then("Actor should see the 'code' as '(.*)', 'name' as '(.*)', 'genericName' as '(.*)', 'primary' as '(.*)' with no duplicates in the query response")
    public void actor_should_see_there_are_no_duplicate_exterior_colors_in_the_query_response(String code, String name, String genericName, String primary) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        for (String valueJson : currentResult) {
            LookupResponse lookupResponse = objectMapper.readValue(valueJson, LookupResponse.class);
            List<Color> allColors = new ArrayList<>(lookupResponse.getExteriorColors());
            allColors.addAll(lookupResponse.getInteriorColors());
            long count = allColors.stream().filter(t -> t.getCode().equals(code)
                    && t.getName().equals(name)
                    && t.getGenericName().equals(genericName)
                    && (isEqual((t.getPrimary() != null ? t.getPrimary().toString() : null), (primary == null || primary.trim().length() == 0) ? null : primary))).count();
            assertTrue(1 == count);
        }

    }

    @Then("user should see packages value {string}, {string}, {string}, {string}, {string}, {string}, {string} in the query response")
    public void user_should_see_packages_value_in_the_query_response(String featureId, String featureKey, String featureCode, String subSectionId, String subSectionName, String featureIdName, String featureName) throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode packages = null;

        for (String valueJson : currentResult) {

            JsonNode actualObj = objectMapper.readTree(valueJson);
            packages = (ArrayNode) actualObj.get(PACKAGES);
            String featureIdValue = packages.get(0).path("featureId").textValue();
            if(featureIdValue.equalsIgnoreCase(featureId)){
                assertNotNull("featureId is not found of summary of json response", packages.get(0).path("featureId"));
                assertNotNull("featureKey is not found of summary of json response", packages.get(0).path("featureKey"));
                assertNotNull("featureCode is not found of summary of json response", packages.get(0).path("featureCode"));
                assertNotNull("subSectionId is not found of summary of json response", packages.get(0).path("subSectionId"));
                assertNotNull("subSectionName is not found of summary of json response", packages.get(0).path("subSectionName"));
                assertNotNull("featureIdName is not found of summary of json response", packages.get(0).path("featureIdName"));
                assertNotNull("featureName is not found of summary of json response", packages.get(0).path("featureName"));
                assertEquals(featureId, packages.get(0).path("featureId").textValue());
                assertEquals(featureKey, packages.get(0).path("featureKey").textValue());
                assertEquals(featureCode, packages.get(0).path("featureCode").textValue());
                assertEquals(subSectionId, packages.get(0).path("subSectionId").textValue());
                assertEquals(subSectionName, packages.get(0).path("subSectionName").textValue());
                assertEquals(featureIdName, packages.get(0).path("featureIdName").textValue());
                assertEquals(featureName, packages.get(0).path("featureName").textValue());
            }
        }
    }


    @Then("Actor should see the 'featureCode' as '(.*)', 'subSectionName' as '(.*)', 'featureIdName' as '(.*)', 'featureName' as '(.*)', 'icCodeAnswers' as '(.*)' in the query response")
    public void actor_should_see_the_exterior_color_attributes_in_the_query_response(String featureCode, String subSectionName, String featureIdName, String featureName, String icCodeAnswers) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        for (String valueJson : currentResult) {
            LookupResponse lookupResponse = objectMapper.readValue(valueJson, LookupResponse.class);
            long count = lookupResponse.getTechSpecs().stream().filter(t -> t.getFeatureCode().trim().equalsIgnoreCase(featureCode)
                    && t.getSubSectionName().trim().equalsIgnoreCase(subSectionName)
                    && t.getFeatureIdName().trim().equalsIgnoreCase(featureIdName)
                    && t.getFeatureName().trim().equalsIgnoreCase(featureName)
                    && t.getIcCodeAnswers().equals(Util.stringToList(icCodeAnswers))).count();
            assertTrue(count > 0);
        }
    }
} 