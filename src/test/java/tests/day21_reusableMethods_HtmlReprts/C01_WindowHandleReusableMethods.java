package tests.day21_reusableMethods_HtmlReprts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethodsClass;

import java.util.Set;

public class C01_WindowHandleReusableMethods {
    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/windows adresine gidin
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
String ilksayfaWH=Driver.getDriver().getWindowHandle();
        //Click Here butonuna basın
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        Set<String> windowHanleSeti=Driver.getDriver().getWindowHandles();

        String ikinciSayfaWH="";
        for (String each:windowHanleSeti
             ) {
if (!each.equals(ilksayfaWH)){
    ikinciSayfaWH=each;
}
        }
        Driver.getDriver().switchTo().window(ikinciSayfaWH);

        System.out.println(Driver.getDriver().getTitle());

        String expectedTitle="New Window";
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @Test
    public void test02() {
        //https://the-internet.herokuapp.com/windows adresine gidin
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        String ilksayfaWH=Driver.getDriver().getWindowHandle();
        //Click Here butonuna basın
        Driver.getDriver().findElement(By.linkText("Click Here")).click();

        //yeni tab ta title nin "New Window" olduğunu test edin

        ReusableMethodsClass.switchToWindow("New Window");

        String expectedTitle="New Window";
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        Driver.closeDriver();
    }
}
