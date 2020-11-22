package WebUITest;

import Web.Pages.PageCart;
import Web.Pages.PageHome;
import Web.Pages.PageRegistration;
import Web.Pages.Page_MyAccount;
import org.testng.annotations.Test;

public class AddToCartTests extends BaseTestClass {

    PageHome Home;
    PageRegistration Register;
    Page_MyAccount MyAccount;
    PageCart Cart;

    /*
    add to cart
    1-logged in , not logged in user
    2- happy scenario
    a.Categories Dresses, t-shirts and women
    b.Choose ad , click on add to cart
     */

    @Test(priority = 2, description = "Check that Logged in User Can   add product to cart and finish checkout process")
    public void Check_that_Logged_in_User_Can_Add_Product_ToCartAnd_Finish_Checkout_Process() throws InterruptedException {
        Home = new PageHome(driver);
        Cart = Home.clickOnDresses()
                .Click_On_ProductX(0)
                .ClickOnAddToCart()
                .ClickOnProceed_toCheckout()
                .ClickOnProceed_toCheckout1()
                .ClickOnProceed_toCheckout2()
                .ClickOnTermsConditions()
                .ClickOnProceed_toCheckout3()
                .ClickOnPay_ByBank()
                .ClickOnConfirmOrder();
        DoAssert_equal(Cart.Check_Element_isDisplayed(Cart.ORDER_COMPLETION_TEXT), true, "Confirmation message is not displayed , order is not completed ");
        softAssert.assertAll();
    }

    @Test(priority = 1, description = "Check that not Logged in User Can   add product to cart and finish checkout process")
    public void Check_that_NotLogged_in_User_Can_Add_Product_ToCartAnd_Finish_Checkout_Process() throws InterruptedException {
        Home = new PageHome(driver);
        Register = new PageRegistration(driver);
        Cart = Home.clickOnDresses()
                .Click_On_ProductX(0)
                .ClickOnAddToCart()
                .ClickOnProceed_toCheckout()
                .ClickOnProceed_toCheckout1();
        Register.Enter_Email("testing0Regstration@hotmail.com")
                .Enter_Password("44302")
                .clickOnSignIn();
        Cart.ClickOnProceed_toCheckout2()
                .ClickOnTermsConditions()
                .ClickOnProceed_toCheckout3()
                .ClickOnPay_ByBank()
                .ClickOnConfirmOrder();
        DoAssert_equal(Cart.Check_Element_isDisplayed(Cart.ORDER_COMPLETION_TEXT), true, "Confirmation message is not displayed , order is not completed ");
        softAssert.assertAll();
    }
}
