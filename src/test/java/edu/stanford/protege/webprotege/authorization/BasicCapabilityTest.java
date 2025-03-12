package edu.stanford.protege.webprotege.authorization;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class BasicCapabilityTest {

    private JacksonTester<BasicCapability> tester;

    @BeforeEach
    void setUp() {
        JacksonTester.initFields(this, new ObjectMapper());
    }

    @Test
    void shouldSerializedBasicCapability() {
        var cap = BasicCapability.valueOf("MyCapability");

    }

    @Test
    void shouldDeserializeBasicCapability() throws IOException {
        var json = """
                {
                    "@type": "BasicCapability",
                    "id": "MyCapability"
                }
                """;
        var parsed = tester.parse(json);
        assertThat(parsed).isEqualTo(BasicCapability.valueOf("MyCapability"));
    }
}