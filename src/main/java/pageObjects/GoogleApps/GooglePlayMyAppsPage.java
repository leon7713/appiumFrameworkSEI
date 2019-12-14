package pageObjects.GoogleApps;

import firstSEI.Utilities;
import org.testng.Assert;

public class GooglePlayMyAppsPage extends Utilities {

    public void verifyMyAppsPageTest() throws InterruptedException {

        //verify Cellcom TV is up to date
        pressKeyComb("down", 1);
        Thread.sleep(1000);
        boolean found = false;

        for (int i = 0; i < Integer.parseInt(OR.getProperty("My_Apps_Count")); i++) {
            if (driver.findElementByClassName(OR.getProperty("app_class")).getAttribute("focused").equals("true")) {
                Assert.assertEquals(driver.findElementByClassName(OR.getProperty("app_class")).getAttribute("content-desc"), "סלקום tv Master Box");
                found = true;
                break;
            } else pressKeyComb("right", 1);
        }

        Assert.assertTrue(found);
        //click on the app
        //pressKeyComb("center", 1);
//        findByTextByUIAUT("OPEN");
//        findByTextByUIAUT("UNINSTALL UPDATES");
//        findByTextByUIAUT("FULL DESCRIPTION");
//        findByTextByUIAUT("FLAG AS INAPPROPRIATE");
//
//        //verify full description
//        pressKeyComb("right", 2);
//        pressKeyComb("center", 1);
//        scrollToText("Offered by: Cellcom Israel LTD\n" + "\n" + "Released on: Nov 18, 2019");

        //go back to main page
        pressKeyComb("back", 4);
    }
}
