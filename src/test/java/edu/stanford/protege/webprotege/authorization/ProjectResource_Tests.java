package edu.stanford.protege.webprotege.authorization;

import edu.stanford.protege.webprotege.common.ProjectId;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-08-05
 */
public class ProjectResource_Tests {

    private ProjectResource projectResource;

    private ProjectId projectId = new ProjectId("11111111-1111-1111-1111-111111111111");

    @BeforeEach
    public void setUp() {
        projectResource = new ProjectResource(projectId);
    }

    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNullPointerExceptionIf_projectId_IsNull() {
        assertThrows(NullPointerException.class, () -> {
            new ProjectResource(null);
        });
    }

    @Test
    public void shouldReturnSupplied_projectId() {
        assertThat(projectResource.getProjectId(), is(Optional.of(this.projectId)));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(projectResource, Matchers.is(projectResource));
    }

    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void shouldNotBeEqualToNull() {
        assertThat(projectResource.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(projectResource, Matchers.is(new ProjectResource(projectId)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_projectId() {
        assertThat(projectResource, is(Matchers.not(new ProjectResource(ProjectId.generate()))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(projectResource.hashCode(), is(new ProjectResource(projectId).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(projectResource.toString(), startsWith("ProjectResource"));
    }

    @Test
    public void shouldReturn_true_For_isProjectTarget() {
        assertThat(projectResource.isProject(projectId), is(true));
    }

    @Test
    public void shouldReturn_false_For_isProjectTarget() {
        assertThat(projectResource.isProject(new ProjectId("22222222-2222-2222-2222-222222222222")), is(false));
    }

    @Test
    public void shouldReturn_false_For_isApplicationTarget() {
        assertThat(projectResource.isApplication(), is(false));
    }


}
