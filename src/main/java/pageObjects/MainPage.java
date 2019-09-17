package pageObjects;

import firstSEI.Utilities;
import firstSEI.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import java.io.IOException;

public class MainPage extends Base {

    public void verifyGooglePlayPageTest() throws IOException, InterruptedException {

        AndroidDriver<AndroidElement> driver = Capabilities("app", "device");
        Utilities utilities = new Utilities(driver);

        Thread.sleep(20000);
        driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));

        for (int i = 0; i < 4; i++) {
            driver.pressKey(new KeyEvent(AndroidKey.DPAD_LEFT));
            Thread.sleep(500);
        }

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_CENTER));
        Thread.sleep(5000);
        //driver.pressKey(new KeyEvent(AndroidKey.HOME));
        driver.findElementById("com.android.vending:id/title_badge").isDisplayed();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));


//        driver.findElementByXPath("//android.widget.TextView[@text = 'Preference']").click();
//        driver.findElementByXPath("//android.widget.TextView[@text = '3. Preference dependencies']").click();
//        driver.findElementById("android:id/checkbox").click();
//        //driver.findElementByXPath("//android.widget.TextView[@text = 'WiFi settings']").click();
//        driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
//        driver.findElementByClassName("android.widget.EditText").sendKeys("123");
//        driver.findElementsByClassName("android.widget.Button").get(1).click();
    }

    public void verifyGooglePlayMusicPageTest() throws IOException, InterruptedException {
        AndroidDriver<AndroidElement> driver = Capabilities("app", "device");
        Utilities utilities = new Utilities(driver);

        Thread.sleep(20000);
        driver.pressKey(new KeyEvent(AndroidKey.DPAD_UP));

        for (int i = 0; i < 14; i++) {
            driver.pressKey(new KeyEvent(AndroidKey.DPAD_LEFT));
            Thread.sleep(500);
        }

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_CENTER));
        Thread.sleep(1000);
        driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));

        for (int i = 0; i < 5; i++) {
            driver.pressKey(new KeyEvent(AndroidKey.DPAD_LEFT));
            Thread.sleep(500);
        }

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_CENTER));
        Thread.sleep(1000);
        driver.findElementById("com.google.android.music:id/title_badge").isDisplayed();
        Thread.sleep(1000);
        //driver.pressKey(new KeyEvent(AndroidKey.BACK));

    }

    public void verifyGooglePlayGamesPageTest() throws IOException, InterruptedException {
        AndroidDriver<AndroidElement> driver = Capabilities("app", "device");
        Utilities utilities = new Utilities(driver);

        Thread.sleep(20000);
        driver.pressKey(new KeyEvent(AndroidKey.DPAD_UP));

        for (int i = 0; i < 14; i++) {
            driver.pressKey(new KeyEvent(AndroidKey.DPAD_LEFT));
            Thread.sleep(500);
        }

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_CENTER));
        Thread.sleep(1000);

        for (int i = 0; i < 2; i++) {
            driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
            Thread.sleep(500);
        }

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_LEFT));
        driver.pressKey(new KeyEvent(AndroidKey.DPAD_CENTER));
        Thread.sleep(1000);
        driver.findElementById("com.google.android.play.games:id/title_badge").isDisplayed();
        Thread.sleep(1000);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));

    }
}
