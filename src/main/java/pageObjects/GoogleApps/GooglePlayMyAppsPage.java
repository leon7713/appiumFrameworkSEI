package pageObjects.GoogleApps;

import firstSEI.Utilities;
import org.testng.Assert;

public class GooglePlayMyAppsPage extends Utilities {

    public void verifyMyAppsPageTest() throws InterruptedException {

        //verify Cellcom TV is up to date
        pressKeyComb("down", 1);
        Thread.sleep(1000);
        boolean found = false;

        findByTextByUIAUT("On this device");
        findByTextByUIAUT("Not on this device");

        for (int i = 0; i < Integer.parseInt(OR.getProperty("My_Apps_Count")); i++) {
            String appName = driver.findElementById("com.android.vending:id/title").getText();
            if (appName.contains("סלקום")) {
                found = true;
                break;
            }
            else pressKeyComb("right", 1);
        }

        Assert.assertTrue(found);
        //click on the app
        pressKeyComb("center", 1);
        findByTextByUIAUT("Cellcom Israel LTD");
        findByTextByUIAUT("Open"); //it means the app is updated!
        findByTextByUIAUT("App Screenshots");
        pressKeyComb("up", 1);
        pressKeyComb("center", 1);
        findByTextByUIAUT("Cellcom Israel LTD");
        pressKeyComb("down", 2);
        pressKeyComb("center", 1);
        findByTextByUIAUT("Cellcom Israel LTD");
        findByTextByUIAUT("eynavel@cellcom.co.il");


        //go back to main page
        pressKeyComb("back", 6);
    }
}
