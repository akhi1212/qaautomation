package org.autodatacorp.vindescription.storm.domain;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "featureId",
        "featureKey",
        "description",
        "featureKeyAnswers",
        "styles",
        "fuelType",
        "isNumeric",
        "isAdasFeature"
})
public class FuelType {

    @JsonProperty("featureId")
    private Integer featureId;
    @JsonProperty("featureKey")
    private String featureKey;
    @JsonProperty("description")
    private String description;
    @JsonProperty("featureKeyAnswers")
    private List<String> featureKeyAnswers = null;
    @JsonProperty("styles")
    private List<Style> styles = null;
    @JsonProperty("fuelType")
    private String fuelType;
    @JsonProperty("isNumeric")
    private Boolean isNumeric;
    @JsonProperty("isAdasFeature")
    private Boolean isAdasFeature;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("featureId")
    public Integer getFeatureId() {
        return featureId;
    }

    @JsonProperty("featureId")
    public void setFeatureId(Integer featureId) {
        this.featureId = featureId;
    }

    @JsonProperty("featureKey")
    public String getFeatureKey() {
        return featureKey;
    }

    @JsonProperty("featureKey")
    public void setFeatureKey(String featureKey) {
        this.featureKey = featureKey;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("featureKeyAnswers")
    public List<String> getFeatureKeyAnswers() {
        return featureKeyAnswers;
    }

    @JsonProperty("featureKeyAnswers")
    public void setFeatureKeyAnswers(List<String> featureKeyAnswers) {
        this.featureKeyAnswers = featureKeyAnswers;
    }

    @JsonProperty("styles")
    public List<Style> getStyles() {
        return styles;
    }

    @JsonProperty("styles")
    public void setStyles(List<Style> styles) {
        this.styles = styles;
    }

    @JsonProperty("fuelType")
    public String getFuelType() {
        return fuelType;
    }

    @JsonProperty("fuelType")
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @JsonProperty("isNumeric")
    public Boolean getIsNumeric() {
        return isNumeric;
    }

    @JsonProperty("isNumeric")
    public void setIsNumeric(Boolean isNumeric) {
        this.isNumeric = isNumeric;
    }

    @JsonProperty("isAdasFeature")
    public Boolean getIsAdasFeature() {
        return isAdasFeature;
    }

    @JsonProperty("isAdasFeature")
    public void setIsAdasFeature(Boolean isAdasFeature) {
        this.isAdasFeature = isAdasFeature;
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
