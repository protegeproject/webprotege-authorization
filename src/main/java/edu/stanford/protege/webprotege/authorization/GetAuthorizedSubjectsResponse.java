package edu.stanford.protege.webprotege.authorization;

import edu.stanford.protege.webprotege.common.Response;

import java.util.Set;

import static java.util.Objects.requireNonNull;

public record GetAuthorizedSubjectsResponse(Resource resource,
                                            Capability capability,
                                            Set<Subject> subjects) implements Response {
}
