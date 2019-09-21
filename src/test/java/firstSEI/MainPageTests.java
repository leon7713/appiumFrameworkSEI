package firstSEI;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.MainPage;

import java.io.IOException;

public class MainPageTests extends Base {

    @BeforeTest
    public void killAllNodes() throws IOException, InterruptedException {
        Runtime.getRuntime().exec("taskkill /F /IM node.exe");
        Thread.sleep(3000);
    }

    @ Test
    public void openGooglePlayTest() throws IOException, InterruptedException {
        service = startServer();
        MainPage mp = new MainPage();
        mp.verifyGooglePlayPageTest();
        service.stop();
    }

    @ Test
    public void openGooglePlayMusicTest() throws IOException, InterruptedException {
        service = startServer();
        MainPage mp = new MainPage();
        mp.verifyGooglePlayMusicPageTest();
        service.stop();
    }

    @ Test
    public void openGooglePlayGamesTest() throws IOException, InterruptedException {
        service = startServer();
        MainPage mp = new MainPage();
        mp.verifyGooglePlayGamesPageTest();
        service.stop();
    }
}
