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

class GetProjectRoleDefinitionsResponseTest {

    private JacksonTester<GetProjectRoleDefinitionsResponse> tester;

    @BeforeEach
    void setUp() {
        var mapper = new ObjectMapper();
        JacksonTester.initFields(this, mapper);
    }

    @Test
    void shouldSerialize() throws IOException {
        var roleDefinitions = List.of(
            new RoleDefinition(
                RoleId.valueOf("test-role"),
                RoleType.PROJECT_ROLE,
                Set.of(RoleId.valueOf("parent-role")),
                Set.of(BasicCapability.valueOf("ViewProject")),
                    "Test label",
                "Test role description"
            )
        );
        var response = GetProjectRoleDefinitionsResponse.get(ProjectId.generate(), roleDefinitions);

        var jsonContent = tester.write(response);
        assertThat(jsonContent).extractingJsonPathArrayValue("$.roleDefinitions").hasSize(1);
    }

    @Test
    void shouldDeserialize() throws IOException {
        var jsonContent = """
            {
                "projectId" : "10bbf8a0-b360-4e37-897d-7ee8629e6b3f",
                "roleDefinitions": [
                    {
                        "roleId": "test-role",
                        "roleType": "ProjectRole",
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

        assertThat(deserialized.roleDefinitions()).hasSize(1);
        assertThat(deserialized.roleDefinitions().get(0).roleId()).isEqualTo(RoleId.valueOf("test-role"));
    }
} 