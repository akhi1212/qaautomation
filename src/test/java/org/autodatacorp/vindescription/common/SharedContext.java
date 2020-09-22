package org.autodatacorp.vindescription.common;

import net.serenitybdd.screenplay.Actor;

public class SharedContext {

    private Actor actor;
    private Endpoint endpoint;
    private String timeStamp;

    public Actor getActor() {
        return actor;
    }

    public Endpoint getEndpoint() {
        return endpoint;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public void setEndpoint(Endpoint endpoint) {
        this.endpoint = endpoint;
    }

    public void setTimeStamp(String timeStamp){
        this.timeStamp = timeStamp;
    }

    public String getTimeStamp() {
        return timeStamp;
    }
}
