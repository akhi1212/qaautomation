package org.autodatacorp.vindescription.storm.domain;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "styleId",
        "year",
        "make",
        "model",
        "trim",
        "styleDescription",
        "baseMsrp",
        "drive",
        "bodyType",
        "wheelbase"
})
public class Vehicle {

    @JsonProperty("styleId")
    private String styleId;
    @JsonProperty("year")
    private String year;
    @JsonProperty("make")
    private String make;
    @JsonProperty("model")
    private String model;
    @JsonProperty("trim")
    private String trim;
    @JsonProperty("styleDescription")
    private String styleDescription;
    @JsonProperty("baseMsrp")
    private Double baseMsrp;
    @JsonProperty("drive")
    private String drive;
    @JsonProperty("bodyType")
    private String bodyType;
    @JsonProperty("wheelbase")
    private String wheelbase;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("styleId")
    public String getStyleId() {
        return styleId;
    }

    @JsonProperty("styleId")
    public void setStyleId(String styleId) {
        this.styleId = styleId;
    }

    @JsonProperty("year")
    public String getYear() {
        return year;
    }

    @JsonProperty("year")
    public void setYear(String year) {
        this.year = year;
    }

    @JsonProperty("make")
    public String getMake() {
        return make;
    }

    @JsonProperty("make")
    public void setMake(String make) {
        this.make = make;
    }

    @JsonProperty("model")
    public String getModel() {
        return model;
    }

    @JsonProperty("model")
    public void setModel(String model) {
        this.model = model;
    }

    @JsonProperty("trim")
    public String getTrim() {
        return trim;
    }

    @JsonProperty("trim")
    public void setTrim(String trim) {
        this.trim = trim;
    }

    @JsonProperty("styleDescription")
    public String getStyleDescription() {
        return styleDescription;
    }

    @JsonProperty("styleDescription")
    public void setStyleDescription(String styleDescription) {
        this.styleDescription = styleDescription;
    }

    @JsonProperty("baseMsrp")
    public Double getBaseMsrp() {
        return baseMsrp;
    }

    @JsonProperty("baseMsrp")
    public void setBaseMsrp(Double baseMsrp) {
        this.baseMsrp = baseMsrp;
    }

    @JsonProperty("drive")
    public String getDrive() {
        return drive;
    }

    @JsonProperty("drive")
    public void setDrive(String drive) {
        this.drive = drive;
    }

    @JsonProperty("bodyType")
    public String getBodyType() {
        return bodyType;
    }

    @JsonProperty("bodyType")
    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    @JsonProperty("wheelbase")
    public String getWheelbase() {
        return wheelbase;
    }

    @JsonProperty("wheelbase")
    public void setWheelbase(String wheelbase) {
        this.wheelbase = wheelbase;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}