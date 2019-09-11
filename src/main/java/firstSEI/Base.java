package firstSEI;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public static void main(String[] args) throws MalformedURLException, IOException {

    }

    public static AppiumDriverLocalService service;

    public AppiumDriverLocalService startServer() {
        boolean flag = checkIfServerIsRunning(4723);

        if (!flag) {
            service = AppiumDriverLocalService.buildDefaultService();
            service.start();
        }

        return service;
    }

    public static boolean checkIfServerIsRunning(int port) {

        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        } catch (IOException e) {
            //if control comes here, then it means that the port is in use
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
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
        cap.setCapability("noReset", true);
        //cap.setCapability("appPackage", "com.your.package");
        //cap.setCapability("appActivity", "com.your.package.MainActivity");
        cap.setCapability("appPackage", "com.cellcom.cellcom_tv.stb");
        //cap.setCapability("appActivity", "com.onoapps.cellcomtv.activities.MainActivity");
        //cap.setCapability("appActivity", "com.onoapps.cellcomtv.activities.SplashActivity"); //no errors
        //cap.setCapability("appActivity", "com.onoapps.cellcomtv.activities.LoginActivity");
        //cap.setCapability("appActivity", "com.onoapps.cellcomtv.activities.NonLeanBackLauncherActivity");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.installApp("C:\\Users\\Leonidus\\projects\\Tutorial Appium\\src\\CellcomTV_1.1.5.8_debug_app.apk");
        return driver;
    }
}
