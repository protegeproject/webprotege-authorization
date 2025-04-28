package edu.stanford.protege.webprotege.authorization;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class RoleDefinitionTest {

    private JacksonTester<RoleDefinition> tester;

    @BeforeEach
    void setUp() {
        var mapper = new ObjectMapper();
        JacksonTester.initFields(this, mapper);
    }

    @Test
    void shouldSerialize() throws IOException {
        var roleId = RoleId.valueOf("test-role");
        var parentRoles = Set.of(RoleId.valueOf("parent-role"));
        var capabilities = Set.<Capability>of(BasicCapability.valueOf("ViewProject"));
        var description = "Test role description";
        var roleDefinition = new RoleDefinition(roleId, RoleType.PROJECT_ROLE, parentRoles, capabilities, description);

        var jsonContent = tester.write(roleDefinition);

        assertThat(jsonContent).extractingJsonPathStringValue("$.roleId").isEqualTo("test-role");
        assertThat(jsonContent).extractingJsonPathStringValue("$.roleType").isEqualTo("ProjectRole");
        assertThat(jsonContent).extractingJsonPathArrayValue("$.parentRoles").containsExactly("parent-role");
        assertThat(jsonContent).extractingJsonPathStringValue("$.roleCapabilities[0].id").isEqualTo("ViewProject");
        assertThat(jsonContent).extractingJsonPathStringValue("$.roleCapabilities[0].@type").isEqualTo("BasicCapability");
        assertThat(jsonContent).extractingJsonPathStringValue("$.description").isEqualTo(description);
    }

    @Test
    void shouldDeserialize() throws IOException {
        var jsonContent = """
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
            """;

        var deserialized = tester.parse(jsonContent).getObject();

        assertThat(deserialized.roleId()).isEqualTo(RoleId.valueOf("test-role"));
        assertThat(deserialized.parentRoles()).containsExactly(RoleId.valueOf("parent-role"));
        assertThat(deserialized.roleCapabilities()).containsExactly(BasicCapability.valueOf("ViewProject"));
        assertThat(deserialized.description()).isEqualTo("Test role description");
    }
} 