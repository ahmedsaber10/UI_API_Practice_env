package Web.Pages;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class PageRegistration extends Page {
    //........Registration locators
    public By EMAIL_ERR_MESSAGE = By.id("create_account_error");
    public By REGISTRATION_ERR_MESSAGE = By.xpath("//div[@class='alert alert-danger']");
    public By REGISTRATION_FORM = By.id("account-creation_form");
    //region locators
    Select dropdown;
    By EMAIL_CREATE = By.id("email_create");
    By CREATE_ACCOUNT = By.id("SubmitCreate");
    //GENDER
    By GENDER_MALE = By.id("id_gender1");
    By GENDER_FEMALE = By.id("id_gender2");
    //NAME,EMAIL, PASSWORD
    By FIRST_NAME = By.id("customer_firstname");
    By LAST_NAME = By.id("customer_lastname");
    By EMAIL = By.id("email");
    By PASSWORD = By.id("passwd");
    By SIGN_IN = By.id("SubmitLogin");
    By DAY = By.id("days");

    //DATE
    By MONTH = By.id("email");
    By YEAR = By.id("email");
    //ADDRESS
    //use scrollable
    By SCROLLABLE_ADDRESS = By.xpath("//div[@class='columns-container']//div[2]//h3[1]");
    By FIRST_NAME_ADDR = By.id("firstname");
    By LAST_NAME_ADDR = By.id("lastname");
    By COMPANY_ADDR = By.id("company");
    By ADDRESS = By.id("address1");
    By ADDRESS2 = By.id("address2");
    By CITY = By.id("city");
    By STATE = By.id("id_state");
    By ZIP_CODE = By.id("postcode");
    //use scrollable
    By COUNTRY = By.id("id_country");
    By ADDITIONAL_INFO = By.id("other");
    By H_PHONE = By.id("phone");
    By M_PHONE = By.id("phone_mobile");
    By ALLIS_ADDR = By.id("alias");
    By REGISTER = By.id("submitAccount");

    public PageRegistration(WebDriver driver) {
        super(driver);
    }
    //endregion

    @Step("-Enter Email address : {0}")
    public PageRegistration EnterCreateEmailAddress(String email) {
        sendText(EMAIL_CREATE, email);
        return this;
    }

    @Step("-Click CREATE ACCOUNT button")
    public PageRegistration ClickOnCreateAccount() {
        clickElement(CREATE_ACCOUNT);
        return this;
    }

    @Step("-Read email error message")
    public String Get_Email_error_MSG() {
        return get_Element_Text(EMAIL_ERR_MESSAGE);
    }

    //................................Registration page functions.................................//
    @Step("-Choose Mr")
    public PageRegistration EnterGenderMR() {

        clickOnElement(GENDER_MALE);
        return this;
    }

    @Step("-Choose Mrs")
    public PageRegistration EnterGenderMRs() {

        clickOnElement(GENDER_FEMALE);
        return this;
    }

    @Step("-Click on Sign in")
    public Page_MyAccount clickOnSignIn() {
        clickElement(SIGN_IN);
        return new Page_MyAccount(driver);
    }

    @Step("-Enter First name : {0}")
    public PageRegistration Enter_First_Name(String firstName) {
        sendText(FIRST_NAME, firstName);
        return this;
    }

    @Step("-Enter Last name : {0}")
    public PageRegistration Enter_Last_Name(String lastName) {
        sendText(LAST_NAME, lastName);
        return this;
    }

    @Step("-Enter EMAIL : {0}")
    public PageRegistration Enter_Email(String email) {
        sendText(EMAIL, email);
        return this;
    }

    @Step("-Enter password : {0}")
    public PageRegistration Enter_Password(String password) {
        sendText(PASSWORD, password);
        return this;
    }

    @Step("-Enter birth day : {0}")
    public PageRegistration Enter_Birth_Day(String day) {
        Scroll_To_Element_NoWait(DAY);
        dropdown = new Select(driver.findElement(DAY));
        dropdown.selectByVisibleText(day);
        return this;
    }

    @Step("-Enter birth month : {0}")
    public PageRegistration Enter_Birth_Month(String month) {
        Scroll_To_Element_NoWait(MONTH);
        dropdown = new Select(driver.findElement(MONTH));
        dropdown.selectByVisibleText(month);
        return this;
    }

    @Step("-Enter birth year : {0}")
    public PageRegistration Enter_Birth_Year(String year) {
        Scroll_To_Element_NoWait(YEAR);
        dropdown = new Select(driver.findElement(YEAR));
        dropdown.selectByVisibleText(year);
        return this;
    }

    @Step("-Enter Address First Name  : {0}")
    public PageRegistration Enter_Address_First_Name(String FName) {
        sendText(FIRST_NAME_ADDR, FName);
        return this;
    }

    @Step("-Enter Address Last Name : {0}")
    public PageRegistration Enter_Address_Last_Name(String LName) {
        sendText(LAST_NAME_ADDR, LName);
        return this;
    }

    @Step("-Enter Address company : {0}")
    public PageRegistration Enter_AddrCompany(String company) {
        sendText(COMPANY_ADDR, company);
        return this;
    }

    @Step("-Enter Address1 : {0}")
    public PageRegistration Enter_Address1(String Address1) {
        sendText(ADDRESS, Address1);
        return this;
    }

    @Step("-Enter Address2 : {0}")
    public PageRegistration Enter_Address2(String Address2) {
        sendText(ADDRESS2, Address2);
        return this;
    }

    @Step("-Enter City : {0}")
    public PageRegistration Enter_City(String city) {
        sendText(CITY, city);
        return this;
    }

    @Step("-Enter State : {0}")
    public PageRegistration Enter_AddrState(String State) {
        Scroll_To_Element_NoWait(STATE);
        dropdown = new Select(driver.findElement(STATE));
        dropdown.selectByVisibleText(State);
        return this;
    }

    @Step("-Enter ZIP code : {0}")
    public PageRegistration Enter_AddrZIP_Code(String ZIP_Code) {
        sendText(ZIP_CODE, ZIP_Code);
        return this;
    }

    //Country additional info
    @Step("-Enter addo=itional info : {0}")
    public PageRegistration Enter_Additional_Info(String addInfo) {
        sendText(ADDITIONAL_INFO, addInfo);
        return this;
    }

    @Step("-Enter Home Phone : {0}")
    public PageRegistration Enter_HomePhone(String homePhone) {
        sendText(H_PHONE, homePhone);
        return this;
    }

    @Step("-Enter Mobile Phone : {0}")
    public PageRegistration Enter_MobilePhone(String mobilePhone) {
        sendText(M_PHONE, mobilePhone);
        return this;
    }

    @Step("-Enter allis Address : {0}")
    public PageRegistration Enter_ALLIS_ADDR(String allis_Address) {
        sendText(ALLIS_ADDR, allis_Address);
        return this;
    }

    @Step("-Click on Register ")
    public Page_MyAccount ClickOn_Register() {
        clickOnElement(REGISTER);
        return new Page_MyAccount(driver);
    }
    //TODO TRY SCROLL TO ELEMENT


}
