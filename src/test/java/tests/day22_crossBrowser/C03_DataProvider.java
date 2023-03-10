package tests.day22_crossBrowser;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProvider {




    @Test
    public void test01() {

        AmazonPage amazonPage=new AmazonPage();
        //amazon ana sayfaya gidelim

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        //nutella için arama yapalım

        amazonPage.aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        //sonuçların nutella içerdiğini test edelim

        String expectedKelime="Nutella";
        String actualSonuçYazısı=amazonPage.aramasonuçElementi.getText();

        Assert.assertTrue(actualSonuçYazısı.contains(expectedKelime));

        Driver.closeDriver();
    }

    @DataProvider
    public static Object[][] AranacakKelimeler() {

       Object[][]arananKelimeArrayi= {{"java"},{"Netherlands"},{"Nutella"}, {"çiğdem"}};
        return arananKelimeArrayi;
    }

    @Test(dataProvider = "AranacakKelimeler")
    //arayacağımız kelimeleri bir liste gibi tutup bana yollayacak
    //bir veri sağlayıcısı oluşturacağız

    public void dataProviderTesti(String arananKelime) {
        AmazonPage amazonPage=new AmazonPage();
        //amazon ana sayfaya gidelim

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        //Nutella Java çiğdem Netherlands için arama yapalım

        amazonPage.aramaKutusu.sendKeys(arananKelime + Keys.ENTER);

        //sonuçların aradığımız kelime içerdiğini test edelim

        String expectedKelime=arananKelime;
        String actualSonuçYazısı=amazonPage.aramasonuçElementi.getText();

        Assert.assertTrue(actualSonuçYazısı.contains(expectedKelime));

        //sayfayı kapatalım

        Driver.closeDriver();
    }
}
