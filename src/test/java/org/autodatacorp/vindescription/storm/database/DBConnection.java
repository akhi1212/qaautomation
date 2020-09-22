package org.autodatacorp.vindescription.storm.database;

import net.thucydides.core.annotations.Shared;
import org.autodatacorp.vindescription.common.SharedContext;
import org.autodatacorp.vindescription.storm.steps.PassValidConfigurationStormSteps;

import java.sql.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


public class DBConnection {

    @Shared
    private SharedContext context;
    private PassValidConfigurationStormSteps pvvs = new PassValidConfigurationStormSteps();
    private Connection connection;
    private String host;
    private String dbname;
    private String username;
    private String password;


    public DBConnection(String host, String dbname, String username, String password) {
        this.host = host;
        this.dbname = dbname;
        this.username = username;
        this.password = password;
    }

    DBConnection(ConnectionBuilder builder) {
        this.connection = builder.getConnection();
        this.dbname = builder.getDbname();
        this.host = builder.getHost();
        this.username = builder.getUsername();
        this.password = builder.getPassword();
    }


    public boolean getConnection() throws SQLException, ClassNotFoundException {
        if (host.isEmpty() || dbname.isEmpty() || username.isEmpty() || password.isEmpty()) {
            throw new SQLException("Missing database credentials");
        }
        Class.forName("com.mysql.jdbc.Driver");
        this.connection = DriverManager.getConnection(this.host + this.dbname, this.username, this.password);
        return true;

    }

    public void closeConnection()  {
        try {
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<String> executeQueryForJsonAfterTopic(String sqlQuery, String[] styles) {

        PreparedStatement ps = null;
        ResultSet resultSet;
        Instant timestamp;
        String lastUpdated;

        try {

            ps = connection.prepareStatement(sqlQuery);

            for(int i = 1; i <=styles.length; i++){
                ps.setInt(i, Integer.parseInt(styles[i-1]));
            }

            resultSet = ps.executeQuery();
            List<String> responseList = new ArrayList<>();

            while (resultSet.next()) {
                String jsonResponse = resultSet.getString("vehsummaryresponse");
                lastUpdated = resultSet.getString("lastupdated");
                timestamp = pvvs.getTimeStamp();
                String trimmedTime = timestamp.toString().replaceAll("[TZ]", " ");
                int compare = trimmedTime.compareTo(lastUpdated);
                if (compare < 0) {
                    responseList.add(jsonResponse);
                }
            }

            try{
                resultSet.close();
            } catch(SQLException e){}

            return responseList;
        } catch (SQLException sql) {
            sql.printStackTrace();
        }finally{
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }



    public List<String> executeQueryForJson(String sqlQuery, String[] styles) {

        PreparedStatement ps = null;
        ResultSet resultSet;

        try {

            ps = connection.prepareStatement(sqlQuery);

            for(int i = 1; i <=styles.length; i++){
                ps.setInt(i, Integer.parseInt(styles[i-1]));
            }

            resultSet = ps.executeQuery();
            List<String> responseList = new ArrayList<>();

            while (resultSet.next()) {
                String jsonResponse = resultSet.getString("vehsummaryresponse");
                responseList.add(jsonResponse);
            }

            try{
                resultSet.close();
            } catch(SQLException e){}

            return responseList;
        } catch (SQLException sql) {
            sql.printStackTrace();
        }finally{
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }


    public void executeQueryForDeleteStyleId(String sqlQuery, String[] styles){

        PreparedStatement preparedStmt = null;
        int resultSet = 0;

        try {
            preparedStmt = connection.prepareStatement(sqlQuery);

            for(int i = 1; i <=styles.length; i++){
                preparedStmt.setInt(i, Integer.parseInt(styles[i-1]));
            }

            resultSet = preparedStmt.executeUpdate();
            preparedStmt.execute();
            preparedStmt.close();

        } catch (SQLException sql) {
            sql.printStackTrace();
        }
    }




}
