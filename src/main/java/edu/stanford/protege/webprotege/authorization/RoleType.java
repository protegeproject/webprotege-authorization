package edu.stanford.protege.webprotege.authorization;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum RoleType {

    @JsonProperty("ApplicationRole")
    APPLICATION_ROLE,

    @JsonProperty("ProjectRole")
    PROJECT_ROLE
}
