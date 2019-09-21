package firstSEI;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.GoogleApps.GooglePlayHomePage;
import pageObjects.MainPage;

import java.io.IOException;

public class GooglePlayHomeTests extends Base {

    @BeforeTest
    public void killAllNodes() throws IOException, InterruptedException {
        Runtime.getRuntime().exec("taskkill /F /IM node.exe");
        Thread.sleep(3000);
    }

    @Test
    public void googlePlayHomePageTest() throws IOException, InterruptedException {
        service = startServer();
        GooglePlayHomePage gphp = new GooglePlayHomePage();
        gphp.verifyGooglePlayHomePageTest();
        service.stop();
    }
}
