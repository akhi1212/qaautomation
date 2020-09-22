package org.autodatacorp.vindescription.storm.steps;

import net.thucydides.core.annotations.Shared;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.autodatacorp.vindescription.common.SharedContext;
import org.autodatacorp.vindescription.common.TimeStamp;
import org.autodatacorp.vindescription.common.Util;
import org.autodatacorp.vindescription.storm.util.Constants;
import org.autodatacorp.vindescription.storm.util.RunEtl;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public abstract class AbstractCommonStep {

    protected String msToWaitStartETL = Util.getEnvironmentProperty("ms.to.wait.etl.start");
    protected final String stormEnvironment = Util.getEnvironmentProperty("storm.environment");

    @Shared
    protected SharedContext context;

    protected Producer<String, String> producer;
    protected String content = "";
    private final String bootStrapServers = "LNOC-DVCP-XET3:9092";
    protected String topic = "";
    protected Properties props;
    protected List<String> topicMessage = new ArrayList<>();
    protected String message = "";
    protected Instant timestamp = TimeStamp.getInstance();
    protected static Thread t1 = null;

    protected void startETL(){
        if(t1 == null){
            t1 = new Thread(new RunEtl());
            t1.start();
            try {
                Thread.sleep(Integer.parseInt(msToWaitStartETL));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected boolean checkETL() {
        String etlPath = "";
        if (stormEnvironment.equalsIgnoreCase(Constants.STORM_ENVIRONMENT_QA)) {
            etlPath = "http://lnoc-qacp-xet1.autodatacorp.org:8080/api/v1/topology/summary";
        } else {
            etlPath = "http://lnoc-dvcp-xet1.autodatacorp.org:8080/api/v1/topology/summary";
        }

        try {
            URL url = new URL(etlPath);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String response = br.readLine();
            while (br.readLine() != null) {
                response += br.readLine();
            }
            conn.disconnect();
            JSONParser parser = new JSONParser();
            JSONObject object = (JSONObject) parser.parse(response);
            List<JSONObject> topologies = (List<JSONObject>) object.get("topologies");
            for (JSONObject topology : topologies) {
                String topologyName = (String) topology.get("name");
                String status = (String) topology.get("status");
                if (topologyName != null && topologyName.contains("vin-description") && status.equals("ACTIVE")) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in ETL:- " + e);
        }

        return false;
    }

    protected Properties getPropsForProducer(){
        props = new Properties();
        props.put("bootstrap.servers", bootStrapServers);
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        return props;
    }

    protected Properties getPropertiesForConsumer(){
        props = new Properties();
        props.put("bootstrap.servers", bootStrapServers);
        props.put("group.id", "config");
        props.put("key.deserializer", StringDeserializer.class.getName());
        props.put("value.deserializer", StringDeserializer.class.getName());
        return props;
    }

}
