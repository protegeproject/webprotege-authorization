package edu.stanford.protege.webprotege.authorization.api;

import edu.stanford.protege.webprotege.ipc.Response;

public record GetAuthorizationStatusResponse(Resource resource,
                                             Subject subject,
                                             AuthorizationStatus authorizationStatus) implements Response {

}
