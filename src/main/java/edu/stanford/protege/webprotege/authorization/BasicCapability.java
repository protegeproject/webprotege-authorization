package edu.stanford.protege.webprotege.authorization;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Objects;

@JsonTypeName(BasicCapability.BASIC_CAPABILITY)
@JsonIgnoreProperties(ignoreUnknown = true)
public record BasicCapability(@Nonnull @JsonProperty("id") String id) implements Capability {

    public static final String BASIC_CAPABILITY = "BasicCapability";

    @JsonCreator
    public BasicCapability(@JsonProperty("id") String id) {
        this.id = Objects.requireNonNull(id);
    }

    @Nonnull
    public static BasicCapability valueOf(@Nonnull @JsonProperty("id") String id) {
        return new BasicCapability(id);
    }

    @Override
    @Nonnull
    public GenericParameterizedCapability asGenericCapability() {
        return new GenericParameterizedCapability(BASIC_CAPABILITY, id(), new HashMap<>());
    }
}
