package org.autodatacorp.vindescription.storm.database;

import java.io.IOException;

public class DatabaseUtility {


    public DBConnection getValidDbConnection() {
        try {
            ConfigDatabase configDb = new ConfigDatabase();
           String host =  configDb.getHost();
            DBConnection databaseConnection = null;


            databaseConnection = new ConnectionBuilder()
                    .withHost(configDb.getHost())
                    .withDbName(configDb.getDBName())
                    .withUsername(configDb.getUsername())
                    .withPassword(configDb.getPassword())
                    .build();

            return databaseConnection;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }


}
