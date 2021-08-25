package edu.stanford.protege.webprotege.authorization;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RoleId_Tests {

    private RoleId roleId;

    private String id = "The id";

    @BeforeEach
    public void setUp() {
        roleId = new RoleId(id);
    }

    @Test
    public void shouldThrowNullPointerExceptionIf_id_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new RoleId(null);
        });
    }

    @Test
    public void shouldReturnSupplied_id() {
        assertThat(roleId.id()).isEqualTo(this.id);
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(roleId).isEqualTo(roleId);
    }

    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void shouldNotBeEqualToNull() {
        assertThat(roleId).isNotEqualTo(null);
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(roleId).isEqualTo(new RoleId(id));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_id() {
        assertThat(roleId).isNotEqualTo(new RoleId("String-fefb9f3e-0859-40e3-89d5-06ac997b1794"));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(roleId).hasSameHashCodeAs(new RoleId(id));
    }
}