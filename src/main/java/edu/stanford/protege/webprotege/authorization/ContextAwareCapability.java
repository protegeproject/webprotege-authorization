package edu.stanford.protege.webprotege.authorization;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.criteria.CompositeRootCriteria;

import java.util.*;

public record ContextAwareCapability(
        @JsonProperty("id") String id,
        @JsonProperty("contextCriteria") CompositeRootCriteria contextCriteria
) implements Capability {

    public final static String TYPE = "ContextAwareCapability";

    @Override
    public GenericParameterizedCapability asGenericCapability() {
        return new GenericParameterizedCapability(TYPE, id(), Map.of("contextCriteria", contextCriteria));
    }
}
