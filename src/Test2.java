//package <set your test package>;
import com.experitest.client.*;
import org.junit.*;
/**
 *
 *
*/
public class Test2 {
    private String host = "localhost";
    private int port = 8889;
    private String projectBaseDirectory = "/Users/jaswanthnukala/workspace/project6";
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
        client.click("NATIVE", "text=Search", 1, 1);
        if(client.waitForElement("NATIVE", "partial_text=Peralta Adobe and Fallon House Historic Site", 0, 10000)){
            // If statement
        }
        client.click("NATIVE", "text=Peralta Adobe and Fallon House Historic Site", 0, 1);
        client.click("NATIVE", "contentDescription=Save", 0, 1);
        client.click("NATIVE", "id=photo", 0, 1);
        client.click("NATIVE", "xpath=(//*[@contentDescription='-'])[1]", 0, 1);
        if(client.waitForElement("NATIVE", "partial_text=Done", 0, 30000)){
            // If statement
        }
        client.click("NATIVE", "text=Done", 0, 1);
        client.click("NATIVE", "id=home", 0, 1);
        client.click("NATIVE", "id=home", 0, 1);
        client.click("NATIVE", "id=home", 0, 1);
    }

    @After
    public void tearDown(){
        client.generateReport(true);
    }
}
