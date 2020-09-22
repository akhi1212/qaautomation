package org.autodatacorp.vindescription.model.lookup;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseFeatures implements Serializable {

    private String featureId;
    private String featureKey;
    private String featureCode;
    private String subSectionId;
    private String subSectionName;
    private String sectionName;
    private String featureIdName;
    private Integer subSectionRank;
    private Integer featureImgClassificationId;
    private String featureImgClassification;
    private boolean has3DAnimation;
    private String sectionId;
    private String searchKeys;
    private String featureName;
    private double featureRank;
    private String geoId;
    private String ecc;
    private String specSegments;
    private String featureIconType;
    private String featureIconText;
    private double featureValue;
    private boolean standardCertain;
    private boolean built;
    private List<String> featureKeyAnswers;
    private boolean adasFeature;
    private List<String> icCodeAnswers;
    private String featureKeyNoBrand;
    private List<Style> styles;
    private List<String> optionCodes;
    private List<String> changeOptions;
    private List<String> brandCodes;
    private String featureNameNoBrand;

    public BaseFeatures(){
        //Empty constructor
    }

    public String getFeatureId() {
        return featureId;
    }

    public void setFeatureId(String featureId) {
        this.featureId = featureId;
    }

    public String getFeatureKey() {
        return featureKey;
    }

    public void setFeatureKey(String featureKey) {
        this.featureKey = featureKey;
    }

    public String getFeatureCode() {
        return featureCode;
    }

    public void setFeatureCode(String featureCode) {
        this.featureCode = featureCode;
    }

    public String getSubSectionId() {
        return subSectionId;
    }

    public void setSubSectionId(String subSectionId) {
        this.subSectionId = subSectionId;
    }

    public String getSubSectionName() {
        return subSectionName;
    }

    public void setSubSectionName(String subSectionName) {
        this.subSectionName = subSectionName;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getFeatureIdName() {
        return featureIdName;
    }

    public void setFeatureIdName(String featureIdName) {
        this.featureIdName = featureIdName;
    }

    public Integer getSubSectionRank() {
        return subSectionRank;
    }

    public void setSubSectionRank(Integer subSectionRank) {
        this.subSectionRank = subSectionRank;
    }

    public Integer getFeatureImgClassificationId() {
        return featureImgClassificationId;
    }

    public void setFeatureImgClassificationId(Integer featureImgClassificationId) {
        this.featureImgClassificationId = featureImgClassificationId;
    }

    public String getFeatureImgClassification() {
        return featureImgClassification;
    }

    public void setFeatureImgClassification(String featureImgClassification) {
        this.featureImgClassification = featureImgClassification;
    }

    public boolean isHas3DAnimation() {
        return has3DAnimation;
    }

    public void setHas3DAnimation(boolean has3DAnimation) {
        this.has3DAnimation = has3DAnimation;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public String getSearchKeys() {
        return searchKeys;
    }

    public void setSearchKeys(String searchKeys) {
        this.searchKeys = searchKeys;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public double getFeatureRank() {
        return featureRank;
    }

    public void setFeatureRank(double featureRank) {
        this.featureRank = featureRank;
    }

    public String getGeoId() {
        return geoId;
    }

    public void setGeoId(String geoId) {
        this.geoId = geoId;
    }

    public String getEcc() {
        return ecc;
    }

    public void setEcc(String ecc) {
        this.ecc = ecc;
    }

    public String getSpecSegments() {
        return specSegments;
    }

    public void setSpecSegments(String specSegments) {
        this.specSegments = specSegments;
    }

    public String getFeatureIconType() {
        return featureIconType;
    }

    public void setFeatureIconType(String featureIconType) {
        this.featureIconType = featureIconType;
    }

    public String getFeatureIconText() {
        return featureIconText;
    }

    public void setFeatureIconText(String featureIconText) {
        this.featureIconText = featureIconText;
    }

    public double getFeatureValue() {
        return featureValue;
    }

    public void setFeatureValue(double featureValue) {
        this.featureValue = featureValue;
    }

    public boolean isStandardCertain() {
        return standardCertain;
    }

    public void setStandardCertain(boolean standardCertain) {
        this.standardCertain = standardCertain;
    }

    public boolean isBuilt() {
        return built;
    }

    public void setBuilt(boolean built) {
        this.built = built;
    }

    public List<String> getFeatureKeyAnswers() {
        return featureKeyAnswers;
    }

    public void setFeatureKeyAnswers(List<String> featureKeyAnswers) {
        this.featureKeyAnswers = featureKeyAnswers;
    }

    public boolean isAdasFeature() {
        return adasFeature;
    }

    public void setAdasFeature(boolean adasFeature) {
        this.adasFeature = adasFeature;
    }

    public List<String> getIcCodeAnswers() {
        return icCodeAnswers;
    }

    public void setIcCodeAnswers(List<String> icCodeAnswers) {
        this.icCodeAnswers = icCodeAnswers;
    }

    public String getFeatureKeyNoBrand() {
        return featureKeyNoBrand;
    }

    public void setFeatureKeyNoBrand(String featureKeyNoBrand) {
        this.featureKeyNoBrand = featureKeyNoBrand;
    }

    public List<Style> getStyles() {
        return styles;
    }

    public void setStyles(List<Style> styles) {
        this.styles = styles;
    }

    public List<String> getOptionCodes() {
        return optionCodes;
    }

    public void setOptionCodes(List<String> optionCodes) {
        this.optionCodes = optionCodes;
    }

    public List<String> getChangeOptions() {
        return changeOptions;
    }

    public void setChangeOptions(List<String> changeOptions) {
        this.changeOptions = changeOptions;
    }

    public List<String> getBrandCodes() {
        return brandCodes;
    }

    public void setBrandCodes(List<String> brandCodes) {
        this.brandCodes = brandCodes;
    }

    public String getFeatureNameNoBrand() {
        return featureNameNoBrand;
    }

    public void setFeatureNameNoBrand(String featureNameNoBrand) {
        this.featureNameNoBrand = featureNameNoBrand;
    }
}
