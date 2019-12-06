package pageObjects.GoogleApps.SettingsPages;

import firstSEI.Utilities;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.testng.Assert;

import java.util.*;

public class AboutPage extends Utilities{

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
        pressKeyComb("center", 1);
        Thread.sleep(1000);
        findByText(OR.getProperty("google_play_title_XPATH"));

        //verify Open source licenses
        pressKeyComb("back", 1);
        Thread.sleep(500);
        pressKeyComb("down", 1);
        Thread.sleep(500);
        pressKeyComb("center", 1);

        for (int i = 0; i < Integer.parseInt(OR.getProperty("licensesCount")); i++) {
            pressKeyComb("down", 1);
        }

        findByTextByUIAUT("Volley");

        //verify Play Store version - can't be verified
        //go back to main page
        pressKeyComb("back", 2);
        pressKeyComb("left", 4);
        pressKeyComb("back", 1);
    }
}
