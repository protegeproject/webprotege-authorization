package edu.stanford.protege.webprotege.authorization.api;

import edu.stanford.protege.webprotege.common.Response;

public record GetAuthorizationStatusResponse(Resource resource,
                                             Subject subject,
                                             AuthorizationStatus authorizationStatus) implements Response {

}
