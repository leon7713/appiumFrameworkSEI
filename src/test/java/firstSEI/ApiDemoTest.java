package firstSEI;

import org.testng.annotations.Test;
import pageObjects.ApiDemoTestPage;

import java.io.IOException;

public class ApiDemoTest extends Base {

    @ Test
    public void tempTest() throws IOException {
        ApiDemoTestPage adtp = new ApiDemoTestPage();
        adtp.verifyApiDemoTestPageTest();
    }

}
