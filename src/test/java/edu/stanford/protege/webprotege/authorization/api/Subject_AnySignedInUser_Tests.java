package edu.stanford.protege.webprotege.authorization.api;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-08-05
 */
public class Subject_AnySignedInUser_Tests {

    private Subject subject;

    @BeforeEach
    public void setUp() {
        subject = Subject.forAnySignedInUser();
    }

    @Test
    public void shouldReturnFalseForIsGuest() {
        assertThat(subject.isGuest(), is(false));
    }

    @Test
    public void shouldReturnEmptyGuestUserName() {
        assertThat(subject.getUserName(), is(Optional.empty()));
    }

    @Test
    public void shouldReturnTrueForIsAnySignedInUser() {
        assertThat(subject.isAnySignedInUser(), is(true));
    }

    @Test
    public void shouldEqualOtherAnySignedInUserSubject() {
        assertThat(subject, is(Subject.forAnySignedInUser()));
    }

    @Test
    public void shouldNotBeEqualToGuestUser() {
        Subject user = Subject.forGuestUser();
        assertThat(this.subject, is(Matchers.not(user)));
    }

    @Test
    public void shouldNotBeEqualToSpecificUser() {
        Subject otherUser = Subject.forUser("Other User");
        assertThat(this.subject, is(Matchers.not(otherUser)));
    }
}
