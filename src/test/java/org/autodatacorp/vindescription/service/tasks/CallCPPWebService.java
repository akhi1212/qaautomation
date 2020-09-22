package org.autodatacorp.vindescription.service.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class CallCPPWebService {

    private static EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();


    public static Task withBasicEndpoint(String endpoint) {
        return Task.where("{0} calls the service", Get.resource(endpoint) .with(request -> request.contentType(ContentType.JSON)));
    }




}
