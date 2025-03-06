package edu.stanford.protege.webprotege.authorization;


import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.Request;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-08-05
 */
@JsonTypeName("GetAuthorizedResourcesRequest")
public record GetAuthorizedResourcesRequest(Subject subject, Capability capability) implements Request<GetAuthorizedResourcesResponse> {

    public static final String CHANNEL = "webprotege.authorization.GetAuthorizedResources";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
