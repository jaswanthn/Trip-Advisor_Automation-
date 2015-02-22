//package <set your test package>;
import com.experitest.client.*;
import org.junit.*;
/**
 *
 *
*/
public class Test1 {
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
        client.click("NATIVE", "text=Restaurants", 0, 1);
        client.click("NATIVE", "text=Search", 1, 1);
        client.click("NATIVE", "text=#3 of 1,917 restaurants in San Jose", 0, 1);
   }

    @After
    public void tearDown(){
        client.generateReport(true);
    }
}
