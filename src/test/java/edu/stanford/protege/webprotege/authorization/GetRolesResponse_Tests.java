package edu.stanford.protege.webprotege.authorization;

import org.junit.jupiter.api.BeforeEach;

import java.util.Set;

import static org.mockito.Mockito.mock;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-08-06
 */
public class GetRolesResponse_Tests {

    GetRolesResponse response;

    @BeforeEach
    void setUp() {
        response = new GetRolesResponse(mock(Subject.class),
                                      mock(Resource.class),
                                        Set.of());
    }

}
