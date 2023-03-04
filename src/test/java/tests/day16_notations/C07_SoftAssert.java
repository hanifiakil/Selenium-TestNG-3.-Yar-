package tests.day16_notations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C07_SoftAssert extends TestBase {

    @Test
    public void test01() {

        //1. “http://zero.webappsecurity.com/” Adresine gidin

        driver.get("http://zero.webappsecurity.com/");


        // 2. Sign in butonuna basin

        driver.findElement(By.id("signin_button")).click();


        // 3. Login kutusuna “username” yazin

        driver.findElement(By.id("user_login")).sendKeys("username");


        // 4. Password kutusuna “password” yazin

        driver.findElement(By.id("user_password")).sendKeys("password");


        // 5. Sign in tusuna basin

        driver.findElement(By.name("submit")).click();

        // 6. Pay Bills sayfasina gidin

        driver.get("http://zero.webappsecurity.com/");

        // 7. “Purchase Foreign Currency” tusuna basin

        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.id("pay_bills_link")).click();
        driver.findElement(By.linkText("Purchase Foreign Currency")).click();

        // 8. “Currency” drop down menusunden Eurozone’u secin

        WebElement dropDown= driver.findElement(By.id("pc_currency"));
        Select select=new Select(dropDown);
        select.selectByValue("EUR");

        // 9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin

        String actualData=select.getFirstSelectedOption().getText();
        String expectedValue= "Eurozone (euro)";

        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals(actualData,expectedValue,"seilen option Euro Zone degil");

        // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
        // "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)",
        // "Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)",
        // "New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"

        List<WebElement> tumOpsiyonlar= select.getOptions();
        // option listesi webelementlerden olusyor
        // expected liste ise String, bunun icin opsiyon listyesini String yapmaliyiz

        List<String> tumOpsiyonlarString=new ArrayList<>();
        for (WebElement each:tumOpsiyonlar
        ) {
            tumOpsiyonlarString.add(each.getText());
        }

        List<String> expectedOptionsList= Arrays.asList("Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)");

        softAssert.assertEquals(tumOpsiyonlarString,expectedOptionsList,"liste farkli");

        softAssert.assertAll();

    }
}
