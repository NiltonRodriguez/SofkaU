package co.com.sofka.stepdefinition.contactus;

import co.com.sofka.exceptions.ValidationTextDoNotMatch;
import co.com.sofka.models.contactus.ContactUsFormModel;
import co.com.sofka.stepdefinition.Setup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static co.com.sofka.exceptions.ValidationTextDoNotMatch.VALIDATION_DO_NOT_MATCH;
import static co.com.sofka.questions.contactus.ContactFormWasSuccessfullySend.contactFormWasSuccessfullySend;
import static co.com.sofka.tasks.OpenLandingPage.openLandingPage;
import static co.com.sofka.tasks.contactus.BrowseToContactUs.browseToContactUs;
import static co.com.sofka.tasks.contactus.FillContactForm.fillContactForm;
import static co.com.sofka.userinterfaces.contactus.ContactUsPage.SUCCESS_ALERT;
import static co.com.sofka.utils.contactus.Subject.CUSTOMERSERVICE;
import static co.com.sofka.utils.contactus.Subject.WEBMASTER;
import static co.com.sofka.utils.contactus.Success.SUCCESS_MESSAGE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class ContactUsStepDefinition extends Setup {

    private static final Logger LOGGER = Logger.getLogger(ContactUsStepDefinition.class);
    private static final String ACTOR_NAME = "Iván";
    ContactUsFormModel contactUsFormModel;

    @Given("the client is in the landing page of Yours Logo")
    public void theClientIsInTheLandingPageOfYoursLogo() {
        try{
            actorSetUpTheBrowser(ACTOR_NAME);

            theActorInTheSpotlight().wasAbleTo(
                    openLandingPage()
            );
        } catch (Exception e){
            Assertions.fail(e.getMessage());
            LOGGER.warn(e.getMessage(),e);
        }
    }

    // First Scenario
    @When("the client browse to the contact us section, fill the form and submit message to customer service")
    public void theClientBrowseToTheContactUsSectionFillTheFormAndSubmitMessageToCustomerService() {
        try{
            generateCustomer(
                    CUSTOMERSERVICE.getValue(),
                    "snow.flake@myemail.com",
                    "00001",
                    "I haven't received my order yet"
                    );

            theActorInTheSpotlight().attemptsTo(
                    browseToContactUs(),
                    fillContactForm()
                            .withSubject(contactUsFormModel.getSubject())
                            .andTheEmail(contactUsFormModel.getEmail())
                            .andTheReference(contactUsFormModel.getReference())
                            .andTheMessage(contactUsFormModel.getMessage())

            );
        } catch (Exception e){
            Assertions.fail(e.getMessage());
            LOGGER.warn(e.getMessage(),e);
        }
    }
    @Then("the client see a success alert")
    public void theClientSeeASuccessAlert() {
        try{
            theActorInTheSpotlight().should(
                    seeThat(
                            contactFormWasSuccessfullySend()
                                    .withSuccessMessage(SUCCESS_MESSAGE.getValue())
                                    .is(), equalTo(true)
                    )
                            .orComplainWith(
                                    ValidationTextDoNotMatch.class,
                                    String.format(VALIDATION_DO_NOT_MATCH, compareWithSystemOutcome())
                            )
            );
        } catch (Exception e){
            Assertions.fail(e.getMessage());
            LOGGER.warn(e.getMessage(),e);
        }
    }

    // Second Scenario
    @When("the client browse to the contact us section, fill the form and submit message to the webmaster")
    public void theClientBrowseToTheContactUsSectionFillTheFormAndSubmitMessageToTheWebmaster() {
        try{
            generateCustomer(
                    WEBMASTER.getValue(),
                    "eva.host@myemail.com",
                    "00002",
                    "I didn't receive the confirmation of my order"
            );

            theActorInTheSpotlight().attemptsTo(
                    browseToContactUs(),
                    fillContactForm()
                            .withSubject(contactUsFormModel.getSubject())
                            .andTheEmail(contactUsFormModel.getEmail())
                            .andTheReference(contactUsFormModel.getReference())
                            .andTheMessage(contactUsFormModel.getMessage())

            );
        } catch (Exception e){
            Assertions.fail(e.getMessage());
            LOGGER.warn(e.getMessage(),e);
        }
    }
    @Then("the client see a success message")
    public void theClientSeeASuccessMessage() {
        try{
            theActorInTheSpotlight().should(
                    seeThat(
                            contactFormWasSuccessfullySend()
                                    .withSuccessMessage(SUCCESS_MESSAGE.getValue())
                                    .is(), equalTo(true)
                    )
                            .orComplainWith(
                                    ValidationTextDoNotMatch.class,
                                    String.format(VALIDATION_DO_NOT_MATCH, compareWithSystemOutcome())
                            )
            );
        } catch (Exception e){
            Assertions.fail(e.getMessage());
            LOGGER.warn(e.getMessage(),e);
        }
    }

    private void generateCustomer(String subject, String email, String reference, String message){
        contactUsFormModel = new ContactUsFormModel();
        contactUsFormModel.setSubject(subject);
        contactUsFormModel.setEmail(email);
        contactUsFormModel.setReference(reference);
        contactUsFormModel.setMessage(message);
    }

    private String compareWithSystemOutcome(){
        return "\n" + "Expected : System Outcome" +
                "\n" + SUCCESS_MESSAGE.getValue() + " : " + SUCCESS_ALERT.resolveFor(theActorInTheSpotlight()).getText();
    }
}
