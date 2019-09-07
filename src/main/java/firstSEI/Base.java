package firstSEI;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public static void main(String[] args) throws MalformedURLException, IOException {

    }

    public static AndroidDriver<AndroidElement> Capabilities(String app, String device) throws IOException {

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\firstSEI\\global.properties");
        Properties prop = new Properties();
        prop.load(fis);

        AndroidDriver<AndroidElement> driver;
        DesiredCapabilities cap = new DesiredCapabilities();

        String workDevice = (String) prop.get(device);
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, workDevice);
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        cap.setCapability(MobileCapabilityType.APP, prop.get(app));
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.installApp("C:\\Users\\Leonidus\\projects\\Tutorial Appium\\src\\CellcomTV_1.1.5.8_debug_app.apk");
        return driver;
    }
}
