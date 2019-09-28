package firstSEI;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.GoogleApps.GooglePlayGamesPage;

import java.io.IOException;

public class GooglePlayGamesTests extends Base{

    @BeforeTest
    public void killAllNodes() throws IOException, InterruptedException {
        Runtime.getRuntime().exec("taskkill /F /IM node.exe");
        Thread.sleep(3000);
    }

    @Test
    public void googlePlayGamesPageTest() throws Exception {
        service = startServer();
        GooglePlayGamesPage gpgp = new GooglePlayGamesPage();
        gpgp.verifyGooglePlayGamesPageTest();
        service.stop();
    }
}
