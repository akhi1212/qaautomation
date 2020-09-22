package org.autodatacorp.vindescription.storm.util;

import org.apache.storm.flux.Flux;
import org.autodatacorp.vindescription.common.Util;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

public class RunEtl implements Runnable {

    private static final String TOPOLOGY_CONFIG_FILENAME = "vin-description-storm.yaml";
    private static final String LOCAL_FILTER_FILENAME = "local-filter.properties";
    private String msToWaitStartETL = Util.getEnvironmentProperty("ms.to.wait.etl.start");

    private volatile boolean exit = false;

    @Override
    public void run() {


        while(!exit) {

            System.out.println("***** Spinning up ETL ********");
            List<String> argList = new ArrayList<>();

            String file = getTopologyFilePath(TOPOLOGY_CONFIG_FILENAME);
            argList.add(file);

            file = getTopologyFilePath(LOCAL_FILTER_FILENAME);
            argList.add("--filter");
            argList.add(file);
            argList.add("--sleep");
            argList.add("30000000");

            String[] fluxArgs = argList.toArray(new String[argList.size()]);
            try {

                Flux.main(fluxArgs);

            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(Integer.parseInt(msToWaitStartETL));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
       }

    }

    private static String getTopologyFilePath(String fileName) {
        return MethodHandles.lookup().lookupClass().getClassLoader().getResource(fileName).getFile();
    }

    public void stopEtl() {
        exit = true;
    }

}
