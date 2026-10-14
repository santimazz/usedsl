import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Test;

import metamodel.Slice;
import metamodel.Usecase;
import metamodel.UsecaseSpecification;

/**
 * FR-10 Tests for ensuring basic use case qualities are fulfilled, which cannot
 * be realized in pure grammar: Duplicate usecases, Out-of-order, duplicate
 * steps
 * 
 */
public class UsecaseMetamodelTest {

    UsecaseSpecification usecases = new UsecaseSpecification();

    /**
     * Test for having two usecases with the same UC# ID.
     */
    @Test
    @SuppressWarnings("ThrowableResultIgnored")
    public void duplicateUsecase() {
        Usecase uc, uc2;

        uc = new Usecase(1, "foo");
        uc2 = new Usecase(1, "bar");
        usecases.addUsecase(uc);
        assertThrows(IllegalArgumentException.class, () -> usecases.addUsecase(uc2));
    }

    /**
     * Expect an exception if usecase steps have the same index in file (should be caught by parser, either way)
     */
    @Test
    @SuppressWarnings("ThrowableResultIgnored")
    public void outOfOrderSteps() {

        int index = 1;
        Usecase uc;
        Slice flow = new Slice("title");

        flow.addStep(index, "STATE", "foo", "bar", null, "baz", null);
        assertThrows(IllegalArgumentException.class,
                () -> flow.addStep(index, "STATE", "foo", "bar", null, "baz", null));

    }

    /**
     * Expect all entities in a use case to match those declared within its steps,
     * as they are added automatically. Uses two names, with three steps (a
     * duplicate)
     */ 
    @Test
    public void entityListing() {

        int index = 1;
        Usecase uc = new Usecase(1, "title");
        Slice flow = new Slice("title");
        Set<String> expectedActors = new HashSet<>();
        expectedActors.add("foo");
        expectedActors.add("bar");

        flow.addStep(1, "STATE", "foo", null, null, null, null);
        flow.addStep(2, "STATE", "bar", null, null, null, null);
        flow.addStep(3, "STATE", "foo", null, null, null, null);

        uc.addFlow(flow);

        assertEquals(expectedActors, uc.getActors());
    }

}
