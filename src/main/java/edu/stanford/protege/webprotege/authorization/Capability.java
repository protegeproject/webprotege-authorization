package edu.stanford.protege.webprotege.authorization;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, visible = true, defaultImpl = GenericParameterizedCapability.class)
@JsonSubTypes({
        @JsonSubTypes.Type(BasicCapability.class),
        @JsonSubTypes.Type(GenericParameterizedCapability.class),
})
public interface Capability {

    String id();

    GenericParameterizedCapability asGenericCapability();
}