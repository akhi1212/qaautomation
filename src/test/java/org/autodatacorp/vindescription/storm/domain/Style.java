package org.autodatacorp.vindescription.storm.domain;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "styleIds",
        "optCodes",
        "changeOptions",
        "asIccStandardCertain",
        "asBuiltCertain",
        "asStandardCertain",
        "asStandardChangeable",
        "asAvailable"
})
public class Style {

    @JsonProperty("styleIds")
    private List<String> styleIds = null;
    @JsonProperty("optCodes")
    private List<Object> optCodes = null;
    @JsonProperty("changeOptions")
    private List<Object> changeOptions = null;
    @JsonProperty("asIccStandardCertain")
    private Boolean asIccStandardCertain;
    @JsonProperty("asBuiltCertain")
    private Boolean asBuiltCertain;
    @JsonProperty("asStandardCertain")
    private Boolean asStandardCertain;
    @JsonProperty("asStandardChangeable")
    private Boolean asStandardChangeable;
    @JsonProperty("asAvailable")
    private Boolean asAvailable;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("styleIds")
    public List<String> getStyleIds() {
        return styleIds;
    }

    @JsonProperty("styleIds")
    public void setStyleIds(List<String> styleIds) {
        this.styleIds = styleIds;
    }

    @JsonProperty("optCodes")
    public List<Object> getOptCodes() {
        return optCodes;
    }

    @JsonProperty("optCodes")
    public void setOptCodes(List<Object> optCodes) {
        this.optCodes = optCodes;
    }

    @JsonProperty("changeOptions")
    public List<Object> getChangeOptions() {
        return changeOptions;
    }

    @JsonProperty("changeOptions")
    public void setChangeOptions(List<Object> changeOptions) {
        this.changeOptions = changeOptions;
    }

    @JsonProperty("asIccStandardCertain")
    public Boolean getAsIccStandardCertain() {
        return asIccStandardCertain;
    }

    @JsonProperty("asIccStandardCertain")
    public void setAsIccStandardCertain(Boolean asIccStandardCertain) {
        this.asIccStandardCertain = asIccStandardCertain;
    }

    @JsonProperty("asBuiltCertain")
    public Boolean getAsBuiltCertain() {
        return asBuiltCertain;
    }

    @JsonProperty("asBuiltCertain")
    public void setAsBuiltCertain(Boolean asBuiltCertain) {
        this.asBuiltCertain = asBuiltCertain;
    }

    @JsonProperty("asStandardCertain")
    public Boolean getAsStandardCertain() {
        return asStandardCertain;
    }

    @JsonProperty("asStandardCertain")
    public void setAsStandardCertain(Boolean asStandardCertain) {
        this.asStandardCertain = asStandardCertain;
    }

    @JsonProperty("asStandardChangeable")
    public Boolean getAsStandardChangeable() {
        return asStandardChangeable;
    }

    @JsonProperty("asStandardChangeable")
    public void setAsStandardChangeable(Boolean asStandardChangeable) {
        this.asStandardChangeable = asStandardChangeable;
    }

    @JsonProperty("asAvailable")
    public Boolean getAsAvailable() {
        return asAvailable;
    }

    @JsonProperty("asAvailable")
    public void setAsAvailable(Boolean asAvailable) {
        this.asAvailable = asAvailable;
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