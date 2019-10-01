package firstSEI;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Utilities extends Base {

    public void scrollToText(String text) {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));");
    }

    public void goToGooglePlay() throws InterruptedException {
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
    }

    public void findByText(String text) {
        driver.findElementByXPath(text).isDisplayed();
    }
}
