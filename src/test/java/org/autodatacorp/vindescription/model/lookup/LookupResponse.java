package org.autodatacorp.vindescription.model.lookup;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LookupResponse implements Serializable {
	
	private static final long serialVersionUID = 1079274125000921996L;

    private List<VehicleInfo> vehicles;
    private List<BaseFeatures> packages;
    private List<BaseFeatures> techSpecs;
    private List<BaseFeatures> features;
    private List<Color> exteriorColors;
    private List<Color> interiorColors;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<VehicleInfo> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<VehicleInfo> vehicles) {
        this.vehicles = vehicles;
    }

    public List<BaseFeatures> getPackages() {
        return packages;
    }

    public void setPackages(List<BaseFeatures> packages) {
        this.packages = packages;
    }

    public List<BaseFeatures> getTechSpecs() {
        return techSpecs;
    }

    public void setTechSpecs(List<BaseFeatures> techSpecs) {
        this.techSpecs = techSpecs;
    }

    public List<BaseFeatures> getFeatures() {
        return features;
    }

    public void setFeatures(List<BaseFeatures> features) {
        this.features = features;
    }

    public List<Color> getExteriorColors() {
        return exteriorColors;
    }

    public void setExteriorColors(List<Color> exteriorColors) {
        this.exteriorColors = exteriorColors;
    }

    public List<Color> getInteriorColors() {
        return interiorColors;
    }

    public void setInteriorColors(List<Color> interiorColors) {
        this.interiorColors = interiorColors;
    }

}
