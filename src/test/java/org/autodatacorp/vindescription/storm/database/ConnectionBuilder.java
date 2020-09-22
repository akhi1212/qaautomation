package org.autodatacorp.vindescription.storm.database;

import java.sql.Connection;

public class ConnectionBuilder {

    private Connection connection;
    private String host;
    private String dbname;
    private String username;
    private String password;



    public ConnectionBuilder withConnection(Connection connection){
        this.connection = connection;
        return this;
    }

    ConnectionBuilder withHost(String host){
        this.host = host;
        return this;
    }

    ConnectionBuilder withDbName(String dbname){
        this.dbname = dbname;
        return this;
    }


    ConnectionBuilder withUsername(String username){
        this.username = username;
        return this;
    }


    ConnectionBuilder withPassword(String password){
        this.password = password;
        return this;
    }

    DBConnection build(){
       return new DBConnection(this);
    }

    Connection getConnection() {
        return connection;
    }

    String getDbname() {
        return dbname;
    }

    String getHost() {
        return host;
    }

    String getPassword() {
        return password;
    }

    String getUsername() {
        return username;
    }
}
