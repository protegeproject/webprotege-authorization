package edu.stanford.protege.webprotege.authorization;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-08-05
 */
@JsonTest
public class ActionId_Serialization_Tests {

    public static final String ID = "CreateClasses";

    @Autowired
    private JacksonTester<Capability> tester;

    @Test
    void shouldSerializeToJson() throws IOException {
        var actionId = BasicCapability.valueOf(ID);
        var written = tester.write(actionId);
        assertThat(written).extractingJsonPathStringValue("['@type']")
                .isEqualTo("BasicCapability");
        assertThat(written).extractingJsonPathStringValue("id", "CreateClasses");
    }

    @Test
    void shouldDeserializeFromJson() throws IOException {
        var json = """
                {
                    "@type" : "BasicCapability",
                    "id" : "CreateClasses"
                }
                """;
        var parsed = tester.parse(json);
        var capability = parsed.getObject();
        assertThat(capability.id()).isEqualTo(ID);
    }

}
