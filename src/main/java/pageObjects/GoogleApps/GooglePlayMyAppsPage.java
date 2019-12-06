package pageObjects.GoogleApps;

import firstSEI.Utilities;
import org.testng.Assert;

public class GooglePlayMyAppsPage extends Utilities {

    public void verifyMyAppsPageTest() throws InterruptedException {
        findByText(OR.getProperty("Recently_Updated_XPATH"));
        findByText(OR.getProperty("Up_to_Date_XPATH"));

        //verify Cellcom TV is up to date
        pressKeyComb("down", 1);
        Thread.sleep(1000);
        boolean found = false;

        for (int i = 0; i < Integer.parseInt(OR.getProperty("My_Apps_Count")); i++) {
            String appTitle = driver.findElementsByXPath("//*/android.widget.RelativeLayout/android.widget.TextView[1]").get(4).getText();
            pressKeyComb("right", 1);
            if (appTitle.equals("סלקום tv Master Box")) {
                found = true;
                break;
            }
        }

        Assert.assertTrue(found);
        pressKeyComb("center", 1);
        findByTextByUIAUT("OPEN");
        findByTextByUIAUT("UNINSTALL UPDATES");
        findByTextByUIAUT("FULL DESCRIPTION");
        findByTextByUIAUT("FLAG AS INAPPROPRIATE");

        //verify full description
        pressKeyComb("right", 2);
        pressKeyComb("center", 1);
        scrollToText("Offered by: Cellcom Israel LTD\n" + "\n" + "Released on: Nov 18, 2019");

        //go back to main page
        pressKeyComb("back", 4);
    }
}
