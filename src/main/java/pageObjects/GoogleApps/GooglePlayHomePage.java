package pageObjects.GoogleApps;

import firstSEI.Base;
import firstSEI.Utilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GooglePlayHomePage extends Base {

    public void verifyGooglePlayHomePageTest() throws IOException, InterruptedException {

        AndroidDriver<AndroidElement> driver = Capabilities("app", "device");
        Utilities utilities = new Utilities(driver);

        utilities.goToGooglePlay();

        driver.findElementByXPath(OR.getProperty("Featured_Apps")).isDisplayed();
        driver.findElementByXPath(OR.getProperty("Movies_TV")).isDisplayed();
        driver.pressKey(new KeyEvent(AndroidKey.DPAD_RIGHT));
        Thread.sleep(500);
        driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));

        List<String> categoriesList = new ArrayList<>();
        categoriesList.add(OR.getProperty("Top_Paid_Apps"));
        categoriesList.add(OR.getProperty("Top_Free"));
        categoriesList.add(OR.getProperty("Stream_the_music"));
        categoriesList.add(OR.getProperty("Entertainment_Apps"));
        categoriesList.add(OR.getProperty("Get_started"));
        categoriesList.add(OR.getProperty("Apps"));

        for (int i = 0; i < 6; i++) {
            driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
            driver.findElementByXPath(categoriesList.get(i)).isDisplayed();
        }


        for (int i = 0; i < 7; i++) {
            driver.pressKey(new KeyEvent(AndroidKey.DPAD_UP));
            Thread.sleep(500);
        }

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_LEFT));
    }
}
