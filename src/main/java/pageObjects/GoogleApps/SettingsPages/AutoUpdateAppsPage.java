package pageObjects.GoogleApps.SettingsPages;

import firstSEI.Base;
import firstSEI.Utilities;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class AutoUpdateAppsPage extends Base {

    private boolean isChecked;

    Utilities utilities = new Utilities();

    private void chooseOption() throws InterruptedException {

        for (int i = 0; i < 2; i++) {
            driver.pressKey(new KeyEvent(AndroidKey.DPAD_CENTER));
            Thread.sleep(500);
        }

        isChecked = driver.findElementsByXPath(OR.getProperty("side_options_XPATH")).get(0).getAttribute("checked").equals("true");
    }

    public void verifyAutoUpdateAppsPageTest() throws Exception {

        String optionOne = driver.findElementsById(OR.getProperty("side_options_ID")).get(0).getText();
        String optionTwo = driver.findElementsById(OR.getProperty("side_options_ID")).get(1).getText();

        String[] sideOptionsArr = {optionOne, optionTwo};

        List<String> sideOptionsList = new ArrayList<>();
        sideOptionsList.add("Don't auto-update apps");
        sideOptionsList.add("Auto-update apps at any time");

        for (int i = 0; i < 2; i++) {
            Assert.assertEquals(sideOptionsList.get(i), sideOptionsArr[i]);
        }

        isChecked = driver.findElementsByXPath(OR.getProperty("side_options_XPATH")).get(0).getAttribute("checked").equals("true");
        Assert.assertFalse(isChecked);

        chooseOption();
        Assert.assertTrue(isChecked);

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));

        chooseOption();
        Assert.assertFalse(isChecked);

        //go back to main page
        driver.pressKey(new KeyEvent(AndroidKey.BACK));

        for (int i = 0; i < 3; i++) {
            driver.pressKey(new KeyEvent(AndroidKey.DPAD_LEFT));
            Thread.sleep(500);
        }

        Thread.sleep(1000);
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
    }
}
