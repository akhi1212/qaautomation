package org.autodatacorp.vindescription.service.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class VdsResponse {

    private VinResponse result;

    public VinResponse getResult() {
        return result;
    }

    public void setResult(VinResponse result) {
        this.result = result;
    }
}
