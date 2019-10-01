package pageObjects;

import firstSEI.Utilities;
import firstSEI.Base;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import pageObjects.GoogleApps.GooglePlayGamesPage;
import pageObjects.GoogleApps.GooglePlayHomePage;
import pageObjects.GoogleApps.GooglePlaySettingsPage;

import java.io.IOException;

public class MainPage extends Base {

    Utilities utilities = new Utilities();

    public MainPage() throws IOException {
    }


    public void verifyGooglePlayPageTest() throws IOException, InterruptedException {

        Thread.sleep(beforeWait);
        driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));

        for (int i = 0; i < 4; i++) {
            driver.pressKey(new KeyEvent(AndroidKey.DPAD_LEFT));
            Thread.sleep(500);
        }

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_CENTER));
        Thread.sleep(5000);
        driver.findElementById(OR.getProperty("main_title_ID_GP")).isDisplayed();
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

        Thread.sleep(beforeWait);
        driver.pressKey(new KeyEvent(AndroidKey.DPAD_UP));

        for (int i = 0; i < 13; i++) {
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
        driver.findElementById(OR.getProperty("main_title_ID_GPM")).isDisplayed();
        Thread.sleep(1000);
    }

    public void verifyGooglePlayGamesPageTest() throws IOException, InterruptedException {

        Thread.sleep(beforeWait);
        driver.pressKey(new KeyEvent(AndroidKey.DPAD_UP));

        for (int i = 0; i < 13; i++) {
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
        driver.findElementById(OR.getProperty("main_title_ID_GPG")).isDisplayed();
        Thread.sleep(1000);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));

    }

    public GooglePlaySettingsPage getGooglePlaySettingsPage() throws InterruptedException {
        utilities.goToGooglePlay();

        for (int i = 0; i < 3; i++) {
            driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
        }

        utilities.findByText(OR.getProperty("SettingsSideBar"));
        return new GooglePlaySettingsPage();
    }

    public GooglePlayGamesPage getGooglePlayGamesPage() throws InterruptedException {
        utilities.goToGooglePlay();
        driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
        utilities.findByText(OR.getProperty("featuredGamesCat_GPG"));
        return new GooglePlayGamesPage();
    }

    public GooglePlayHomePage getGooglePlayHomePage() throws InterruptedException {
        utilities.goToGooglePlay();
        driver.findElementByXPath(OR.getProperty("Featured_Apps")).isDisplayed();
        driver.findElementByXPath(OR.getProperty("Movies_TV")).isDisplayed();
        return new GooglePlayHomePage();
    }
}
