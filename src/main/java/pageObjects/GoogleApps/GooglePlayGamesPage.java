package pageObjects.GoogleApps;

import firstSEI.Base;
import firstSEI.Utilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GooglePlayGamesPage extends Base {

    public void verifyGooglePlayGamesPageTest() throws Exception {

        AndroidDriver<AndroidElement> driver = Capabilities("app", "device");
        Utilities utilities = new Utilities(driver);

        utilities.goToGooglePlay();

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
        utilities.findByText(OR.getProperty("featuredGamesCat_GPG"));
        driver.pressKey(new KeyEvent(AndroidKey.DPAD_RIGHT));
        driver.findElementsByClassName("android.widget.ImageView").get(2).isDisplayed();

        Map<Integer, String> categoriesMap = new HashMap<>();

        for (int i = 0; i < Integer.parseInt(OR.getProperty("rowsCount")); i++) {
            driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
            Thread.sleep(500);
            String category = driver.findElementsByClassName("android.widget.TextView").get(0).getText();
            categoriesMap.put(i, category);
        }

        Iterator<Map.Entry<Integer, String>> iterator = categoriesMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        String lastCatName = driver.findElementsByClassName("android.widget.TextView").get(9).getText();
        Assert.assertEquals(lastCatName, OR.getProperty("lastCategoryName"));

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_LEFT));
        driver.pressKey(new KeyEvent(AndroidKey.DPAD_UP));
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }
}
