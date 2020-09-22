package org.autodatacorp.vindescription.storm.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.autodatacorp.vindescription.storm.util.Constants;
import org.junit.Assert;

import java.time.Instant;
import java.util.Collections;
import java.util.concurrent.ExecutionException;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class PassValidConfigurationStormSteps extends AbstractCommonStep {

    private static String gvuid = "";

    public PassValidConfigurationStormSteps(){}

    @When("(.*) is setup with topic '(.*)' and gvuid as '(.*)'")
    public void corey_sets_up_producer_to_pass_data(String actor, String topic, String gvuid) {
        this.topic = topic;
        this.gvuid = gvuid;
        context.setActor(Actor.named(actor));
    }

    @Given("Actor spins up the etl")
    public void actor_spins_up_etl(){
        if (stormEnvironment.equalsIgnoreCase(Constants.STORM_ENVIRONMENT_LOCAL)) {
            startETL();
        } else {
            if (!checkETL()) {
                Assert.fail("ETL not working");
            }
        }
    }

    @When("he sets up the producer")
    public void he_sets_up_the_producer(){
        props = getPropsForProducer();

        producer = new KafkaProducer<>(props, new StringSerializer(), new StringSerializer());
        ProducerCallback callback = new ProducerCallback();

        try {
            ProducerRecord<String, String> data = new ProducerRecord<>(topic, gvuid );
            producer.send(data,callback).get();
        } catch (InterruptedException | ExecutionException e) {
            assertEquals("***The Producer with topic and gvuid threw an error ***\n" + gvuid, e.getMessage());
        }finally {
            producer.flush();
            producer.close();
        }
    }


    @When("he sets up consumer to get topic")
    public void he_sets_consumer_to_get_topic() {

        props = getPropertiesForConsumer();

        Consumer<Long, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Collections.singletonList(topic));

        ConsumerRecords<Long, String> consumerRecords = consumer.poll(2000L);

        for (ConsumerRecord<Long, String> record : consumerRecords) {
            topicMessage.add(record.value());
            message = record.value();
            System.out.println(" ******* Consumer shows GVUID " + message + " on topic ******");
        }

        consumer.commitAsync();
        consumer.close();

    }



    @Then("he should see the gvuid in the consumer response")
    public void he_should_see_the_gvuid_in_the_consumer_response() {

        if(topicMessage.size() > 0) {
            topicMessage.forEach(object -> context.getActor().should(seeThat("The result gvuid for topic should be returned", result -> (topicMessage.contains(gvuid)))));
        }
    }

    private static class ProducerCallback implements Callback {
        @Override
        public void onCompletion(RecordMetadata recordMetadata, Exception e) {
            if (e != null) {
                System.out.println("Error while producing message to topic :" + recordMetadata);
                assertNotNull("***GVUID in topic null  ***\n" + gvuid,  e.getMessage());
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
