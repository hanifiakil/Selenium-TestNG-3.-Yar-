package utilities;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethodsClass;
import utilities.ReusableMethodsClass;

public class ReusableMethodsClass {
    //
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

        public static String getScreenshot(String name) throws IOException {
            String date = (new SimpleDateFormat("yyyyMMddhhmmss")).format(new Date());
            TakesScreenshot ts = (TakesScreenshot)Driver.getDriver();
            File source = (File)ts.getScreenshotAs(OutputType.FILE);
            String target = System.getProperty("user.dir") + "/target/Screenshots/" + name + date + ".png";
            File finalDestination = new File(target);
            FileUtils.copyFile(source, finalDestination);
            return target;
        }

        public static void switchToWindow(String targetTitle) {
            String origin = Driver.getDriver().getWindowHandle();
            Iterator var2 = Driver.getDriver().getWindowHandles().iterator();

            do {
                if (!var2.hasNext()) {
                    Driver.getDriver().switchTo().window(origin);
                    return;
                }

                String handle = (String)var2.next();
                Driver.getDriver().switchTo().window(handle);
            } while(!Driver.getDriver().getTitle().equals(targetTitle));

        }

        public static void hover(WebElement element) {
            Actions actions = new Actions(Driver.getDriver());
            actions.moveToElement(element).perform();
        }

        public static List<String> getElementsText(List<WebElement> list) {
            List<String> elemTexts = new ArrayList();
            Iterator var2 = list.iterator();

            while(var2.hasNext()) {
                WebElement el = (WebElement)var2.next();
                if (!el.getText().isEmpty()) {
                    elemTexts.add(el.getText());
                }
            }

            return elemTexts;
        }

        public static List<String> getElementsText(By locator) {
            List<WebElement> elems = Driver.getDriver().findElements(locator);
            List<String> elemTexts = new ArrayList();
            Iterator var3 = elems.iterator();

            while(var3.hasNext()) {
                WebElement el = (WebElement)var3.next();
                if (!el.getText().isEmpty()) {
                    elemTexts.add(el.getText());
                }
            }

            return elemTexts;
        }

        public static void waitFor(int sec) {
            try {
                Thread.sleep((long)(sec * 1000));
            } catch (InterruptedException var2) {
                var2.printStackTrace();
            }

        }


    }


