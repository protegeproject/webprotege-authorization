package edu.stanford.protege.webprotege.authorization;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.Request;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-08-06
 */
@JsonTypeName("GetAuthorizationStatusRequest")
public record GetAuthorizationStatusRequest(Resource resource,
                                            Subject subject,
                                            Capability capability) implements Request<GetAuthorizationStatusResponse> {

    public static final String CHANNEL = "webprotege.authorization.GetAuthorizationStatus";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
