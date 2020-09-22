package org.autodatacorp.vindescription.service;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features/service/vin"},
        glue = {"classpath:org.autodatacorp.vindescription.service.steps."}

)
public class VinDescriptionTestSuite {
}
