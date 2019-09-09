package firstSEI;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.ApiDemoTestPage;

import java.io.IOException;

public class ApiDemoTest extends Base {

    @BeforeTest
    public void killAllNodes() throws IOException, InterruptedException {
        Runtime.getRuntime().exec("taskkill /F /IM node.exe");
        Thread.sleep(3000);
    }

    @ Test
    public void tempTest() throws IOException {
        service = startServer();
        ApiDemoTestPage adtp = new ApiDemoTestPage();
        adtp.verifyApiDemoTestPageTest();
        service.stop();
    }

}
