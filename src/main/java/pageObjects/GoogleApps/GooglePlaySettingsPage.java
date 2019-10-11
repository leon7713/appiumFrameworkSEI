package pageObjects.GoogleApps;

import firstSEI.Base;
import firstSEI.Utilities;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.testng.Assert;
import pageObjects.GoogleApps.SettingsPages.ParentalControlsPage;

public class GooglePlaySettingsPage extends Base {

    Utilities utilities = new Utilities();

    public void verifyGooglePlaySettingsPageTest() throws Exception {

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_RIGHT));
        int numberOfMainCat = driver.findElementsById(OR.getProperty("mainCatIcons_ID")).size();
        Assert.assertEquals(numberOfMainCat, Integer.parseInt(OR.getProperty("numberOfMainCat"))); //including search icon
    }

    public ParentalControlsPage getParentalControlsPage() {
        for (int i = 0; i < 2; i++) {
            driver.pressKey(new KeyEvent(AndroidKey.DPAD_CENTER));
        }
        return new ParentalControlsPage();
    }
}