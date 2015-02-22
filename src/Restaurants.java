//package <set your test package>;
import com.experitest.client.*;
import org.junit.*;
/**
 *
 *
*/
public class Restaurants {
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
        client.click("NATIVE", "xpath=(//*[@class='android.widget.LinearLayout'])[16]", 0, 1);
        client.click("NATIVE", "text=Search", 1, 1);
        client.click("NATIVE", "text=Trials Pub", 0, 1);
        client.click("NATIVE", "contentDescription=Save", 0, 1);
        client.click("NATIVE", "text=See Saves", 0, 1);
        if(client.waitForElement("NATIVE", "partial_text=California, United States", 0, 10000)){
            // If statement
        }
        client.click("NATIVE", "text=California, United States", 0, 1);
    }

    @After
    public void tearDown(){
        client.generateReport(true);
    }
}
