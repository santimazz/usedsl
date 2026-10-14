import static org.junit.Assert.assertTrue;
import org.junit.Test;

import dsl.UsecaseFileParser;
import metamodel.Slice;
import metamodel.Step;
import metamodel.Usecase;
import metamodel.UsecaseSpecification;

/**
 * Test cases with a sample usecase, ensuring they are parsed properly by UsecaseParseVisitor
 */
public class UsecaseParseIntegrationTest {

    /**
     * Test a simplified example of the sample lightbulb usecase,
     * ensure an instance of each corresponding class exists.
     */
    @Test
    public void classInstanceTest() {

            String usecaseString = "Usecase UC1 \"Turn light on\" (\r\n" + //
                                "Description: \"The user sends an objectChanged event, and the light turns on, then off\"\r\n" + //
                                "Scope: \"Room\"\r\n" + //
                                "Actors: \"Room\", \"light\"\r\n" + //
                                "Preconditions:\r\n" + //
                                "    Entity \"light\" is in state \"light_off\"\r\n" + //
                                "Flow \"Full\":\r\n" + //
                                "    1) User performs action \"movement detected\" with property \"duration\" equal to \"4.0\"\r\n" + //
                                "    2) Entity \"light\" transitions to state \"movement_detected\"\r\n" + //
                                "    3) Property \"is_on\" for entity \"light\" equal to \"true\"\r\n" + //
                                "Postconditions:\r\n" + //
                                "    Property \"is_on\" for entity \"light\" equal to \"false\"\r\n" + //
                                ")";

        UsecaseFileParser parser = new UsecaseFileParser();
        UsecaseSpecification usecases = parser.parseString(usecaseString);

        assertTrue(usecases.getUsecase(1).getClass() == Usecase.class); // usecase
        assertTrue(usecases.getUsecase(1).getFlow("Full").getClass() == Slice.class); // slice

        int steps = usecases.getUsecase(1).getFlow("Full").getSteps().size() - 1;
        for (int i = 0; i <= steps; i++) {
            assertTrue(usecases.getUsecase(1).getFlow("Full").getSteps().get(i).getClass() == Step.class);
        }
        
    }
    
}
