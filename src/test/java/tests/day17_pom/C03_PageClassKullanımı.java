package tests.day17_pom;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;

public class C03_PageClassKullanımı {

    @Test
    public void test01() {
        FacebookPage facebookPage=new FacebookPage();
        Faker faker=new Faker();

        //facebook anasayfaya gidin

        Driver.getDriver().get("https://www.facebook.com");

        //kullanıcı mail kutusuna rastgele bir isim yazdırın

        facebookPage.mailKutusu.sendKeys(faker.internet().emailAddress());

        //kullanıcı şifre kutusuna rastgele bir password yazdırın

        facebookPage.sifreKutusu.sendKeys(faker.internet().password());

        //login butonuna basın

        facebookPage.loginTusu.click();

        //giriş yapılmadığını test edin

        Assert.assertTrue(facebookPage.girilemediYaziElementi.isDisplayed());

        Driver.closeDriver();

}}
