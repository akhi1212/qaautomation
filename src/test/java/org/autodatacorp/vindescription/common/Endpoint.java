package org.autodatacorp.vindescription.common;

import net.thucydides.core.util.SystemEnvironmentVariables;

public enum Endpoint {


    runtimecrmversion( "version",
            "runtimecrmversion.json"),
    vinidcassandrahealth("health",
            "cassandrahealth.json"),

    vindescriptionservicehealth("rest/misc/health",
            "vindescriptionhealth.json"),

    vindescriptionservicevin("rest/vin/{vin}",
            "vindescriptionvin.json"),

    vindescriptionserviceswagger("v2/vinDescription",
            "vindescriptionvin.json"),

    vindescriptionserviceswaggerwithparam("v2/vinDescription/{swagger}",
            "vindescriptionvin.json"),

    vindescriptionserviceconnection("misc/connections",
            "vindescriptionconnection.json");


    private final String templatePath;
    private final String defaultSchema;

    Endpoint(String templatePath, String defaultSchema){
        this.templatePath = templatePath;
        this.defaultSchema = defaultSchema;
    }

    public String getDefaultSchema() {
        String baseFolder = SystemEnvironmentVariables.createEnvironmentVariables().getProperty("response.schemas.folder");
        return baseFolder + defaultSchema;
    }

    public String getTemplatePath() {
        return templatePath;
    }

}
