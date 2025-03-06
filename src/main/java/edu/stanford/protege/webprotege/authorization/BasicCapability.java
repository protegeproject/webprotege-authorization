package edu.stanford.protege.webprotege.authorization;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.annotation.Nonnull;
import java.util.Objects;

@JsonTypeName("BasicCapability")
public record BasicCapability(@Nonnull @JsonProperty("id") String id) implements Capability {

    public BasicCapability(String id) {
        this.id = Objects.requireNonNull(id);
    }

    @JsonCreator
    @Nonnull
    public static BasicCapability valueOf(@Nonnull @JsonProperty("id") String id) {
        return new BasicCapability(id);
    }
}
