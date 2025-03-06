package edu.stanford.protege.webprotege.authorization;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
class GetAuthorizedCapabilitiesRequest_Tests {

    private GetAuthorizedCapabilitiesRequest request;

    @Autowired
    private JacksonTester<GetAuthorizedCapabilitiesRequest> tester;

    @Autowired
    private Subject subject;

    @Autowired
    private Resource resource;

    @BeforeEach
    void setUp() {
        request = new GetAuthorizedCapabilitiesRequest(resource,
                                              subject);
    }

    @Test
    void shouldSupplyChannelName() {
        assertThat(request.getChannel()).isEqualTo("webprotege.authorization.GetAuthorizedCapabilities");
    }

    @Test
    void shouldSerializeRequest() throws IOException {
        var json = tester.write(request);
        assertThat(json).hasJsonPath("subject");
        assertThat(json).hasJsonPath("resource");
    }

    @Test
    void shouldDeserializeRequest() throws IOException {
        var parsed = tester.parse(TestConfiguration.COMMON_JSON).getObject();
        assertThat(parsed).isEqualTo(request);
    }
}