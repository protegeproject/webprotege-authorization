package edu.stanford.protege.webprotege.authorization.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@JsonTest
class GetAuthorizedSubjectsRequest_Tests {

    private GetAuthorizedSubjectsRequest request;

    @Autowired
    private JacksonTester<GetAuthorizedSubjectsRequest> tester;

    @Autowired
    private Resource resource;

    @Autowired
    private ActionId actionId;

    @BeforeEach
    void setUp() {
        request = new GetAuthorizedSubjectsRequest(resource, actionId);
    }

    @Test
    void shouldSupplyChannelName() {
        assertThat(request.getChannel()).isEqualTo("authorization.GetAuthorizedSubjects");
    }

    @Test
    void shouldSerializeRequest() throws IOException {
        var json = tester.write(request);
        assertThat(json).hasJsonPath("resource");
        assertThat(json).hasJsonPath("actionId");
    }

    @Test
    void shouldDeserializeRequest() throws IOException {
        var json = """
                    {
                        "resource" : {
                            "@type" : "Project",
                            "projectId" : "00000000-0000-0000-0000-000000000000"
                        },
                        "actionId" : "TheAction"
                    }
                """;
        var parsed = tester.parse(json).getObject();
        assertThat(parsed).isEqualTo(request);
    }
}