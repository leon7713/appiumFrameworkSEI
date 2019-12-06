package firstSEI.GoogleApps;

import firstSEI.Base;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.GoogleApps.GooglePlayMyAppsPage;
import pageObjects.MainPage;

import java.io.IOException;

public class GooglePlayMyAppsTests extends Base {

    @BeforeMethod
    public void killAllNodes() throws IOException, InterruptedException {
        Runtime.getRuntime().exec("taskkill /F /IM node.exe");
        Thread.sleep(3000);
        service = startServer();
        Capabilities();
    }

    @Test
    public void myAppsPageTest() throws Exception {
        MainPage mp = new MainPage();
        GooglePlayMyAppsPage gpmap = mp.getGooglePlayMyAppsPage();
        gpmap.verifyMyAppsPageTest();
    }

    @AfterMethod
    public void tearDown() {
        service.stop();
    }
}
