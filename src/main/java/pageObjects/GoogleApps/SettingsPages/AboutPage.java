package pageObjects.GoogleApps.SettingsPages;

import firstSEI.Base;
import firstSEI.Utilities;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.testng.Assert;

import java.util.*;

public class AboutPage extends Base{

    Utilities utilities = new Utilities();

    public void verifyAboutPageTest() throws Exception {
        //verify main categories
        List<String> categoriesList = new ArrayList<>();

        categoriesList.add("Terms of Service");
        categoriesList.add("Open source licenses");
        categoriesList.add("Play Store version");

        List<String> realCategoriesList = new LinkedList<>();

        for (int i = 0; i < 3; i++) {
            realCategoriesList.add(driver.findElementsById(OR.getProperty("main_categories_ID")).get(i).getText());
        }

        for (int i = 0; i < realCategoriesList.size(); i++) {
            Assert.assertEquals(realCategoriesList.get(i), categoriesList.get(i));
        }

        //verify Terms of Service
        driver.pressKey(new KeyEvent(AndroidKey.DPAD_CENTER));
        Thread.sleep(1000);
        utilities.findByText(OR.getProperty("google_play_title_XPATH"));

        while (!driver.findElementByXPath("//android.view.View[@text = 'פרטיות ותנאים']").isDisplayed()) {
            driver.longPressKey((new KeyEvent(AndroidKey.DPAD_DOWN)));
        } //not working!!!

    }
}
