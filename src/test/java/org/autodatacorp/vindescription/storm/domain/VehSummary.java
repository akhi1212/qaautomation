package org.autodatacorp.vindescription.storm.domain;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "vehicles",
        "engines",
        "fuelTypes",
        "transmissions",
        "exteriorColors",
        "interiorColors",
        "options"
})
public class VehSummary {

    @JsonProperty("vehicles")
    private List<Vehicle> vehicles = null;
    @JsonProperty("engines")
    private List<Engine> engines = null;
    @JsonProperty("fuelTypes")
    private List<FuelType> fuelTypes = null;
    @JsonProperty("transmissions")
    private List<Transmission> transmissions = null;
    @JsonProperty("exteriorColors")
    private List<Object> exteriorColors = null;
    @JsonProperty("interiorColors")
    private List<Object> interiorColors = null;
    @JsonProperty("options")
    private List<Object> options = null;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("vehicles")
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    @JsonProperty("vehicles")
    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @JsonProperty("engines")
    public List<Engine> getEngines() {
        return engines;
    }

    @JsonProperty("engines")
    public void setEngines(List<Engine> engines) {
        this.engines = engines;
    }

    @JsonProperty("fuelTypes")
    public List<FuelType> getFuelTypes() {
        return fuelTypes;
    }

    @JsonProperty("fuelTypes")
    public void setFuelTypes(List<FuelType> fuelTypes) {
        this.fuelTypes = fuelTypes;
    }

    @JsonProperty("transmissions")
    public List<Transmission> getTransmissions() {
        return transmissions;
    }

    @JsonProperty("transmissions")
    public void setTransmissions(List<Transmission> transmissions) {
        this.transmissions = transmissions;
    }

    @JsonProperty("exteriorColors")
    public List<Object> getExteriorColors() {
        return exteriorColors;
    }

    @JsonProperty("exteriorColors")
    public void setExteriorColors(List<Object> exteriorColors) {
        this.exteriorColors = exteriorColors;
    }

    @JsonProperty("interiorColors")
    public List<Object> getInteriorColors() {
        return interiorColors;
    }

    @JsonProperty("interiorColors")
    public void setInteriorColors(List<Object> interiorColors) {
        this.interiorColors = interiorColors;
    }

    @JsonProperty("options")
    public List<Object> getOptions() {
        return options;
    }

    @JsonProperty("options")
    public void setOptions(List<Object> options) {
        this.options = options;
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