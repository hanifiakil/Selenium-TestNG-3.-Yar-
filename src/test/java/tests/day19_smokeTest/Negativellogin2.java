package tests.day19_smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Negativellogin2 {
    BrcPage brcPage=new BrcPage();

    @Test
    public void yanlışEmail() {
        // 	https://www.bluerentalcars.com/ adresine git

        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));

        //	login butonuna bas

        brcPage.ilkloginbutonu.click();

        //	test data username: aki@gmail.com ,

        brcPage.emailTexBox.sendKeys(ConfigReader.getProperty("brcWrongEmail"));

        //	test data password : 54321

        brcPage.passwordTexBox.sendKeys(ConfigReader.getProperty("brcValidPassword"));

        //login butonuna tıklayın

        brcPage.ikinciloginButonu.click();

        //	Degerleri girildiginde sayfaya basarili sekilde girilemediğini test et


        Assert.assertTrue(brcPage.ikinciloginButonu.isDisplayed());

        Driver.closeDriver();
    }
}
