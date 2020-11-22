package WebUITest;

import Web.Pages.PageHome;
import Web.Pages.PageRegistration;
import Web.Pages.Page_MyAccount;
import Web.Util.URLs;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

@Epic("Web E2E/Regression test")
@Feature("Registration")
public class RegistrationTests extends BaseTestClass {
    PageHome Home;
    PageRegistration Register;
    Page_MyAccount MyAccount;
    String[] email = {"engahmedsaber4@gmail.com", "invalid email", " ", "testing44Regstration@hotmail.com"};

    @Test(priority = 1, description = "Check that already registered email can't create account again  ")
    public void CreateAccount_withAlready_RegisteredEmail() {
        Home = new PageHome(driver);
        Register = Home.waitUntil_Home_isLoaded()
                .clickOnLogin();
        Register.EnterCreateEmailAddress(email[0])
                .ClickOnCreateAccount();
        DoAssert_equal(Register.Check_Element_isDisplayed(Register.EMAIL_ERR_MESSAGE), true, "already registered email accepted");
        softAssert.assertAll();
    }

    @Test(priority = 2, description = "Check that invalid email format can't create account ")
    public void CreateAccount_with_InvalidEmail_format() {
        Register = new PageRegistration(driver);
        Register.EnterCreateEmailAddress(email[1])
                .ClickOnCreateAccount();
        DoAssert_equal(Register.Check_Element_isDisplayed(Register.EMAIL_ERR_MESSAGE), true, "invalid email can register!");
        softAssert.assertAll();
    }

    @Test(priority = 3, description = "Check that Empty email field can't create account ")
    public void CreateAccount_with_EmptyEmail() {
        Register = new PageRegistration(driver);
        Register.EnterCreateEmailAddress(email[2])
                .ClickOnCreateAccount();
        DoAssert_equal(Register.Check_Element_isDisplayed(Register.EMAIL_ERR_MESSAGE), true, "empty email can register!");
        softAssert.assertAll();
    }

    @Test(priority = 4, description = "Check that Not registered email can create account ")
    public void CreateAccount_with_NewAccount() {
        Register = new PageRegistration(driver);
        Register.EnterCreateEmailAddress(email[3])
                .ClickOnCreateAccount();
        DoAssert_equal(Register.Check_Element_isDisplayed(Register.EMAIL_ERR_MESSAGE), false, "Error message with invalid email is displayed when enter new email");
        DoAssert_equal(Register.Check_Element_isDisplayed(Register.REGISTRATION_FORM), true, "Error message with invalid email is displayed when enter new email");
        softAssert.assertAll();
    }

    @Test(priority = 5, description = "Check that User can't registered with out filling mandatory fields  ")
    public void CheckThat_User_Cant_Register_WithOut_Filling_Mandatory_Fields() {
        Register = new PageRegistration(driver);
        Register.ClickOn_Register();
        DoAssert_equal(Register.Check_Element_isDisplayed(Register.REGISTRATION_ERR_MESSAGE), true, "Error message is not displayed");
        DoAssert_equal(Register.Check_Element_isDisplayed(Register.REGISTRATION_FORM), true, "Error message with invalid email is displayed when enter new email");
        Register.Enter_First_Name("firstName")
                .Enter_Last_Name("last name test")
                .Enter_Password("443021")
                .ClickOn_Register();
        DoAssert_equal(Register.Check_Element_isDisplayed(Register.REGISTRATION_ERR_MESSAGE), true, "Error message is not displayed");
        DoAssert_equal(Register.Check_Element_isDisplayed(Register.REGISTRATION_FORM), true, "Error message with invalid email is displayed when enter new email");
        Register.Enter_Address_First_Name("Address f name")
                .Enter_Address_Last_Name("address second name")
                .ClickOn_Register();
        DoAssert_equal(Register.Check_Element_isDisplayed(Register.REGISTRATION_ERR_MESSAGE), true, "Error message is not displayed");
        DoAssert_equal(Register.Check_Element_isDisplayed(Register.REGISTRATION_FORM), true, "Error message with invalid email is displayed when enter new email");
        Register.Enter_Address1("st name,block name , city,country")
                .Enter_City("Hell")
                .Enter_AddrState("Alaska")
                .ClickOn_Register();
        DoAssert_equal(Register.Check_Element_isDisplayed(Register.REGISTRATION_ERR_MESSAGE), true, "Error message is not displayed");
        DoAssert_equal(Register.Check_Element_isDisplayed(Register.REGISTRATION_FORM), true, "Error message with invalid email is displayed when enter new email");

        Register.Enter_AddrZIP_Code("44112")
                .Enter_AddrCompany("confidential ")
                .ClickOn_Register();
        DoAssert_equal(Register.Check_Element_isDisplayed(Register.REGISTRATION_ERR_MESSAGE), true, "Error message is not displayed");
        DoAssert_equal(Register.Check_Element_isDisplayed(Register.REGISTRATION_FORM), true, "Error message with invalid email is displayed when enter new email");

        Register.Enter_HomePhone("01110111252")
                .ClickOn_Register();

        DoAssert_equal(Register.Check_Element_isDisplayed(Register.REGISTRATION_ERR_MESSAGE), true, "Error message is not displayed");
        DoAssert_equal(Register.Check_Element_isDisplayed(Register.REGISTRATION_FORM), true, "Error message with invalid email is displayed when enter new email");

        Register.Enter_ALLIS_ADDR("allis test address ")
                .ClickOn_Register();

        DoAssert_equal(Register.Check_Element_isDisplayed(Register.REGISTRATION_ERR_MESSAGE), true, "Error message is not displayed");
        DoAssert_equal(Register.Check_Element_isDisplayed(Register.REGISTRATION_FORM), true, "Error message with invalid email is displayed when enter new email");
        softAssert.assertAll();
    }

    @Test(priority = 6, description = "Check that password field is rest when user try to register and not completed his request, verify less min pass   ")
    public void CheckThat_PasswordField_isRest_whenRegister_RequestIsNot_Completed() {
        Register = new PageRegistration(driver);
        Register.ClickOn_Register();
        DoAssert_equal(Register.Check_Element_isDisplayed(Register.REGISTRATION_ERR_MESSAGE), true, "Error message is not displayed");
        DoAssert_equal(Register.Check_Element_isDisplayed(Register.REGISTRATION_FORM), true, "Error message with invalid email is displayed when enter new email");
        Register.Enter_Password("4430")
                .ClickOn_Register();
        DoAssert_equal(Register.Check_Element_isDisplayed(Register.REGISTRATION_ERR_MESSAGE), true, "Error message is not displayed");
        DoAssert_equal(Register.Check_Element_isDisplayed(Register.REGISTRATION_FORM), true, "Error message with invalid email is displayed when enter new email");
        MyAccount = Register.Enter_Password("44302")
                .ClickOn_Register();
        DoAssert_equal(MyAccount.Get_Page_Url(), URLs.MY_ACCOUNT.getValue(), "My account page is not opened");
        softAssert.assertAll();
    }
}
