package com.junqu.TFDDB.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserOuidResponse {

    @JsonProperty("ouid")
    private String ouid;
}
