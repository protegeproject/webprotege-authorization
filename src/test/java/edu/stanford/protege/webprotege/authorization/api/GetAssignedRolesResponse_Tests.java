package edu.stanford.protege.webprotege.authorization.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@JsonTest
class GetAssignedRolesResponse_Tests {

    private GetAssignedRolesResponse request;

    @Autowired
    private JacksonTester<GetAssignedRolesResponse> tester;

    @Autowired
    private Subject subject;

    @Autowired
    private Resource resource;

    @Autowired
    private Set<RoleId> roles;

    @BeforeEach
    void setUp() {
        request = new GetAssignedRolesResponse(subject,
                                              resource,
                                               roles);
    }

    @Test
    void shouldSerializeRequest() throws IOException {
        var json = tester.write(request);
        assertThat(json).hasJsonPath("subject");
        assertThat(json).hasJsonPath("resource");
        assertThat(json).hasJsonPath("roles");
    }

    @Test
    void shouldDeserializeRequest() throws IOException {
        var json = """
                {
                    "subject": {
                        "@type" : "User",
                        "userId" : "John Smith"
                    },
                    "resource": {
                        "@type" : "Project",
                        "projectId" : "00000000-0000-0000-0000-000000000000"
                    },
                    "roles" : [
                        "ProjectEditor"
                    ]
                }
                """;
        var parsed = tester.parse(json).getObject();
        assertThat(parsed).isEqualTo(request);
    }
}