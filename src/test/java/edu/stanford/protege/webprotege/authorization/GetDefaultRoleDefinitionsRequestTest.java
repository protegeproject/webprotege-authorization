package edu.stanford.protege.webprotege.authorization;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class GetDefaultRoleDefinitionsRequestTest {

    private JacksonTester<GetDefaultRoleDefinitionsRequest> tester;

    @BeforeEach
    void setUp() {
        var mapper = new ObjectMapper();
        JacksonTester.initFields(this, mapper);
    }

    @Test
    void shouldSerialize() throws IOException {
        var request = new GetDefaultRoleDefinitionsRequest();
        var jsonContent = tester.write(request);
        assertThat(jsonContent).extractingJsonPathStringValue("$.['@type']").isEqualTo("webprotege.authorization.GetDefaultRoleDefinitionsRequest");
    }

    @Test
    void shouldDeserialize() throws IOException {
        var jsonContent = """
            {
                "@type": "webprotege.authorization.GetDefaultRoleDefinitionsRequest"
            }
            """;

        var deserialized = tester.parse(jsonContent).getObject();
        assertThat(deserialized).isEqualTo(new GetDefaultRoleDefinitionsRequest());
    }
} 