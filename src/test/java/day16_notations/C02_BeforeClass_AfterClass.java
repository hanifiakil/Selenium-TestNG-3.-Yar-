package day16_notations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_BeforeClass_AfterClass extends TestBase {
// JUnit te @BeforeClass ve @AfterClass notasyonuna sahip metodlar static olmak zorundaydı
    //TestNG bu zorunluluktan bizi kurtarıyor

    /*
    TestNG bize daha fazla before ve after notasyonları sunar
    diğer before/after notasyonları tanımlayacağımız
    grup, test veya sut den önce ve sonra çalışırlar
    ileride xml dosyaları ile birlikte göreceğiz
     */

    @BeforeClass
    public void beforeClassMethod(){
        System.out.println("Before Class");
    }
    @AfterClass
    public void afterClassMethod(){
        System.out.println("After Class");
    }
    @Test
    public void amazonTesti() {

        driver.get("https://www.amazon.com");
        System.out.println(driver.getCurrentUrl());


    }

    @Test
    public void test02() {

        driver.get("https://www.bestbuy.com");

    }

    @Test
    public void techproedTesti() {

        driver.get("https://www.techproeducation.com");
    }
}
