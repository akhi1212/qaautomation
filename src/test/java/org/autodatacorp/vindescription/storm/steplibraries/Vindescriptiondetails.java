package org.autodatacorp.vindescription.storm.steplibraries;


import com.fasterxml.jackson.databind.ObjectMapper;
import net.thucydides.core.annotations.Step;
import org.autodatacorp.vindescription.common.Util;
import org.autodatacorp.vindescription.storm.database.DBConnection;
import org.autodatacorp.vindescription.storm.database.DatabaseUtility;
import org.autodatacorp.vindescription.storm.domain.QueryStore;
import org.autodatacorp.vindescription.storm.domain.VehSummary;
import org.autodatacorp.vindescription.storm.domain.Vehicle;
import org.autodatacorp.vindescription.storm.util.Constants;
import org.autodatacorp.vindescription.storm.util.RunEtl;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class Vindescriptiondetails {


    private String waitMs = Util.getEnvironmentProperty("ms.to.wait.etl");
    private String numTries = Util.getEnvironmentProperty("num.tries.etl");
    private final String stormEnvironment = Util.getEnvironmentProperty("storm.environment");
    private static final Pattern MY_PATTERN = Pattern.compile("\\(.*?\\)");

    @Step("has valid connection to the database")
    public DBConnection getConnectionToDatabase(){
        DatabaseUtility dbUtil = new DatabaseUtility();
        return dbUtil.getValidDbConnection();
    }


    /**
     * This method is for checking the db for style id after the topic is pushed
     * to the storm etl
     * @param dbConnect
     * @param styleId
     * @return
     */
    @Step("Get vehicle summary response query after pushing topic")
    public List<String> getQueryForVehicleSummaryResponseAfterTopic(DBConnection dbConnect, String[] styleId){

        int count = 0;
        List<String> vehSummaryResponse = new ArrayList<>();
        QueryStore queryStore = new QueryStore();
        String query = queryStore.getVehSummaryQuery();
        String queryBuilder = buildQuery(query, styleId.length);

        try {
            if (dbConnect.getConnection()) {

                for (int i = 0; i < Integer.parseInt(numTries); i++) {
                    count = count + 1;
                    vehSummaryResponse.addAll(dbConnect.executeQueryForJsonAfterTopic(queryBuilder, styleId));
                    System.out.println("Vehicle summary response for styles found : " + vehSummaryResponse.size() + " / " + styleId.length);

                    if (vehSummaryResponse.size() < styleId.length) {
                        System.out.println("Working...");
                        System.out.println("Checking db for styles - num tries: " + count + " / " + numTries);
                        makeThreadSleep();
                    } else{
                        break;
                    }
                }
                if (vehSummaryResponse.size() < styleId.length) {
                    assertEquals("***All GVUID not proccesed in the db after pushing topic  ***\n",  styleId.length,  vehSummaryResponse.size());
                }
            }

            if (stormEnvironment.equalsIgnoreCase(Constants.STORM_ENVIRONMENT_LOCAL)) {
                System.out.println("Shutting down ETL");
                RunEtl runEtl = new RunEtl();
                runEtl.stopEtl();
            }
            dbConnect.closeConnection();
            return vehSummaryResponse;
        } catch (ClassNotFoundException | SQLException classEx) {
            classEx.printStackTrace();
        } finally {
            if(dbConnect != null){
                dbConnect.closeConnection();
            }
        }
        return vehSummaryResponse;
    }

    /**
     * This method is for direct access to the db for styleid lookup
     * @param dbConnect
     * @param styleId
     * @return
     */
    @Step("Get vehicle summary response query")
    public List<String> getQueryForVehicleSummaryResponse(DBConnection dbConnect, String[] styleId){
        List<String> vehSummaryResponse = new ArrayList<>();
        QueryStore queryStore = new QueryStore();
        String query = queryStore.getVehSummaryQuery();
        String  queryBuilder = buildQuery(query, styleId.length);

        try {
            if (dbConnect.getConnection()) {
                    vehSummaryResponse.addAll(dbConnect.executeQueryForJson(queryBuilder, styleId));
                    System.out.println("Vehicle summary response for styles found : " + vehSummaryResponse.size() + " / " + styleId.length);
                if (vehSummaryResponse.size() < styleId.length) {
                    assertEquals("***All Style id not found in the db  ***\n", styleId.length,  vehSummaryResponse.size());
                }
            }
            dbConnect.closeConnection();
            return vehSummaryResponse;
        } catch (ClassNotFoundException | SQLException cnfex) {
            cnfex.printStackTrace();
        } finally {
            if(dbConnect != null){
                dbConnect.closeConnection();
            }
        }
        return vehSummaryResponse;
    }


    private String buildQuery(String query, int size){

        StringBuilder queryBuilder = new StringBuilder(query);
        StringBuilder strReturn = new StringBuilder();
        strReturn.append("(");

        for( int i = 0; i < size; i++){
            strReturn.append(" ?");
            if(i != size -1) strReturn.append(",");
        }

        String appended = strReturn.append(" )").toString();
        Matcher m = MY_PATTERN.matcher(queryBuilder);
        queryBuilder.replace(0, queryBuilder.length(), m.replaceAll(appended));

        return queryBuilder.toString();
    }



    private void makeThreadSleep(){

        try {
            Thread.sleep(Integer.parseInt(waitMs));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



    @Step("Validate summary response for styleid")
    public void forStyleIdInSummaryResponse(Map<Integer, String> currentResult, String styleIds ) {

        ObjectMapper objectMapper = new ObjectMapper();
        VehSummary veh;
        List<Vehicle> vehList;
        boolean isFound = false;
        String valueJson = "";
        boolean dealsReturnedInd = false;
        String returnedStyleId ="";

        try {
            dealsReturnedInd = validateResponse(currentResult, styleIds);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!dealsReturnedInd) {
            return;
        }

        for (Map.Entry<Integer, String> entry : currentResult.entrySet()) {
            Integer ie = entry.getKey();
            if(String.valueOf(ie).equalsIgnoreCase(styleIds)){
                valueJson = entry.getValue();
            }
        }

        try {
            veh = objectMapper.readValue(valueJson, VehSummary.class);
            vehList = veh.getVehicles();

            for (Vehicle items : vehList) {
                returnedStyleId =  items.getStyleId();
            }

            if(returnedStyleId.equalsIgnoreCase(styleIds)){
                assertTrue("\n*** Style id match***\n" + styleIds + "\n ** styleid in database ** \n" + returnedStyleId, true );
            }

            if(!returnedStyleId.equalsIgnoreCase(styleIds)){
                assertFalse("\n*** Style id  didnt match***\n" + styleIds + "\n ** styleid in database ** \n" + returnedStyleId, true );
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Step("Delete vehicle entry for styleid")
    public void deleteVehSummaryByStyle(DBConnection dbConnect, String[] style){
        QueryStore queryStore = new QueryStore();
        String queryBuilder = buildQuery(queryStore.deleteVehSummaryByStle(), style.length);
        try {

            if (dbConnect.getConnection()) {
              dbConnect.executeQueryForDeleteStyleId(queryBuilder, style);
            }

        }catch (Exception e){
            e.printStackTrace();

        } finally {
            if(dbConnect != null){
                dbConnect.closeConnection();
            }

        }

    }


    private boolean validateResponse(Map<Integer,String> currentResult, String styleIds) throws IOException{
        boolean dealsReturnedInd = true;
        assertNotNull("\n***No summary response returned from the database***\n", currentResult);
        return dealsReturnedInd;
    }



}
