package pageObjects.GoogleApps.SettingsPages;

import firstSEI.Base;
import firstSEI.Utilities;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class PurchaseAuthorizationPage extends Base {

    Utilities utilities = new Utilities();

    public void verifyPurchaseAuthorizationPageTest() throws Exception {

        utilities.findByText(OR.getProperty("main_title_PA_XPATH")); //main title

        Map<Integer, String> map = new HashMap<>();
        map.put(0, "For all purchases through Google Play on this device");
        map.put(1, "Every 30 minutes");
        map.put(2, "Never");

        for (int i = 0; i < 3; i++) {
            String text = driver.findElementByXPath("//*/android.widget.LinearLayout[" + (i + 1) + "]/android.widget.LinearLayout/android.widget.TextView").getText();
            Assert.assertEquals(map.get(i), text);
        }

        for (int j = 0; j < 2; j++) {
            driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
            driver.pressKey(new KeyEvent(AndroidKey.DPAD_CENTER));

            driver.findElementByAndroidUIAutomator("text(\"Confirm password\")").isDisplayed();

            for (int i = 0; i < 2; i++) {
                driver.pressKey(new KeyEvent(AndroidKey.BACK));
            }

            utilities.findByText(OR.getProperty("main_title_PA_XPATH")); //main title
        }

        for (int i = 0; i < 4; i++) {
            driver.pressKey(new KeyEvent(AndroidKey.BACK));
        }
    }
}
