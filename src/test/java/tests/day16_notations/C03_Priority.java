package tests.day16_notations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C03_Priority extends TestBase {
    /*
    TestNG test method larını isim sırasına göre çalıştırır
    eğer isim sıralamasının dışında bir sıralama ile çalışmasını isterseniz
    ozaman test method larına öncelik(priority) tanımlayabiliriz

    priority küçükten büyüğe doğru çalışır
    eğer bir test method una priority değeri atanmamışsa
    default olarak priority=0 kabul edilir
     */

    @BeforeClass
    public void beforeClassMethod(){
        System.out.println("Before Class");
    }
    @AfterClass
    public void afterClassMethod(){
        System.out.println("After Class");
    }
    @Test(priority = 5)
    public void amazonTesti() {

        driver.get("https://www.amazon.com");
        System.out.println(driver.getCurrentUrl());


    }

    @Test(priority = -2)
    public void test02() {

        driver.get("https://www.bestbuy.com");

    }

    @Test
    public void techproedTesti() {

        driver.get("https://www.techproeducation.com");
    }
}
