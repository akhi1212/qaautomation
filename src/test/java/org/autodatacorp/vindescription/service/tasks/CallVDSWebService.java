package org.autodatacorp.vindescription.service.tasks;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class CallVDSWebService {


    public static Task withVDSEndpoint(String endpoint) {
        return Task.where("{0} calls the VDS web service", Get.resource(endpoint) .with(request -> request.contentType(ContentType.JSON)));
    }

    public static Task withVDSEndpoint(String endpoint, RequestSpecBuilder requestBuilder) {
        return Task.where("{0} calls the VDS web service",
                Get.resource(endpoint)
                        .with(request -> request.contentType(ContentType.JSON))
                        .with(request -> request.spec(requestBuilder.build())));
    }

    public static Task withVDSEndpointParam(String endpoint, RequestSpecBuilder requestBuilder) {
        return Task.where("{0} calls the VDS web service",
                Get.resource(endpoint)
                        .with(request -> request.contentType(ContentType.ANY))
                        .with(request -> request.spec(requestBuilder.build())));
    }



}
