package co.com.sofka.userinterfaces.signin;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

import static org.openqa.selenium.By.*;

public class SignInPage extends PageObject {

    // To reach the sing in forms
    public static final Target SIGN_IN = Target
            .the("Sign In")
            .located(className("login"));

    // Sing in form
    public static final Target SIGN_IN_EMAIL = Target
            .the("Sign In email field")
            .located(id("email"));
    public static final Target SIGN_IN_PASSWORD = Target
            .the("Sign In password field")
            .located(id("passwd"));
    public static final Target SIGN_IN_BUTTON = Target
            .the("Sign In submit button")
            .located(id("SubmitLogin"));

    // Create Account form
    public static final Target CREATE_EMAIL = Target
            .the("Create account email")
            .located(id("email_create"));
    public static final Target CREATE_ACCOUNT_BUTTON = Target
            .the("Create account button")
            .located(id("SubmitCreate"));
    public static final Target CREATE_TITLE_MR = Target
            .the("Create title Mr. field")
            .located(xpath("//label[@for='id_gender1']"));
    public static final Target CREATE_TITLE_MRS = Target
            .the("Create title Mrs. field")
            .located(xpath("//label[@for='id_gender2']"));
    public static final Target CREATE_FIRST_NAME = Target
            .the("Create first name field")
            .located(id("customer_firstname"));
    public static final Target CREATE_LAST_NAME = Target
            .the("Create last name field")
            .located(id("customer_lastname"));
    public static final Target CREATE_PASSWORD = Target
            .the("Create password field")
            .located(id("passwd"));
    public static final Target CREATE_ADDRESS = Target
            .the("Create address field")
            .located(id("address1"));
    public static final Target CREATE_CITY = Target
            .the("Create city field")
            .located(id("city"));
    public static final Target CREATE_STATE = Target
            .the("Create state field")
            .located(xpath("//option[text()='Florida']"));
    public static final Target CREATE_ZIP_CODE = Target
            .the("Create zip code field")
            .located(id("postcode"));
    public static final Target CREATE_MOBILE_PHONE = Target
            .the("Create mobile phone field")
            .located(id("phone_mobile"));
    public static final Target CREATE_ADDRESS_ALIAS = Target
            .the("Create address alias field")
            .located(id("alias"));
    public static final Target CREATE_SUBMIT_BUTTON = Target
            .the("Create submit button")
            .located(id("submitAccount"));

    // For validation
    public static final Target SIGN_IN_SUCCESSFUL = Target
            .the("Sign in successful authentication")
            .located(xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span"));
    public static final Target CREATE_SUCCESSFUL = Target
            .the("Create My account success login")
            .located(xpath("//*[@id=\"center_column\"]/h1"));
}
