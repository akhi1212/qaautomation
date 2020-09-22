package org.autodatacorp.vindescription.service.steps;

import com.jayway.jsonpath.JsonPath;
import io.cucumber.java.en.Then;
import net.minidev.json.JSONArray;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Shared;
import org.autodatacorp.vindescription.common.SharedContext;
import org.autodatacorp.vindescription.common.Util;

import java.util.LinkedHashMap;
import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.junit.Assert.assertTrue;

public class RetrieveValidEnglishFeaturesByVinSteps {

    @Shared
    private SharedContext context;
    private String vin;

    @Then("he should see the English features contains (.*), (.*) in service response for (.*)")
    public void heShouldSeeTheEnglishFeaturesContainsFeatureIdFeatureNameInServiceResponseForFeatureIdName(String featureId, String featureName,
                                                                                                           String featureIdName) {
        String responseBody = SerenityRest.lastResponse().getBody().prettyPrint();
        JSONArray responseFeatures = JsonPath.parse(responseBody).read("result.features");

        for (Object responseFeature : responseFeatures) {
            LinkedHashMap<String, String> feature = (LinkedHashMap) responseFeature;
            if (feature.get("id").equals(featureId)) {
                context.getActor()
                        .should(seeThat("The description should match featureIdName", result -> (feature.get("description").equals(featureIdName))));
                context.getActor().should(seeThat("The name should match featureName",
                        result -> (feature.get("name").equals(featureName))));
                break;
            }
        }


    }

    @Then("he should see the English techSpecs contains '(.*)', '(.*)', '(.*)', '(.*)', '(.*)', '(.*)' in service response for '(.*)'$")
    public void actor_should_see_english_tech_specs_in_response(String id, String key, String sectionId, String subSectionId, String name, String description, String styleId) {

        List<String> addedStyles = Util.stringToList(styleId);
        context.getActor().should(seeThatResponse("Should return a valid response from vin description service",
                response -> response.statusCode(200)
        ));
        String responseBody = SerenityRest.lastResponse().getBody().prettyPrint();
        JSONArray techSpecsResponse = JsonPath.parse(responseBody).read("result.techSpecs");

        int count = 0;
        for (Object techSpecs : techSpecsResponse) {
            LinkedHashMap<String, Object> techSpec = (LinkedHashMap) techSpecs;
            if (techSpec.get("id").toString().equals(id)
                    && techSpec.get("key").toString().trim().equalsIgnoreCase(key)
                    && techSpec.get("sectionId").toString().equals(sectionId)
                    && techSpec.get("subSectionId").toString().equals(subSectionId)
                    && techSpec.get("name").toString().trim().equalsIgnoreCase(name)
                    && techSpec.get("description").toString().trim().equalsIgnoreCase(description)) {

                JSONArray jsonArray = (JSONArray) techSpec.get("styles");
                for(int n = 0; n < jsonArray.size(); n++) {
                    JSONArray array =  (JSONArray)((LinkedHashMap) jsonArray.get(n)).get("styleIds");
                    for (Object styleObject : array) {
                        String style = styleObject.toString();
                        if (addedStyles.contains(style)) {
                            count++;
                        } else {
                            context.getActor().should(seeThat("The list of styles in the response should match styles", result -> (style.equals(styleId))));
                        }
                    }
                    if (count > 0) {
                        break;
                    }
                }
            }
            if (count > 0) {
                break;
            }
        }
        assertTrue("Tech Specs validated in the response", count > 0);
    }
}

