package edu.stanford.protege.webprotege.authorization.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import edu.stanford.protege.webprotege.common.ProjectId;

import java.util.Optional;

/**
 * A {@link Resource} represents something that can have allowable actions assigned to it for a given subject (user).
 * For example, the WebProtege Application itself or a WebProtege Project.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonSubTypes({
        @JsonSubTypes.Type(ProjectResource.class),
        @JsonSubTypes.Type(ApplicationResource.class)
})
public interface Resource {

    Optional<ProjectId> getProjectId();

    @JsonIgnore
    boolean isApplication();

    @JsonIgnore
    boolean isProject();

    boolean isProject(ProjectId projectId);
}