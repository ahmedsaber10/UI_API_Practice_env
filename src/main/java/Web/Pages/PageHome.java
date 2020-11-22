package Web.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PageHome extends Page {
    By LOGIN = By.className("login");
    By T_SHIRT_BUTTON = By.xpath("//body/div[@id='page']/div[@class='header-container']/header[@id='header']/div/div[@class='container']/div[@class='row']/div[@id='block_top_menu']/ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[3]");//("T-shirts");//By.cssSelector("li[class='sfHover'] a[title='T-shirts']");
    By DRESSES_BUTTON = By.xpath("//body/div[@id='page']/div[@class='header-container']/header[@id='header']/div/div[@class='container']/div[@class='row']/div[@id='block_top_menu']/ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[2]");
    By WOMEN_BUTTON = By.cssSelector("li[class='sfHover'] a[title='Women']");
    By PRODUCT_CONTAINER = By.className("product_img_link");
    By ADD_TO_CART = By.className("button ajax_add_to_cart_button btn btn-default");

    public PageHome(WebDriver driver) {
        super(driver);
    }
    //  public By ACCOUNT_CREATE_ERR_MSSG =By.id("create_account_error");

    public PageHome waitUntil_Home_isLoaded() {
        wait.until(ExpectedConditions.elementToBeClickable(LOGIN));
        return this;
    }


    @Step("-Add product {0} to cart")
    public PageCart Click_On_ProductX(int ProductX) throws InterruptedException {
        Scroll_TillEnd();
        // ClickElement_by_Text(ProductX);
        Actions actions = new Actions(driver);

//        Actions actions = new Actions(driver);
        List<WebElement> elements = getProductContainer();
        actions.moveToElement(elements.get(ProductX)).click().build().perform();
//        Thread.sleep(60000);
//        clickElement(elements.get(ProductX));
//        elements.get(ProductX).click();
        //switch (product)
        //element(x).click();
//        for (WebElement tempElement : elements) {
//            System.out.println("Product  : " + tempElement.getAttribute("value")+" found");
//
//            if (tempElement.getAttribute("value") != null) {
////                System.out.println("Product  : " + tempElement.getAttribute("value")+" found");
//                if (tempElement.getAttribute("value").equalsIgnoreCase(ProductX)) {
//                    tempElement.click();
////                    clickElement(ADD_TO_CART);
//                    return new PageCart(driver);
//                }
//            }
//        }
        return new PageCart(driver);
    }
//        return new PageCart(driver);
//    }

    private List<WebElement> getProductContainer() {
        Scroll_To_Element_NoWait(PRODUCT_CONTAINER);
        return driver.findElements(PRODUCT_CONTAINER);
    }

    @Step("-Click on Login")
    public PageRegistration clickOnLogin() {
        clickOnElement(LOGIN);
        return new PageRegistration(driver);
    }

    @Step("-Click on T-shirt category")
    public PageHome clickOnTshirt() {
        clickOnElement(T_SHIRT_BUTTON);
        return this;
    }

    @Step("-Click on Dresses category")
    public PageHome clickOnDresses() {
        clickOnElement(DRESSES_BUTTON);
        return this;
    }

    @Step("-Click on Women category")
    public PageHome clickOnWomen() {
        clickOnElement(WOMEN_BUTTON);
        return this;
    }

}
