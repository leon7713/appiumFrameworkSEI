package pageObjects.GoogleApps;

import firstSEI.Base;
import firstSEI.Utilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.testng.Assert;

import java.io.IOException;

public class GooglePlayHomePage extends Base {

    public void verifyGooglePlayHomePageTest() throws IOException, InterruptedException {

        AndroidDriver<AndroidElement> driver = Capabilities("app", "device");
        Utilities utilities = new Utilities(driver);

        Thread.sleep(beforeWait);
        driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));

        for (int i = 0; i < 4; i++) {
            driver.pressKey(new KeyEvent(AndroidKey.DPAD_LEFT));
            Thread.sleep(500);
        }

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_CENTER));
        Thread.sleep(5000);
        //driver.pressKey(new KeyEvent(AndroidKey.HOME));
        //driver.findElementById("com.android.vending:id/title_badge").isDisplayed();
        driver.findElementById(OR.getProperty("main_title_ID_GP")).isDisplayed();
        int sideCategoriesCount = driver.findElementsById("com.android.vending:id/row_header").size();
        Assert.assertEquals(sideCategoriesCount, Integer.parseInt(OR.getProperty("sideCategoriesCount")));
        //continue here !!!
    }
}
