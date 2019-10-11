package pageObjects.GoogleApps.SettingsPages;

import firstSEI.Base;
import firstSEI.Utilities;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ParentalControlsPage extends Base {

    Utilities utilities = new Utilities();

    public void verifyParentalControlsPageTest() throws Exception {

        utilities.findByText(OR.getProperty("main_title_PC_XPATH"));

        List<String> list = new ArrayList<>();
        list.add("PEGI 18");
        list.add("PEGI 16");
        list.add("PEGI 12");
        list.add("PEGI 7");
        list.add("PEGI 3");

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_UP));

        int count = 4;

        for (int i = 0; i < 5; i++) {
            driver.pressKey(new KeyEvent(AndroidKey.DPAD_UP));
            String item = driver.findElementsById("com.android.vending:id/guidedactions_item_title").get(count).getText();
            System.out.println("------------------------list: " + list.get(i) + " item: " + item);
            Assert.assertEquals(list.get(i), item);
            count--;
        }

        for (int i = 0; i < 3; i++) {
            driver.pressKey(new KeyEvent(AndroidKey.BACK));
        }
    }

    public void parentalControlPopupSetAllOne() {
        int count = 0;

        for (int i = 0; i < 4; i++) {
            driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
            driver.pressKey(new KeyEvent(AndroidKey.DPAD_CENTER));
            String one;
            if (i != 3) { //in reentering, page is closing after las one (so except las one)
                one = driver.findElementsById(OR.getProperty("currentNumberText_ID")).get(count).getText();
                Assert.assertEquals(1, Integer.parseInt(one));
            }
            count++;
        }
    }

    public void setOnOffParentalControl() throws InterruptedException {

        utilities.findByText(OR.getProperty("main_title_PC_XPATH"));

        //turn on age 3
        for (int i = 0; i < 6; i++) {
            driver.pressKey(new KeyEvent(AndroidKey.DPAD_UP));
        }

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_CENTER));
        parentalControlPopupSetAllOne();
        parentalControlPopupSetAllOne(); // reenter code

        //turn off
        Thread.sleep(2000);
        for (int i = 0; i < 3; i++) {
            driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
        }

        for (int i = 0; i < 2; i++) {
            driver.pressKey(new KeyEvent(AndroidKey.DPAD_CENTER));
        }

        for (int i = 0; i < 5; i++) {
            driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
        }

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_CENTER));
        parentalControlPopupSetAllOne();

        driver.findElementById(OR.getProperty("main_title_ID_GP")).isDisplayed();
    }
}
