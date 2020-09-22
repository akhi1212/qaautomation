package org.autodatacorp.vindescription.storm.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.autodatacorp.vindescription.storm.database.DBConnection;
import org.autodatacorp.vindescription.storm.steplibraries.Vindescriptiondetails;
import org.autodatacorp.vindescription.storm.util.Constants;
import org.junit.Assert;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PrePublishingAcodePatternSteps extends AbstractCommonStep {

    private static String acode;

    @Steps
    private Vindescriptiondetails vindescriptiondetails;

    private DBConnection dbConnect = null;


    public PrePublishingAcodePatternSteps(){

    }

    @Given("User spins up the etl for acode replay")
    public void actor_spins_up_etl_for_acode_replay(){
        if (stormEnvironment.equalsIgnoreCase(Constants.STORM_ENVIRONMENT_LOCAL)) {
            startETL();
        } else {
            if (!checkETL()) {
                Assert.fail("ETL not working");
            }
        }
    }

    @Given("user wants to publish acode '(.*)'")
    public void actor_wants_to_publis_acode(String acode){
        this.topic = "vinDescription.acodeFilter";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        PrePublishingAcodePatternSteps.acode = acode;
    }

    @When("user publish acodes in etl automation")
    public void user_publish_acodes_in_etl_automation(){

        props = getPropsForProducer();

        producer = new KafkaProducer<>(props, new StringSerializer(), new StringSerializer());
        ProducerCallback callback = new ProducerCallback();

        try {
            ProducerRecord<String, String> data = new ProducerRecord<>(topic, acode );
            producer.send(data,callback).get();
        } catch (InterruptedException | ExecutionException e) {
            assertEquals("***The Producer with topic and acode threw an error ***\n" + acode, e.getMessage());
        }finally {
            producer.flush();
            producer.close();
        }
    }

    @Then("user should see the updated time in the vindescriptiondetails with style id '(.*)'")
    public void user_should_see_the_update_time_in_the_vindescriptiondetails_with_styleid(String styleId){
        dbConnect = vindescriptiondetails.getConnectionToDatabase();
        vindescriptiondetails.getQueryForVehicleSummaryResponseAfterTopic(dbConnect,styleId.split(","));
    }

    private static class ProducerCallback implements Callback {
        @Override
        public void onCompletion(RecordMetadata recordMetadata, Exception e) {
            if (e != null) {
                System.out.println("Error while producing message to topic :" + recordMetadata);
                assertNotNull("***Acode in topic null  ***\n" + acode,  e.getMessage());
                e.printStackTrace();
            } else {
                String message = String.format("sent message to topic:%s partition:%s  offset:%s", recordMetadata.topic(), recordMetadata.partition(), recordMetadata.offset());
                System.out.println(message);
            }
        }
    }

    public Instant getTimeStamp(){
        return timestamp;
    }
}
