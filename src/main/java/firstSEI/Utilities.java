package firstSEI;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import java.util.HashMap;
import java.util.Map;

public class Utilities extends Base {

    public void scrollToText(String text) {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));");
    }

    public void goToGooglePlay() throws InterruptedException {
        Thread.sleep(beforeWait);
        pressKeyComb("down", 1);

        pressKeyComb("left", 5);

        pressKeyComb("center", 1);
        Thread.sleep(2000); //increase if fails!!!
        driver.findElementById(OR.getProperty("main_title_ID_GP")).isDisplayed();

        Map<Integer, String> mainCategoriesMap = new HashMap<>();

        mainCategoriesMap.put(0, "Apps");
        mainCategoriesMap.put(1, "Games");
        mainCategoriesMap.put(2, "My apps");

        for (Map.Entry<Integer, String> entry : mainCategoriesMap.entrySet()) {
            findByTextByUIAUT(entry.getValue());
        }
    }

    public void findByText(String XPATH) {
        driver.findElementByXPath(XPATH).isDisplayed();
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
