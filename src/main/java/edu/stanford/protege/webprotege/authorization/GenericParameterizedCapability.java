package edu.stanford.protege.webprotege.authorization;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * A generic representation of a parameterized capability.
 * <p>
 * This record serves as a flexible, JSON-serializable capability type that can hold arbitrary fields
 * in addition to the standard {@code @type} and {@code id} fields. It is intended to be used where the specific
 * polymorphic type is either not required, or cannot be used because there is no mapping to deserialize to.
 * </p>
 * <p>
 * This class is a subtype of {@link Capability} and follows a JSON schema where the capability type
 * is identified by the {@code @type} field, and the unique identifier is provided by the {@code id} field.
 * All additional fields are captured dynamically in the {@code otherFields} map.
 * </p>
 * <p>
 * Example JSON:
 * <pre>
 * {
 *   "@type": "FlibbleCapability",
 *   "id": "EditNamedFlibble",
 *   "customField1": "value1",
 *   "customField2": 42
 * }
 * </pre>
 * </p>
 *
 * @param type        The type of the capability, required. This corresponds to the {@code @type} field in JSON.
 * @param id          The unique identifier for the capability, required.
 * @param otherFields A map containing all additional fields not explicitly modeled, allowing for extensibility.
 */
public record GenericParameterizedCapability(@JsonProperty("@type") String type,
                                             @JsonProperty("id") String id,
                                             @JsonAnyGetter Map<String, Object> otherFields) {

    /**
     * Constructs a new {@code GenericParameterizedCapability}.
     *
     * @param type        The type of the capability, must not be {@code null}.
     * @param id          The unique identifier for the capability, must not be {@code null}.
     * @param otherFields A map of additional fields; may be {@code null}, in which case an empty map is used.
     * @throws NullPointerException if {@code type} or {@code id} is {@code null}.
     */
    @JsonCreator
    public GenericParameterizedCapability(@JsonProperty("@type") String type,
                                          @JsonProperty("id") String id,
                                          Map<String, Object> otherFields) {
        this.type = Objects.requireNonNull(type, "type must not be null");
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.otherFields = Objects.requireNonNullElse(otherFields, new HashMap<>());
    }

    /**
     * Adds an additional field to the capability.
     * <p>
     * This method is used during deserialization to capture fields that are not explicitly
     * modeled as part of this record. These fields are stored in the {@code otherFields} map.
     * </p>
     *
     * @param field The name of the field.
     * @param value The value of the field.
     */
    @JsonAnySetter
    private void set(String field, Object value) {
        this.otherFields.put(field, value);
    }
}

