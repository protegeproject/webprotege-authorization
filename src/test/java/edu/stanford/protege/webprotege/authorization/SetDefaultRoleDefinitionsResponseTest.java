package edu.stanford.protege.webprotege.authorization;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SetDefaultRoleDefinitionsResponseTest {

    private JacksonTester<SetDefaultRoleDefinitionsResponse> tester;

    @BeforeEach
    void setUp() {
        ObjectMapper mapper = new ObjectMapper();
        JacksonTester.initFields(this, mapper);
    }

    @Test
    void shouldSerialize() throws IOException {
        var roleDefinition = RoleDefinition.get(
                RoleId.valueOf("TestRole"),
                RoleType.PROJECT_ROLE,
                Set.of(RoleId.valueOf("ParentRole")),
                Set.of(BasicCapability.valueOf("EditOntology")),
                "Test label",
                "Test Description"
        );
        var response = SetDefaultRoleDefinitionsResponse.get(List.of(roleDefinition));
        JsonContent<SetDefaultRoleDefinitionsResponse> json = tester.write(response);
        assertThat(json).hasJsonPathStringValue("$.@type", "webprotege.authorization.SetDefaultRoleDefinitions");
        assertThat(json).hasJsonPathArrayValue("$.roleDefinitions");
        assertThat(json).extractingJsonPathArrayValue("$.roleDefinitions").hasSize(1);
    }

    @Test
    void shouldDeserialize() throws IOException {
        var json = """
                {
                    "@type": "webprotege.authorization.SetDefaultRoleDefinitions",
                    "roleDefinitions": [
                        {
                            "roleId": "TestRole",
                            "roleType": "ProjectRole",
                            "parentRoles": ["ParentRole"],
                            "roleCapabilities": [{"@type":"BasicCapability","id":"EditOntology"}],
                            "description": "Test Description"
                        }
                    ]
                }
                """;
        var response = tester.parse(json).getObject();
        assertThat(response.roleDefinitions()).hasSize(1);
    }
} 