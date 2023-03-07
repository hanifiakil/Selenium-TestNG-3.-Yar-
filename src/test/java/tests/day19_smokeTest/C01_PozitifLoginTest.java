package tests.day19_smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_PozitifLoginTest {

    BrcPage brcPage=new BrcPage();

    @Test
    public void positiveLoginTest(){

        // 	https://www.bluerentalcars.com/ adresine git

Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));

        //	login butonuna bas

        brcPage.ilkloginbutonu.click();

        //	test data username: customer@bluerentalcars.com ,

        brcPage.emailTexBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));

        //	test data password : 12345

        brcPage.passwordTexBox.sendKeys(ConfigReader.getProperty("brcValidPassword"));

        //login butonuna tıklayın

        brcPage.ikinciloginButonu.click();

        //	Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

        String actualUserName=brcPage.kullanıcıProfilİsmi.getText();
        String expectedUsername=ConfigReader.getProperty("brcValidUserName");
        Assert.assertEquals(actualUserName,expectedUsername);

        Driver.closeDriver();

    }

}
