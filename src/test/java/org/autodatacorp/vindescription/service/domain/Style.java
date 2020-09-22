package org.autodatacorp.vindescription.service.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Style implements Serializable {

    private static final long serialVersionUID = 7326998404661942990L;

    private List<String> styleIds;
    private String installCause;

    public List<String> getStyleIds() {
        return styleIds;
    }

    public void setStyleIds(List<String> styleIds) {
        this.styleIds = styleIds;
    }

    public String getInstallCause() {
        return installCause;
    }

    public void setInstallCause(String installCause) {
        this.installCause = installCause;
    }
}
