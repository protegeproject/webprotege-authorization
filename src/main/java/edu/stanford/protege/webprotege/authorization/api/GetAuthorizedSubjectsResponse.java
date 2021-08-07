package edu.stanford.protege.webprotege.authorization.api;

import edu.stanford.protege.webprotege.cmd.Response;

import java.util.Set;

import static java.util.Objects.requireNonNull;

public record GetAuthorizedSubjectsResponse(Resource resource,
                                            ActionId actionId,
                                            Set<Subject> subjects) implements Response {
}
