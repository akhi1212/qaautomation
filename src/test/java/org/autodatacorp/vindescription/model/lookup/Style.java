package org.autodatacorp.vindescription.model.lookup;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Style implements Serializable {
	
	private static final long serialVersionUID = -6965948302007137087L;
	
	private List<String> styleIds;
	private List<String> optCodes = Collections.emptyList();
    private List<String> changeOptions = Collections.emptyList();
    private boolean asIccStandardCertain = false;
    private boolean asBuiltCertain;
    private boolean asStandardCertain;
    private boolean asStandardChangeable;
    private boolean asAvailable;

    public List<String> getStyleIds() {
        return styleIds;
    }

    public void setStyleIds(List<String> styleIds) {
        this.styleIds = styleIds;
    }

    @JsonProperty(value = "optCodes", required = false)
    @JsonIgnore
    public List<String> getOptCodes() {
        return optCodes;
    }

    @JsonProperty(value = "optCodes")
    public void setOptCodes(List<String> optCodes) {
        this.optCodes = optCodes;
    }

    @JsonProperty(value = "changeOptions", required = false)
    @JsonIgnore
    public List<String> getChangeOptions() {
        return changeOptions;
    }

    public void setChangeOptions(List<String> changeOptions) {
        this.changeOptions = changeOptions;
    }

    public boolean isAsBuiltCertain() {
        return asBuiltCertain;
    }

    public void setAsBuiltCertain(boolean asBuiltCertain) {
        this.asBuiltCertain = asBuiltCertain;
    }

    public boolean isAsStandardCertain() {
        return asStandardCertain;
    }

    public void setAsStandardCertain(boolean asStandardCertain) {
        this.asStandardCertain = asStandardCertain;
    }

    public boolean isAsStandardChangeable() {
        return asStandardChangeable;
    }

    public boolean isAsIccStandardCertain() {
        return asIccStandardCertain;
    }

    public void setAsIccStandardCertain(boolean asIccStandardCertain) {
        this.asIccStandardCertain = asIccStandardCertain;
    }

    public void setAsStandardChangeable(boolean asStandardChangeable) {
        this.asStandardChangeable = asStandardChangeable;
    }

    public boolean isAsAvailable() {
        return asAvailable;
    }

    public void setAsAvailable(boolean asAvailable) {
        this.asAvailable = asAvailable;
    }

}
