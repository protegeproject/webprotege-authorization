package edu.stanford.protege.webprotege.authorization;

import edu.stanford.protege.webprotege.authorization.GetAuthorizedResourcesRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
class GetAuthorizedResourcesRequest_Tests {

    private GetAuthorizedResourcesRequest request;

    @Autowired
    private JacksonTester<GetAuthorizedResourcesRequest> tester;

    @Autowired
    private Subject subject;

    @Autowired
    private Capability capability;

    @BeforeEach
    void setUp() {
        request = new GetAuthorizedResourcesRequest(subject, capability);
    }

    @Test
    void shouldSupplyChannelName() {
        assertThat(request.getChannel()).isEqualTo("webprotege.authorization.GetAuthorizedResources");
    }

    @Test
    void shouldSerializeRequest() throws IOException {
        var json = tester.write(request);
        assertThat(json).hasJsonPath("subject");
        assertThat(json).hasJsonPath("capability");
    }

    @Test
    void shouldDeserializeRequest() throws IOException {
        var json = """
                    {
                        "subject" : {
                            "@type" : "User",
                            "userId" : "John Smith"
                        },
                        "capability" : {
                            "@type" : "BasicCapability",
                            "id" : "TheCapability"
                        }
                    }
                """;
        var parsed = tester.parse(json).getObject();
        assertThat(parsed).isEqualTo(request);
    }
}