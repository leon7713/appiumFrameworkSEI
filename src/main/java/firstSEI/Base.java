package firstSEI;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Date;
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

    public static Properties prop;
    public static Properties OR;
    public static int beforeWait = 10000; //millis
    public static AndroidDriver<AndroidElement> driver;

    public static void Capabilities() throws IOException {

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\firstSEI\\global.properties");
        FileInputStream fis2 = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\firstSEI\\OR.properties");
        prop = new Properties();
        OR = new Properties();
        prop.load(fis);
        OR.load(fis2);

        //AndroidDriver<AndroidElement> driver;
        DesiredCapabilities cap = new DesiredCapabilities();

        String workDevice = prop.getProperty("device");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, workDevice);
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        //cap.setCapability(MobileCapabilityType.APP, prop.get(app));
        cap.setCapability("noReset", true);
        cap.setCapability("udid", "GZ18120115200028");
        cap.setCapability("appPackage", "com.cellcom.cellcom_tv.stb");
        //cap.setCapability("appActivity", "com.onoapps.cellcomtv.activities.MainActivity");
        cap.setCapability("appActivity", "com.onoapps.cellcomtv.activities.SplashActivity"); //no errors
        //cap.setCapability("appActivity", "com.onoapps.cellcomtv.activities.LoginActivity");
        //cap.setCapability("appActivity", "com.onoapps.cellcomtv.activities.NonLeanBackLauncherActivity");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        //driver.installApp("C:\\Users\\Leonidus\\Desktop\\Appium stuff\\CellcomTV_1.1.5.8_release_stb_signed.apk");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //return driver;
    }

    public static void getScreenshot(String s) throws IOException {
        Date currentDate = new Date();
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String myDate = currentDate.toString().replace(":","_").replace(" ","_") + ".jpg";
        FileUtils.copyFile(screenshotFile, new File("C:\\Users\\Leonidus\\SEI_screenshots\\" + s + " " + myDate));
    }
}
