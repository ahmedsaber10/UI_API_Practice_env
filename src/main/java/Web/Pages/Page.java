package Web.Pages;

import Web.Util.SeleniumDriver;
import Web.Util.URLs;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
    public static boolean URLFirstTime = SeleniumDriver.driverInit;
    public String token = "";
    public By pageTitle = By.className("page-heading");
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String basicURL = URLs.HOME.getValue();
    JavascriptExecutor js;

    public Page(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        if (URLFirstTime) {
            driver.get(basicURL);
            URLFirstTime = false;
        }
        js = (JavascriptExecutor) driver;
    }

    protected void openURL(String url) {
        driver.navigate().to(url);
    }

    protected void Scroll_TillEnd() {
//        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js.executeScript("window.scrollTo(0, 500)");


    }

    protected void Scroll_To_Element(By element) {
        new Actions(driver).moveToElement(wait.until(ExpectedConditions.elementToBeClickable(element))).build().perform();

    }

    protected void Scroll_To_Element(WebElement element) {
        new Actions(driver).moveToElement(wait.until(ExpectedConditions.elementToBeClickable(element))).build().perform();

    }

    protected void Scroll_To_Element_NoWait(By element) {
        new Actions(driver).moveToElement(driver.findElement(element)).build().perform();

    }

    public String Get_Page_Url() {
        return driver.getCurrentUrl();
    }

    protected void visibilityWait(WebElement element) {

        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void visibilityWait(By element) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    protected void alertWait() {
        wait.until(ExpectedConditions.alertIsPresent());
    }

    protected void clickElement(WebElement element) {
        Scroll_To_Element(element);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(element)).click();
        element.click();
    }


    protected void clickElement(By element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
        driver.findElement(element).click();
    }

    protected void sendText(WebElement element, String text) {
        visibilityWait(element);
        element.clear();
        element.sendKeys(text);
    }

    public String getAlertMessage() {
        alertWait();
        return driver.switchTo().alert().getText();
    }

    @Step("-Go back")
    public Page goBack() {
        driver.navigate().back();
        return this;
    }

    protected void ClickElement_by_Text(String text) {
        clickElement(By.xpath("//*[text() = '" + text + "']"));

    }

    protected void clickOnElement(By element) {
        Scroll_To_Element(element);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();

    }

    protected void sendText(By element, String text) {
        Scroll_To_Element(element);
        wait.until(ExpectedConditions.elementToBeClickable(element)).clear();
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text);
    }

    public boolean Check_Element_isDisplayed(By element) {
        try {
            visibilityWait(element);
            driver.findElement(element).isDisplayed();
        } catch (Exception e) {
            System.out.println("Couldn't find element" + element);
            return false;
        }
        return true;
    }

    protected boolean Check_Element_isSelected(By element) {
        visibilityWait(element);
        return driver.findElement(element).isSelected();
    }

    public boolean Check_Element_isEnabled(By element) {
        visibilityWait(element);
        return driver.findElement(element).isEnabled();
    }

    protected String get_Element_Text(By element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element)).getText();
    }

    protected String get_Element_Attribute(By element, String attribute) {
        return driver.findElement(element).getAttribute(attribute);
    }

    protected boolean Check_Element_is_Not_Displayed(By element) {
        try {
            driver.findElement(element).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException NoSuchElementException) {
            NoSuchElementException.getSuppressed();
            System.out.println("Element [" + element + "]" + " is not displayed");
        }
        return false;
    }

    protected String checkElementIsChecked(By element) {

        return wait.until(ExpectedConditions.elementToBeClickable(element)).getAttribute("checked");
    }

    protected void click_ElementBy_Text(String text) {
        wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//*[@text= '" + text + "']")))).click();
    }

    protected boolean Check_Element_isDisplayed_By_Text(String text) {
        try {
            return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@text= '" + text + "']")))).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException NoSuchElementException) {
            NoSuchElementException.getSuppressed();
            System.out.println("Element [" + text + "]" + " is not displayed");
        }
        return false;
    }
}


