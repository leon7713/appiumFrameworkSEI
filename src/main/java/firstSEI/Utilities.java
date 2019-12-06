package firstSEI;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Utilities extends Base {

    public void scrollToText(String text) {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));");
    }

    public void goToGooglePlay() throws InterruptedException {
        Thread.sleep(beforeWait);
        //driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
        pressKeyComb("down", 1);

        pressKeyComb("left", 4);

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_CENTER));
        Thread.sleep(2000); //increase if fails!!!
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

    public void findByTextByUIAUT(String neededText) {
        driver.findElementByAndroidUIAutomator("text(\"" + neededText + "\")").isDisplayed();
    }

    public void pressKeyComb(String direction, int amount) throws InterruptedException {

        String dpadDirection = direction.toLowerCase();

        for (int i = 0; i < amount; i++) {
            switch (dpadDirection) {
                case "up":
                    driver.pressKey(new KeyEvent(AndroidKey.DPAD_UP));
                    break;
                case "down":
                    driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
                    break;
                case "right":
                    driver.pressKey(new KeyEvent(AndroidKey.DPAD_RIGHT));
                    break;
                case "left":
                    driver.pressKey(new KeyEvent(AndroidKey.DPAD_LEFT));
                    break;
                case "center":
                    driver.pressKey(new KeyEvent(AndroidKey.DPAD_CENTER));
                    break;
                case "back":
                    driver.pressKey(new KeyEvent(AndroidKey.BACK));
                    break;
            }
        }
        Thread.sleep(300);
    }
}
