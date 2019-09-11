package pageObjects;

import firstSEI.Utilities;
import firstSEI.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import java.io.IOException;

public class ApiDemoTestPage extends Base {

    public void verifyApiDemoTestPageTest() throws IOException {

        AndroidDriver<AndroidElement> driver = Capabilities("app", "device");
        Utilities utilities = new Utilities(driver);
        KeyEvent event = new KeyEvent();
        event.withKey(AndroidKey.BACK).build();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {}





//        driver.findElementByXPath("//android.widget.TextView[@text = 'Preference']").click();
//        driver.findElementByXPath("//android.widget.TextView[@text = '3. Preference dependencies']").click();
//        driver.findElementById("android:id/checkbox").click();
//        //driver.findElementByXPath("//android.widget.TextView[@text = 'WiFi settings']").click();
//        driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
//        driver.findElementByClassName("android.widget.EditText").sendKeys("123");
//        driver.findElementsByClassName("android.widget.Button").get(1).click();
    }
}
