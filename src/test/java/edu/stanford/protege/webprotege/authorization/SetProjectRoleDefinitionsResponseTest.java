package edu.stanford.protege.webprotege.authorization;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SetProjectRoleDefinitionsResponseTest {

    private JacksonTester<SetProjectRoleDefinitionsResponse> tester;

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
        var response = SetProjectRoleDefinitionsResponse.get(roleDefinitions);

        var jsonContent = tester.write(response);

        assertThat(jsonContent).extractingJsonPathArrayValue("$.roleDefinitions").hasSize(1);
    }

    @Test
    void shouldDeserialize() throws IOException {
        var jsonContent = """
            {
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