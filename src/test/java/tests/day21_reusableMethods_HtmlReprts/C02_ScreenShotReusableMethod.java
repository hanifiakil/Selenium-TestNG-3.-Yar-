package tests.day21_reusableMethods_HtmlReprts;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethodsClass;

import java.io.IOException;

public class C02_ScreenShotReusableMethod {

    @Test
    public void test01() throws IOException {
        // amazon sayfasına gidip fotoğrafını çekelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        ReusableMethodsClass.getScreenshot("amazon");
        Driver.closeDriver();
    }
}
