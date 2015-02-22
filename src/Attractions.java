//package <set your test package>;
import com.experitest.client.*;
import org.junit.*;
/**
 *
 *
*/
public class Attractions {
    private String host = "localhost";
    private int port = 8889;
    private String projectBaseDirectory = "/Users/jaswanthnukala/workspace/project287";
    protected Client client = null;

    @Before
    public void setUp(){
        client = new Client(host, port, true);
        client.setProjectBaseDirectory(projectBaseDirectory);
        client.setReporter("xml", "reports", "Untitled");
    }

    @Test
    public void testUntitled(){
        client.setDevice("adb:Nexus 5");
        client.launch("com.tripadvisor.tripadvisor/.TripAdvisorTripAdvisorActivity", true, false);
        client.click("NATIVE", "text=Attractions", 0, 1);
        if(client.waitForElement("NATIVE", "partial_text=Search", 1, 10000)){
            // If statement
        }
        client.click("NATIVE", "text=Search", 1, 1);
        if(client.waitForElement("NATIVE", "partial_text=Cathedral Basilica of St. Joseph", 0, 10000)){
            // If statement
        }
        client.click("NATIVE", "text=Cathedral Basilica of St. Joseph", 0, 1);
        client.click("NATIVE", "contentDescription=Save", 0, 1);
        client.swipe("Down", 563, 1377);
    }

    @After
    public void tearDown(){
        client.generateReport(true);
    }
}
