package org.autodatacorp.vindescription.model.lookup;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VehicleInfo implements Serializable {
	
	private static final long serialVersionUID = -727762647830018679L;
	
	private String styleId;
    private String year;
    private String make;
    private String model;
    private String trim;
    private String styleDescription;
    private Double baseMsrp;
    private String drive;
    private String bodyType;
    private String wheelbase;
    private Integer standardCurbWeight;
    private Integer standardPayload;
    private Integer standardTowingCapacity;
    private String country;
    private String gvwrLow;
    private Integer standardGVWR;
    private String gvwrHigh;
    private String boxStyle;
    private Integer doors;
    private List<String> segments;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getStyleId() {
        return styleId;
    }

    public void setStyleId(String styleId) {
        this.styleId = styleId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTrim() {
        return trim;
    }

    public void setTrim(String trim) {
        this.trim = trim;
    }

    public String getStyleDescription() {
        return styleDescription;
    }

    public void setStyleDescription(String styleDescription) {
        this.styleDescription = styleDescription;
    }

    public Double getBaseMsrp() {
        return baseMsrp;
    }

    public void setBaseMsrp(Double baseMsrp) {
        this.baseMsrp = baseMsrp;
    }

    public String getDrive() {
        return drive;
    }

    public void setDrive(String drive) {
        this.drive = drive;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getWheelbase() {
        return wheelbase;
    }

    public void setWheelbase(String wheelbase) {
        this.wheelbase = wheelbase;
    }

    public Integer getStandardCurbWeight() {
        return standardCurbWeight;
    }

    public void setStandardCurbWeight(Integer standardCurbWeight) {
        this.standardCurbWeight = standardCurbWeight;
    }

    public Integer getStandardPayload() {
        return standardPayload;
    }

    public void setStandardPayload(Integer standardPayload) {
        this.standardPayload = standardPayload;
    }

    public Integer getStandardTowingCapacity() {
        return standardTowingCapacity;
    }

    public void setStandardTowingCapacity(Integer standardTowingCapacity) {
        this.standardTowingCapacity = standardTowingCapacity;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGvwrLow() {
        return gvwrLow;
    }

    public void setGvwrLow(String gvwrLow) {
        this.gvwrLow = gvwrLow;
    }

    public Integer getStandardGVWR() {
        return standardGVWR;
    }

    public void setStandardGVWR(Integer standardGVWR) {
        this.standardGVWR = standardGVWR;
    }

    public String getGvwrHigh() {
        return gvwrHigh;
    }

    public void setGvwrHigh(String gvwrHigh) {
        this.gvwrHigh = gvwrHigh;
    }

    public String getBoxStyle() {
        return boxStyle;
    }

    public void setBoxStyle(String boxStyle) {
        this.boxStyle = boxStyle;
    }

    public Integer getDoors() {
        return doors;
    }

    public void setDoors(Integer doors) {
        this.doors = doors;
    }

    public List<String> getSegments() {
        return segments;
    }

    public void setSegments(List<String> segments) {
        this.segments = segments;
    }
}
