package Web.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageLogin extends Page {
    By EMAIL_LOGIN = By.id("email");
    By PASSWORD = By.id("passwd");
    By FORGOT_PASSWORD = By.linkText("Forgot your password?");
    By SIGN_IN = By.id("SubmitLogin");

    public PageLogin(WebDriver driver) {
        super(driver);
    }
    //Error message locator is not unique , can be located by its text!

    @Step("-Enter Email address : {0}")
    public PageLogin EnterLoginEmailAddress(String email) {
        sendText(EMAIL_LOGIN, email);
        return this;
    }

    @Step("-Enter Password : {0}")
    public PageLogin EnterPassword(String password) {
        sendText(PASSWORD, password);
        return this;
    }

    @Step("-Click SIGN IN")
    public PageLogin ClickOnSignIn() {
        clickElement(SIGN_IN);
        return this;
    }

    @Step("-Click forgot password")
    public PageLogin ClickOnForgotPassword() {
        clickElement(FORGOT_PASSWORD);
        return this;
    }

    @Step("-Check if error message contains : {0}")
    public boolean CheckErrorMessageEqual(String ExpectedError) {
        return Check_Element_isDisplayed_By_Text(ExpectedError);
    }
}
