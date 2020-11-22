package Web.Util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumDriver {
    public static boolean driverInit = true;
    WebDriver driver;

    public WebDriver SeleniumDriverSetup(String browser) throws Exception {

        // Check if parameter passed fromאtestng.xml is 'firefox'
        if (browser.equalsIgnoreCase("firefox")) {
            String exePath = System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\geckodriver.exe";
            System.setProperty("webdriver.firefox.driver", exePath);
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            return driver;

        }
        // Check if parameter passed from testng.xml is 'chrome'
        else if
        (browser.equalsIgnoreCase("chrome")) {
            String exePath = System.getProperty("user.dir") + "\\src\\main\\java\\Web\\Resources\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", exePath);
            // Create chrome instance
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            return driver;
        } else {
            throw new Exception("Browser is not correct");

        }
    }

    public void driverQuit() {
        driver.quit();
    }
}
