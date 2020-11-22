package Web.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageCart extends Page {
    public By ORDER_COMPLETION_TEXT = By.xpath("//span[@class='price']");
    By ADD_TO_CART = By.xpath("//button[@name='Submit']");

    By TOTAL_PRODUCT = By.cssSelector("span[class='ajax_block_products_total']");
    By TOTAL_SHIPPING = By.cssSelector("span[class='ajax_cart_shipping_cost']");
    By TOTAL = By.cssSelector("span[class='ajax_cart_shipping_cost']");

    By PROCEED_TO_CHECKOUT = By.cssSelector("a[title='Proceed to checkout']");
    By CONTINUE_SHOPPING = By.cssSelector("span[title='Continue shopping']");
    By PROCEED_TO_CHECKOUT1 = By.cssSelector("a[class='button btn btn-default standard-checkout button-medium']");
    By PROCEED_TO_CHECKOUT2 = By.cssSelector("button[name='processAddress']");
    By PROCEED_TO_CHECKOUT3 = By.cssSelector("button[name='processCarrier']");
    By TERMS_CONDITIONS = By.xpath("//label[@for='cgv']");
    By PAY_BANK_WIRE = By.xpath("//a[@title='Pay by bank wire']");

    By CONFIRM_MY_ORDER = By.xpath("//button[@class='button btn btn-default button-medium']");

    public PageCart(WebDriver driver) {
        super(driver);
    }

    @Step("-Mark terms and conditions check box")
    public PageCart ClickOnAddToCart() throws InterruptedException {
        Thread.sleep(10000);
        driver.get("http://automationpractice.com/index.php?id_product=4&controller=product");

//        driver.switchTo().frame((WebElement) driver.findElement(By.xpath("//iframe [@id='fancybox-frame1605876200332']")));
        clickOnElement(ADD_TO_CART);
        driver.switchTo().defaultContent();

        return this;
    }

    @Step("-Mark terms and conditions check box")
    public PageCart ClickOnTermsConditions() {
        clickOnElement(TERMS_CONDITIONS);
        return this;
    }

    @Step("-Click on pay by bank wire")
    public PageCart ClickOnPay_ByBank() {
        clickOnElement(PAY_BANK_WIRE);
        return this;
    }

    @Step("-Click on pay by bank wire")
    public PageCart ClickOnConfirmOrder() {
        clickOnElement(CONFIRM_MY_ORDER);
        return this;
    }

    @Step("-Get order completion text")
    public String Get_OrderCompletion_Text() {
        return get_Element_Attribute(ORDER_COMPLETION_TEXT, "value");
    }

    @Step("-Click on proceed to check out")
    public PageCart ClickOnProceed_toCheckout() {
        clickOnElement(PROCEED_TO_CHECKOUT);
        return this;
    }

    @Step("-Click on proceed to 2nd check out")
    public PageCart ClickOnProceed_toCheckout1() {
        clickOnElement(PROCEED_TO_CHECKOUT1);
        return this;
    }

    @Step("-Click on proceed to 3rd check out")
    public PageCart ClickOnProceed_toCheckout2() {
        clickOnElement(PROCEED_TO_CHECKOUT2);
        return this;
    }

    @Step("-Click on proceed to 4th check out")
    public PageCart ClickOnProceed_toCheckout3() {
        clickOnElement(PROCEED_TO_CHECKOUT3);
        return this;
    }

    @Step("-Get Total product")
    public String Get_Total_Product_Text() {
        return get_Element_Attribute(TOTAL_PRODUCT, "value");
    }

    @Step("-Get Total shipping")
    public String Get_Total_Shipping_Text() {
        return get_Element_Attribute(TOTAL_SHIPPING, "value");
    }

    @Step("-Get total ")
    public String Get_Total_Text() {
        return get_Element_Attribute(TOTAL, "value");
    }


}
