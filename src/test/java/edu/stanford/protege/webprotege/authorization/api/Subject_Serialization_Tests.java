package edu.stanford.protege.webprotege.authorization.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-08-05
 */
@JsonTest
public class Subject_Serialization_Tests {

    @Autowired
    JacksonTester<Subject> tester;

    @Test
    void shouldSerializeSpecificUser() throws IOException {
        var subject = Subject.forUser("TheUserName");
        var json = tester.write(subject);
        assertThat(json).hasJsonPathValue("['@type']", "User");
        assertThat(json).hasJsonPathValue("userId", "TheUserName");
    }

    @Test
    void shouldDeserializeAnyUser() throws IOException {
        var json = """
                    {
                        "@type" : "AnyUser"
                    }
                """;
        var read = tester.parse(json);
        var subject = read.getObject();
        assertThat(subject.isAnySignedInUser()).isTrue();
    }

    @Test
    void shouldDeserializeSpecificUser() throws IOException {
        var json = """
                    {
                        "@type" : "User",
                        "userId" : "TheUserName"
                    }
                """;
        var read = tester.parse(json);
        var subject = read.getObject();
        assertThat(subject.getUserName()).contains("TheUserName");
    }

    @Test
    void shouldDeserialize_guest_User() throws IOException {
        var json = """
                    {
                        "@type" : "User",
                        "userId" : "guest"
                    }
                """;
        var read = tester.parse(json);
        var subject = read.getObject();
        assertThat(subject.isGuest()).isTrue();
    }
}
