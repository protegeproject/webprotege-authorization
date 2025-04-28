package edu.stanford.protege.webprotege.authorization;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class GetProjectRoleDefinitionsRequestTest {

    private JacksonTester<GetProjectRoleDefinitionsRequest> tester;

    @BeforeEach
    void setUp() {
        var mapper = new ObjectMapper();
        JacksonTester.initFields(this, mapper);
    }

    @Test
    void shouldSerialize() throws IOException {
        var projectId = ProjectId.valueOf("12345678-1234-5678-1234-567812345678");
        var request = GetProjectRoleDefinitionsRequest.get(projectId);

        var jsonContent = tester.write(request);

        assertThat(jsonContent).extractingJsonPathStringValue("$.projectId").isEqualTo("12345678-1234-5678-1234-567812345678");
    }

    @Test
    void shouldDeserialize() throws IOException {
        var jsonContent = """
            {
                "projectId": "12345678-1234-5678-1234-567812345678"
            }
            """;

        var deserialized = tester.parse(jsonContent).getObject();

        assertThat(deserialized.projectId()).isEqualTo(ProjectId.valueOf("12345678-1234-5678-1234-567812345678"));
        assertThat(deserialized.getChannel()).isEqualTo("webprotege.authorization.GetProjectRoleDefinitions");
    }
} 