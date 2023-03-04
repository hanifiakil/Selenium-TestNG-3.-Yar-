package tests.day17_pom;

import org.testng.annotations.Test;
import utilities.Driver;

public class C01_yeniDriverilkClass {

    @Test
    public void test01() {
        Driver.getDriver().get("https://www.amazon.com");
        /*
        bugüne kadar TestBase class ına extends ederek kullandığımız driver yerine
        bundan sonra Driver class ından kullanacağımız getDriver static method unu kullanıcaz
        yani
        Driver.getDriver()      in
        driver                  out
         */
        Driver.getDriver().get("https://www.facebook.com");
        Driver.getDriver().get("https://bestbuy.com");

    }
}
