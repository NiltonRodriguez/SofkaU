package co.com.sofka.userinterfaces.contactus;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class ContactUsPage extends PageObject {

    // To reach the contact us form.
    public static final Target CONTACT_US = Target
            .the("Contact Us")
            .located(xpath("//*[@id=\"contact-link\"]/a"));

    // Contact form fields
    public static final Target CUSTOMER_SERVICE_OPTION = Target
            .the("Customer service option")
            .located(xpath("//option[text()='Customer service']"));
    public static final Target WEBMASTER_OPTION = Target
            .the("Webmaster option")
            .located(xpath("//option[text()='Webmaster']"));
    public static final Target EMAIL_FIELD = Target
            .the("Email field")
            .located(id("email"));
    public static final Target ORDER_FIELD = Target
            .the("Order field")
            .located(id("id_order"));
    public static final Target MESSAGE_FIELD = Target
            .the("Message field")
            .located(id("message"));
    public static final Target SUBMIT_MESSAGE_BUTTON = Target
            .the("Submit message button")
            .located(id("submitMessage"));

    // For validation.
    public static final Target SUCCESS_ALERT = Target
            .the("Success alert")
            .located(xpath("//p[@class='alert alert-success']"));
}
