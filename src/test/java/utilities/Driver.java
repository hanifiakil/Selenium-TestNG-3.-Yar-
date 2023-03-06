package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    /*
    POM de Driver için TestBase class ına extends etmek yerine
    Driver class ından static method lar kullanarak
    driver oluşturup, ilgili ayarların yapılması
    ve en sonda driver in kapatılması tercih edilmiştir

     POM de Driver class ındaki getDriver() na obje oluşturularak
     kullanılmasını engellemek için
     Singleton pattern kullanımı benimsenmiştir.

     Singleton Pattern : tekli kullanım demektir. bir class ın farklı class lardan
     obje oluşturularak kullanımını engellemek için kullanılır

     Bunu sağlamak için yapmamız gereken şey obje oluşturmak için kullanılan
     constructor ı private yaptığınız da başka class lardan Driver class ından
     obje oluşturulması mümkün OLAMAZ
     */
private Driver(){

}

    static WebDriver driver;

    public static WebDriver getDriver(){

        if (driver==null) {
            switch (ConfigReader.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "safari" :
                    WebDriverManager.safaridriver().setup();
                    driver=new SafariDriver();
                    break;
                case "firefox" :
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case "headless-chrome" :// chrome arka planda çalışıp bize sonucu dönderir
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();

            }


            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }

    public static void closeDriver() {
        if (!(driver == null)) {
            driver.close();
            driver=null;

        }
    }

}
