package tests.day22_crossBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;
import utilities.TestBaseCross;

public class C01_AssertionsCross extends TestBaseCross {

    @Test
    public void test01() {

        //amazon anasayfaya gidin

        driver.get("https://www.amazon.com");

        //title in amazon içerdğini test edin

        String expectedTitle="Amazon";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //arama kutusunun erişilebilir olduğunu test edin

        WebElement aramakutusu=driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(aramakutusu.isEnabled());

        //arama kutusuna nutella yazıp aratın

        aramakutusu.sendKeys("Nutella" + Keys.ENTER);

        //arama yapıldığını test edin

        WebElement sonuçYazısıElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonuçYazısıElementi.isDisplayed());

        //arama sonucunun nutella içerdiğini test edin

        Assert.assertTrue(sonuçYazısıElementi.getText().contains("Nutella"));


    }
}
