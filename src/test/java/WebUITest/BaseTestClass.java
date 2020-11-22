package WebUITest;

import Web.Pages.Page;
import Web.Util.SeleniumDriver;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public abstract class BaseTestClass {
    public static WebDriver driver;
    public SoftAssert softAssert;
    SeleniumDriver driverFactory;

    @Attachment(value = "{0}", type = "text/plain")
    public static String Save_TestLog(String message) {
        return message;
    }

    @BeforeSuite
    void setUpTest() throws IOException, InterruptedException {


    }

    @BeforeClass
    @Parameters("browser")
    void beforeClass(String browser) throws Exception {
        driverFactory = new SeleniumDriver();
        driver = driverFactory.SeleniumDriverSetup(browser);
    }

    @BeforeMethod
    void beforeMethod() {
        softAssert = new SoftAssert();

    }

    @AfterMethod
    void AfterMethod() {

    }

    @AfterClass
    void afterClass() {
        Page.URLFirstTime = true;
        driver.close();
        driver.quit();
    }

    @AfterSuite(alwaysRun = true)
    void tearDownTest() throws IOException {

    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] Save_screenshotPNG() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Step("check that value : {0} equal to : {1} ")
    boolean DoAssert_equal(Object Actual, Object Expected, String message) {
        softAssert.assertEquals(Actual, Expected, message);
        if (String.valueOf(Expected) != String.valueOf(Actual)) {
            Save_screenshotPNG();
            Save_TestLog(message);
            return false;
        }

        return true;
    }
}
