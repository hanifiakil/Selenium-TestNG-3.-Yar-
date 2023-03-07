package tests.day16_notations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C06_SoftAssert extends TestBase {

    @Test(groups = "grup2")
    public void test01() {
        /*
        Softassertion başlangıç ve bitiş satırları arasındaki
        tüm assertion ları yapıp
        bitiş satırına geldiğinde bize bulduğu hataları rapor eder
         */

        //başlangıç olarak obje oluşturulur

        SoftAssert softAssert=new SoftAssert();

        //amazon anasayfaya gidin

        driver.get("https://www.amazon.com");

        //title in amazon içerdğini test edin

        String expectedTitle="Amazon";
        String actualTitle=driver.getTitle();
        softAssert.assertTrue(actualTitle.contains(expectedTitle),"title amazon içermiyor");

        //arama kutusunun erişilebilir olduğunu test edin

        WebElement aramakutusu=driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(aramakutusu.isEnabled(),"arama kutusu erişilebilir değil");

        //arama kutusuna nutella yazıp aratın

        aramakutusu.sendKeys("Nutella" + Keys.ENTER);

        //arama yapıldığını test edin

        WebElement sonuçYazısıElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(sonuçYazısıElementi.isDisplayed(),"arama yapılamadı");

        //arama sonucunun nutella içerdiğini test edin

        softAssert.assertTrue(sonuçYazısıElementi.getText().contains("Nutella"),"arama sonucu nutella içermiyor");


        //softassert e bitiş satırını söylemek için assertAll(); deriz

        softAssert.assertAll();

        System.out.println("assertion larda fail ise bu kısım yazılmaz");

    }
}
