package tests.day21_reusableMethods_HtmlReprts;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_PozitiveLoginTestiRaporu extends TestBaseRapor {


    BrcPage brcPage = new BrcPage();

    @Test
    public void positiveLoginTest() {
        extentTest=extentReports.createTest("pozitif Login","Geçerli username ve şifre ile giriş yapabilmeli");

        // 	https://www.bluerentalcars.com/ adresine git

        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        extentTest.info("brc anasayfaya gidildi");

        //	login butonuna bas

        brcPage.ilkloginbutonu.click();
        extentTest.info("login buyonuna tıklandı");

        //	test data username: customer@bluerentalcars.com ,

        brcPage.emailTexBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));
        extentTest.info("geçerli email yazıldı");
        //	test data password : 12345

        brcPage.passwordTexBox.sendKeys(ConfigReader.getProperty("brcValidPassword"));
        extentTest.info("geçerli password yazıldı");
        //login butonuna tıklayın

        brcPage.ikinciloginButonu.click();
        extentTest.info("login butonuna basıldı");
        //	Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

        String actualUserName = brcPage.kullanıcıProfilİsmi.getText();
        String expectedUsername = ConfigReader.getProperty("brcValidUserName");
        Assert.assertEquals(actualUserName, expectedUsername);
        extentTest.pass("kullanıcı başarılı şekilde giriş yaptı");
        Driver.closeDriver();
    }
}