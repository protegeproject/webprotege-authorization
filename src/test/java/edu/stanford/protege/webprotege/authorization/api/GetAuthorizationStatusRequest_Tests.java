package edu.stanford.protege.webprotege.authorization.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
class GetAuthorizationStatusRequest_Tests {

    private GetAuthorizationStatusRequest request;

    @Autowired
    private JacksonTester<GetAuthorizationStatusRequest> tester;

    @Autowired
    private Subject subject;

    @Autowired
    private Resource resource;

    @Autowired
    private ActionId actionId;

    @BeforeEach
    void setUp() {
        request = new GetAuthorizationStatusRequest(resource,
                                                    subject,
                                                    actionId);
    }

    @Test
    void shouldSupplyChannelName() {
        assertThat(request.getChannel()).isEqualTo("authorization.GetAuthorizationStatus");
    }

    @Test
    void shouldSerializeRequest() throws IOException {
        var json = tester.write(request);
        assertThat(json).hasJsonPath("subject");
        assertThat(json).hasJsonPath("resource");
        assertThat(json).hasJsonPath("actionId");
    }

    @Test
    void shouldDeserializeRequest() throws IOException {
        var parsed = tester.parse(TestConfiguration.COMMON_JSON).getObject();
        assertThat(parsed).isEqualTo(request);
    }
}