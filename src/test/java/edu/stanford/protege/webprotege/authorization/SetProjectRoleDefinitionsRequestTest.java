package edu.stanford.protege.webprotege.authorization;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SetProjectRoleDefinitionsRequestTest {

    private JacksonTester<SetProjectRoleDefinitionsRequest> tester;

    @BeforeEach
    void setUp() {
        var mapper = new ObjectMapper();
        JacksonTester.initFields(this, mapper);
    }

    @Test
    void shouldSerialize() throws IOException {
        var projectId = ProjectId.valueOf("12345678-1234-5678-1234-567812345678");
        var roleDefinitions = List.of(
            new RoleDefinition(
                RoleId.valueOf("test-role"),
                Set.of(RoleId.valueOf("parent-role")),
                Set.of(BasicCapability.valueOf("ViewProject")),
                "Test role description"
            )
        );
        var request = SetProjectRoleDefinitionsRequest.get(projectId, roleDefinitions);

        var jsonContent = tester.write(request);

        assertThat(jsonContent).extractingJsonPathStringValue("$.@type").isEqualTo("webprotege.authorization.SetProjectRoleDefinitions");
        assertThat(jsonContent).extractingJsonPathStringValue("$.projectId").isEqualTo("12345678-1234-5678-1234-567812345678");
        assertThat(jsonContent).extractingJsonPathArrayValue("$.roleDefinitions").hasSize(1);
    }

    @Test
    void shouldDeserialize() throws IOException {
        var jsonContent = """
            {
                "@type": "webprotege.authorization.SetProjectRoleDefinitions",
                "projectId": "12345678-1234-5678-1234-567812345678",
                "roleDefinitions": [
                    {
                        "roleId": "test-role",
                        "parentRoles": ["parent-role"],
                        "roleCapabilities": [
                            {
                                "@type": "BasicCapability",
                                "id": "ViewProject"
                            }
                        ],
                        "description": "Test role description"
                    }
                ]
            }
            """;

        var deserialized = tester.parse(jsonContent).getObject();

        assertThat(deserialized.projectId()).isEqualTo(ProjectId.valueOf("12345678-1234-5678-1234-567812345678"));
        assertThat(deserialized.roleDefinitions()).hasSize(1);
        assertThat(deserialized.getChannel()).isEqualTo("webprotege.authorization.SetProjectRoleDefinitions");
    }
} 