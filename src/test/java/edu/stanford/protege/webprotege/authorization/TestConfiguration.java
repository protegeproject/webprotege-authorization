package edu.stanford.protege.webprotege.authorization;

import edu.stanford.protege.webprotege.common.ProjectId;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-08-05
 */
@SpringBootConfiguration
public class TestConfiguration {

    public static String COMMON_JSON = """
                {
                    "subject" : {
                        "@type" : "User",
                        "userId": "John Smith"
                    },
                    "resource" : {
                        "@type" : "Project",
                        "projectId" : "00000000-0000-0000-0000-000000000000"
                    },
                    "capability" : {
                        "@type" : "BasicCapability",
                        "id" : "TheCapability"
                    }
                }
                """;

    @Bean
    Subject subject() {
        return Subject.forUser("John Smith");
    }

    @Bean
    Resource resource() {
        return new ProjectResource(projectId());
    }

    @Bean
    ProjectId projectId() {
        return ProjectId.valueOf("00000000-0000-0000-0000-000000000000");
    }

    @Bean
    Capability actionId() {
        return BasicCapability.valueOf("TheCapability");
    }

    @Bean
    RoleId roleId() {
        return new RoleId("ProjectEditor");
    }
}
