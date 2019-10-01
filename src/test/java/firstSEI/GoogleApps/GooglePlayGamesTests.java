package firstSEI.GoogleApps;

import firstSEI.Base;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.GoogleApps.GooglePlayGamesPage;
import pageObjects.MainPage;

import java.io.IOException;

public class GooglePlayGamesTests extends Base {

    @BeforeMethod
    public void killAllNodes() throws IOException, InterruptedException {
        Runtime.getRuntime().exec("taskkill /F /IM node.exe");
        Thread.sleep(3000);
        service = startServer();
        Capabilities();
    }

    @Test
    public void googlePlayGamesPageTest() throws Exception {
        MainPage mp = new MainPage();
        GooglePlayGamesPage gpgp = mp.getGooglePlayGamesPage();
        gpgp.verifyGooglePlayGamesPageTest();
    }

    @AfterMethod
    public void tearDown() {
        service.stop();
    }
}
