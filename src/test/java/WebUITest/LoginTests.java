package WebUITest;

import Web.Pages.PageHome;
import Web.Pages.PageRegistration;
import Web.Pages.Page_MyAccount;
import Web.Util.URLs;
import org.testng.annotations.Test;

public class LoginTests extends BaseTestClass {

    PageHome Home;
    PageRegistration Register;
    Page_MyAccount MyAccount;
    String[] email = {"eng_ahmed_saber_gmail.com", "testing0Regstration@hotmail.com", "testing0Regstration@hotmail.com"};
    String[] password = {"43443", "4430244302", "44302"};

    /*
    invalid email
    invalid password
    --
    valid email
    invalid password
    ---
    valid email
    valid pass
     */
    @Test(priority = 1, description = "Check that invalid email will be detected   ")
    public void Login_InvalidEmail_Check() {
        Home = new PageHome(driver);
        Register = Home.waitUntil_Home_isLoaded()
                .clickOnLogin()
                .Enter_Email(email[0])
                .Enter_Password(password[0]);
        Register.clickOnSignIn();
        DoAssert_equal(Register.Check_Element_isDisplayed(Register.REGISTRATION_ERR_MESSAGE), true, "Error message is not displayed");
        softAssert.assertAll();
    }

    @Test(priority = 2, description = "Check that valid email and invalid password will be detected   ")
    public void Login_ValidEmail_Invalid_Password_Check() {
        Home = new PageHome(driver);
        Register = Home.waitUntil_Home_isLoaded()
                .clickOnLogin().Enter_Email(email[1]).Enter_Password(password[1]);
        Register.clickOnSignIn();
        DoAssert_equal(Register.Check_Element_isDisplayed(Register.REGISTRATION_ERR_MESSAGE), true, "Error message is not displayed");
        softAssert.assertAll();
    }

    @Test(priority = 3, description = "Check that user can login with valid credentials ")
    public void Login_ValidEmail_Valid_Password_Check() {
        Home = new PageHome(driver);
        Register = Home.waitUntil_Home_isLoaded()
                .clickOnLogin().Enter_Email(email[2]).Enter_Password(password[2]);
        MyAccount = Register.clickOnSignIn();
        DoAssert_equal(Register.Check_Element_isDisplayed(Register.REGISTRATION_ERR_MESSAGE), false, "Error message is  displayed however nothing wrong");
        DoAssert_equal(MyAccount.Get_Page_Url(), URLs.MY_ACCOUNT.getValue(), "My account page is not opened");
        softAssert.assertAll();
    }
}
