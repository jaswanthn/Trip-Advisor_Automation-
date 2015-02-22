//package <set your test package>;
import com.experitest.client.*;
import org.junit.*;
/**
 *
 *
*/
public class SignIn {
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
        client.elementListSelect("", "text=Settings / Sign in", 0, false);
        client.click("NATIVE", "text=Settings / Sign in", 0, 1);
        client.click("NATIVE", "text=Sign in", 0, 1);
        client.click("NATIVE", "text=Sign in", 1, 1);

        client.sendText("njaswanth1992@gmail.com");
        if(client.waitForElement("NATIVE", "hint=Password", 0, 30000)){
            // If statement
        }
        client.elementSendText("NATIVE", "hint=Password", 0, "1234567");
        if(client.waitForElement("NATIVE", "partial_text=Sign in", 0, 10000)){
            // If statement
        }
        client.click("NATIVE", "text=Sign in", 0, 1);
        if(client.waitForElement("NATIVE", "id=sign_in_item", 0, 30000)){
            // If statement
        }
        
        if(client.waitForElement("NATIVE", "partial_text=Sign out", 0, 30000)){
            // If statement
        }
        client.click("NATIVE", "text=Sign out", 0, 1);
        client.click("NATIVE", "text=OK", 0, 1);
    }

    @After
    public void tearDown(){
        client.generateReport(true);
    }
}
