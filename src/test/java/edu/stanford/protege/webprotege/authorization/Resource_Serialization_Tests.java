package edu.stanford.protege.webprotege.authorization;

import edu.stanford.protege.webprotege.common.ProjectId;
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
public class Resource_Serialization_Tests {

    public static final String PROJECT_ID = "11111111-1111-1111-1111-111111111111";

    @Autowired
    private JacksonTester<Resource> tester;

    @Test
    void shouldSerializeProjectResource() throws IOException {
        var projectResource = new ProjectResource(new ProjectId(PROJECT_ID));
        var written = tester.write(projectResource);
        assertThat(written).hasJsonPathValue("projectId", PROJECT_ID);
        assertThat(written).hasJsonPathValue("['@type']", "Project");
        assertThat(written).doesNotHaveJsonPath("project");
        assertThat(written).doesNotHaveJsonPath("application");
    }
}
