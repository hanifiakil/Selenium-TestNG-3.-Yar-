
package utilities;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

    public abstract class TestBaseRapor {
        protected static ExtentReports extentReports;
        protected static ExtentTest extentTest;
        protected static ExtentHtmlReporter extentHtmlReporter;

        public TestBaseRapor() {
        }

        @BeforeTest(
                alwaysRun = true
        )
        public void setUpTest() {
            extentReports = new ExtentReports();
            String date=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
            String filePath = System.getProperty("user.dir") + "/target/Rapor/rapor"+date+".html";
            extentHtmlReporter = new ExtentHtmlReporter(filePath);
            extentReports.attachReporter(new ExtentReporter[]{extentHtmlReporter});
            extentReports.setSystemInfo("Environment", "QA");
            extentReports.setSystemInfo("Browser", ConfigReader.getProperty("browser"));
            extentReports.setSystemInfo("Automation Engineer", "Mehmet");
            extentHtmlReporter.config().setDocumentTitle("Rapor");
            extentHtmlReporter.config().setReportName("TestNG Reports");
        }

        @AfterMethod(
                alwaysRun = true
        )
        public void tearDownMethod(ITestResult result) throws IOException {
            if (result.getStatus() == 2) {
                String screenshotLocation = ReusableMethodsClass.getScreenshot(result.getName());
                extentTest.fail(result.getName());
                extentTest.addScreenCaptureFromPath(screenshotLocation);
                extentTest.fail(result.getThrowable());
            } else if (result.getStatus() == 3) {
                extentTest.skip("Test Case is skipped: " + result.getName());
            }

            Driver.closeDriver();
        }

        @AfterTest(
                alwaysRun = true
        )
        public void tearDownTest() {
            extentReports.flush();
        }
    }


