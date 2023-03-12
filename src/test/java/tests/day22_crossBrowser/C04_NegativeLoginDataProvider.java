package tests.day22_crossBrowser;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_NegativeLoginDataProvider {


    @DataProvider
    public static Object[][] kullanıcıListesi() {

        Object[][] kullanıcıBilgileri={{"firuze@nehaber.com","54678"},
                                       {"murat@benbuişibilirim.com","65874"},
                                       {"ilyas@hollandadanselam.com","85976"}};
        return kullanıcıBilgileri;
    }

    @Test(dataProvider = "kullanıcıListesi")


    public void yanlışŞifre(String userEmail, String password) throws InterruptedException{
        BrcPage brcPage=new BrcPage();
        // 	https://www.bluerentalcars.com/ adresine git

        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));

        //	login butonuna bas

        brcPage.ilkloginbutonu.click();

        //	test data username: dataprovider dan alalım ,

        brcPage.emailTexBox.sendKeys(userEmail);

        //	test data password : dataprovider dan alalım

        brcPage.passwordTexBox.sendKeys(password);

        //login butonuna tıklayın

        brcPage.ikinciloginButonu.click();

        //	Degerleri girildiginde sayfaya basarili sekilde girilemediğini test et


        Assert.assertTrue(brcPage.ikinciloginButonu.isDisplayed());

        Driver.closeDriver();
    }
}
