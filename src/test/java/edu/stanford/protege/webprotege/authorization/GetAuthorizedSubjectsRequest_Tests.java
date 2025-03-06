package edu.stanford.protege.webprotege.authorization;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
class GetAuthorizedSubjectsRequest_Tests {

    private GetAuthorizedSubjectsRequest request;

    @Autowired
    private JacksonTester<GetAuthorizedSubjectsRequest> tester;

    @Autowired
    private Resource resource;

    @Autowired
    private Capability capability;

    @BeforeEach
    void setUp() {
        request = new GetAuthorizedSubjectsRequest(resource, capability);
    }

    @Test
    void shouldSupplyChannelName() {
        assertThat(request.getChannel()).isEqualTo("webprotege.authorization.GetAuthorizedSubjects");
    }

    @Test
    void shouldSerializeRequest() throws IOException {
        var json = tester.write(request);
        assertThat(json).hasJsonPath("resource");
        assertThat(json).hasJsonPath("capability");
    }

    @Test
    void shouldDeserializeRequest() throws IOException {
        var json = """
                    {
                        "resource" : {
                            "@type" : "Project",
                            "projectId" : "00000000-0000-0000-0000-000000000000"
                        },
                        "capability" : { "@type" : "BasicCapability", "id" : "TheCapability" }
                    }
                """;
        var parsed = tester.parse(json).getObject();
        assertThat(parsed).isEqualTo(request);
    }
}