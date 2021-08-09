package edu.stanford.protege.webprotege.authorization.api;

import edu.stanford.protege.webprotege.common.ProjectId;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
                    "actionId" : "TheAction"
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
    ActionId actionId() {
        return new ActionId("TheAction");
    }

    @Bean
    RoleId roleId() {
        return new RoleId("ProjectEditor");
    }
}
