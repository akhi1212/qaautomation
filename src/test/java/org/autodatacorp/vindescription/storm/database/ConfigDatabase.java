package org.autodatacorp.vindescription.storm.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigDatabase {
    private static Properties configProperty = new Properties();


    public ConfigDatabase() throws IOException {
        configProperty.load(new FileInputStream(".\\src\\test\\resources\\configs\\database.properties"));
    }


    public String getHost() { return configProperty.getProperty("sqlSession.vinDescriptionData.hikariConfig.dataSource.url"); }

    public String getUsername() {
        return configProperty.getProperty("sqlSession.vinDescriptionData.hikariConfig.dataSource.user");
    }

    public String getPassword() {
        return configProperty.getProperty("sqlSession.vinDescriptionData.hikariConfig.dataSource.password");
    }

    public String getDBName() {
        return configProperty.getProperty("sqlSession.vinDescriptionData.hikariConfig.dataSource.dbname");
    }




}
