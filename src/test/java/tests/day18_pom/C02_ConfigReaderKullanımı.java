package tests.day18_pom;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_ConfigReaderKullanımı {

    @Test
    public void test01() {
        FacebookPage facebookPage=new FacebookPage();
        //facebook anasayfaya gidin

        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));

        //kullanıcı mail kutusuna yanlış isim yazdırın

        facebookPage.mailKutusu.sendKeys(ConfigReader.getProperty("fbwrongUsername"));

        //kullanıcı şifre kutusuna yanlış password yazdırın

        facebookPage.sifreKutusu.sendKeys(ConfigReader.getProperty("fbWrongPassword"));

        //login butonuna basın

        facebookPage.loginTusu.click();

        //giriş yapılmadığını test edin

Assert.assertTrue(facebookPage.girilemediYaziElementi.isDisplayed());

        Driver.closeDriver();
    }
}
