package edu.stanford.protege.webprotege.authorization;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-08-05
 */
public class BasicCapability_Tests {

    private BasicCapability capability;

    private final String id = "The id";

    @BeforeEach
    public void setUp() {
        capability = BasicCapability.valueOf(id);
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_id_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            BasicCapability.valueOf(null);
        });
    }

    @Test
    public void shouldReturnSupplied_id() {
        assertThat(capability.id(), is(this.id));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(capability, Matchers.is(capability));
    }

    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void shouldNotBeEqualToNull() {
        assertThat(capability.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(capability, Matchers.is(BasicCapability.valueOf(id)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_id() {
        assertThat(capability, is(Matchers.not(BasicCapability.valueOf("String-49f80fc5-f0c4-4013-accc-4f37f60d5632"))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(capability.hashCode(), is(BasicCapability.valueOf(id).hashCode()));
    }
}
