package firstSEI.GoogleApps.SettingsPages;

import firstSEI.Base;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.GoogleApps.GooglePlaySettingsPage;
import pageObjects.GoogleApps.SettingsPages.PurchaseAuthorizationPage;
import pageObjects.MainPage;

import java.io.IOException;

public class PurchaseAuthorizationPageTest extends Base {

    @BeforeMethod
    public void killAllNodes() throws IOException, InterruptedException {
        Runtime.getRuntime().exec("taskkill /F /IM node.exe");
        Thread.sleep(3000);
        service = startServer();
        Capabilities();
    }

    @Test
    public void parentalControlsPageTest() throws Exception {
        MainPage mp = new MainPage();
        GooglePlaySettingsPage gpsp = mp.getGooglePlaySettingsPage();
        PurchaseAuthorizationPage pap = gpsp.getPurchaseAuthorizationPage();
        pap.verifyPurchaseAuthorizationPageTest();
    }

    @AfterMethod
    public void tearDown() {
        service.stop();
    }
}
