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

        for (int i = 1; i <= Integer.parseInt(OR.getProperty("sideElementsCount")); i++) {
            driver.findElementByXPath("//android.support.v7.widget.RecyclerView[@content-desc=\"Navigation menu\"]" +
                    "/android.widget.FrameLayout[" + i + "]/android.widget.TextView").isDisplayed();
        }

        driver.findElementByXPath(OR.getProperty("Featured_Apps")).isDisplayed();
        driver.findElementByXPath(OR.getProperty("Movies_TV")).isDisplayed();
        //Thread.sleep(3000);
        driver.pressKey(new KeyEvent(AndroidKey.DPAD_RIGHT));
        Thread.sleep(500);
        driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
        driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
        driver.findElementByXPath(OR.getProperty("Top_Paid_Apps")).isDisplayed();
        driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
        driver.findElementByXPath(OR.getProperty("Top_Free")).isDisplayed();
        driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
        driver.findElementByXPath(OR.getProperty("Stream_the_music")).isDisplayed();
        driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
        driver.findElementByXPath(OR.getProperty("Entertainment_Apps")).isDisplayed();
        driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
        driver.findElementByXPath(OR.getProperty("Get_started")).isDisplayed();
        driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
        driver.findElementByXPath(OR.getProperty("Apps")).isDisplayed();

        for (int i = 0; i < 7; i++) {
            driver.pressKey(new KeyEvent(AndroidKey.DPAD_UP));
            Thread.sleep(500);
        }
    }
}
