//package <set your test package>;
import com.experitest.client.*;
import org.junit.*;
/**
 *
 *
*/
public class Flights {
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
        client.elementListSelect("", "text=Flights", 0, false);
        client.click("NATIVE", "text=Flights", 0, 1);
        
        client.click("NATIVE", "text=Search Flights", 0, 1);
        if(client.waitForElement("NATIVE", "xpath=(//*[@id='timing_panel'])[2]", 0, 30000)){
            // If statement
        }
        client.click("NATIVE", "xpath=(//*[@id='timing_panel'])[2]", 0, 1);
        if(client.waitForElement("NATIVE", "partial_text=Book Now", 0, 60000)){
            // If statement
        }
        client.click("NATIVE", "text=Book Now", 0, 1);
    }

    @After
    public void tearDown(){
        client.generateReport(true);
    }
}
