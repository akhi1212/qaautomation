package org.autodatacorp.vindescription.service.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class VinResponse {

    private String vinSubmitted;
    private String vinProcessed;
    private Boolean validVin;
    private String source;
    private List<Feature> features;
    private List<TechnicalSpecification> techSpecs;
    private List<String> optionCodes;

    public String getVinSubmitted() {
        return vinSubmitted;
    }

    public void setVinSubmitted(String vinSubmitted) {
        this.vinSubmitted = vinSubmitted;
    }

    public String getVinProcessed() {
        return vinProcessed;
    }

    public void setVinProcessed(String vinProcessed) {
        this.vinProcessed = vinProcessed;
    }

    public Boolean getValidVin() {
        return validVin;
    }

    public void setValidVin(Boolean validVin) {
        this.validVin = validVin;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public List<String> getOptionCodes() {
        return optionCodes;
    }

    public void setOptionCodes(List<String> optionCodes) {
        this.optionCodes = optionCodes;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public List<TechnicalSpecification> getTechSpecs() {
        return techSpecs;
    }

    public void setTechSpecs(List<TechnicalSpecification> techSpecs) {
        this.techSpecs = techSpecs;
    }
}
