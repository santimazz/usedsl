import org.junit.Test;

/**
 * Test cases with a sample usecase, ensuring they are parsed properly by UsecaseParseVisitor
 */
public class UsecaseParseIntegrationTest {


    /**
     * Test the sample usecase described in the paper, and ensure all 
     * elements are as expected.
     */
    @Test
    public void fullParseTest() {

            String usecaseText = "Usecase UC1 \"Turn light on\" (\r\n" + //
                "Description: \"The user sends an objectChanged event, and the light turns on, then off\"\r\n" + //
                "Scope: \"Room\"\r\n" + //
                "Actors: \"Room\", \"light\"\r\n" + //
                "Preconditions:\r\n" + //
                "    Entity \"light\" is in state \"light_off\"\r\n" + //
                "    Property \"is_on\" for entity \"light\" equal to \"false\"\r\n" + //
                "Flow \"Regular\":\r\n" + //
                "    1) User performs action \"movement detected\" with property \"duration\" equal to \"4.0\"\r\n" + //
                "    2) Entity \"light\" transitions to state \"movement_detected\"\r\n" + //
                "    2) Entity \"light\" transitions to state \"light_on\"\r\n" + //
                "    4) Property \"timer\" for entity \"light\" is greater than \"0\"\r\n" + //
                "    5) Property \"is_on\" for entity \"light\" equal to \"true\"\r\n" + //
                "    6) Property \"is_on\" for entity \"light\" contains \"e\"\r\n" + //
                "    7) Property \"timer\" for entity \"light\" is less than \"5\"\r\n" + //
                "    8) Entity \"light\" transitions to state \"light_off\"\r\n" + //
                "Postconditions:\r\n" + //
                "    Entity \"light\" is in state \"light_off\"\r\n" + //
                "    Property \"is_on\" for entity \"light\" equal to \"false\"\r\n" + //
                ")";

    }
    
}
