package edu.stanford.protege.webprotege.authorization;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.Request;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-08-06
 */
@JsonTypeName("GetAuthorizedSubjectsRequest")
public record GetAuthorizedSubjectsRequest(Resource resource, Capability capability) implements Request<GetAuthorizedSubjectsResponse> {

    public static final String CHANNEL = "webprotege.authorization.GetAuthorizedSubjects";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
