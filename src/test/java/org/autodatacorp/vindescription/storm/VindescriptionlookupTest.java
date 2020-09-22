package org.autodatacorp.vindescription.storm;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features/storm"},
        glue = {"classpath:org.autodatacorp.vindescription.storm.steps."}
)

public class VindescriptionlookupTest {

}


