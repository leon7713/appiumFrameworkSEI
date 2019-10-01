package pageObjects.GoogleApps;

import firstSEI.Base;
import firstSEI.Utilities;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.testng.Assert;

public class GooglePlaySettingsPage extends Base {

    public void verifyGooglePlaySettingsPageTest() throws Exception {

        Utilities utilities = new Utilities();
        driver.pressKey(new KeyEvent(AndroidKey.DPAD_RIGHT));
        int numberOfMainCat = driver.findElementsById(OR.getProperty("mainCatIcons_ID")).size();
        Assert.assertEquals(numberOfMainCat, Integer.parseInt(OR.getProperty("numberOfMainCat"))); //including search icon

    }
}