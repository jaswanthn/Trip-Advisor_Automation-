//package <set your test package>;
import com.experitest.client.*;
import org.junit.*;
/**
 *
 *
*/
public class Hotels {
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
        client.click("NATIVE", "text=Hotels", 0, 1);
       
        
        client.click("NATIVE", "text=Search", 1, 1);
        if(client.waitForElement("NATIVE", "partial_text=The Fairmont San Jose", 0, 10000)){
            // If statement
        }
        client.click("NATIVE", "text=The Fairmont San Jose", 0, 1);
        client.click("NATIVE", "text=Show Prices", 0, 1);
        client.click("NATIVE", "text=Book on", 0, 1);
        client.click("NATIVE", "text=Select", 0, 1);
    }

    @After
    public void tearDown(){
        client.generateReport(true);
    }
}
