package firstSEI;

import org.testng.annotations.*;
import pageObjects.MainPage;

import java.io.IOException;

public class MainPageTests extends Base {

    @BeforeMethod
    public void killAllNodes() throws IOException, InterruptedException {
        Runtime.getRuntime().exec("taskkill /F /IM node.exe");
        Thread.sleep(3000);
        service = startServer();
        Capabilities();
    }

    @Test
    public void openGooglePlayTest() throws IOException, InterruptedException {
//        service = startServer();
//        Capabilities();
        MainPage mp = new MainPage();
        mp.verifyGooglePlayPageTest();
//        service.stop();
    }

    @Test
    public void openGooglePlayMusicTest() throws IOException, InterruptedException {
//        service = startServer();
//        Capabilities();
        MainPage mp = new MainPage();
        mp.verifyGooglePlayMusicPageTest();
//        service.stop();
    }

    @Test
    public void openGooglePlayGamesTest() throws IOException, InterruptedException {
//        service = startServer();
//        Capabilities();
        MainPage mp = new MainPage();
        mp.verifyGooglePlayGamesPageTest();
//        service.stop();
    }

    @AfterMethod
    public void tearDown() {
        service.stop();
    }
}
