package edu.stanford.protege.webprotege.authorization;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.*;
import org.semanticweb.owlapi.model.IRI;

import static edu.stanford.protege.webprotege.authorization.GetAuthorizedCapabilitiesForEntityRequest.CHANNEL;

@JsonTypeName(CHANNEL)
public record GetAuthorizedCapabilitiesForEntityRequest(ProjectId projectId, UserId userId, IRI entityIri) implements Request<GetAuthorizedCapabilitiesForEntityResponse> {

    public static final String CHANNEL = "webprotege.authorization.GetAuthorizedCapabilitiesForEntity";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
