package co.com.sofka.stepdefinition.signin;

import co.com.sofka.exceptions.ValidationTextDoNotMatch;
import co.com.sofka.models.signin.SignInFormModel;
import co.com.sofka.stepdefinition.Setup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static co.com.sofka.exceptions.ValidationTextDoNotMatch.VALIDATION_DO_NOT_MATCH;
import static co.com.sofka.questions.signin.CustomerSignInSuccessfully.customerSignInSuccessfully;
import static co.com.sofka.questions.signin.CustomerWasSuccessfullyCreated.customerWasSuccessfullyCreated;
import static co.com.sofka.tasks.OpenLandingPage.openLandingPage;
import static co.com.sofka.tasks.signin.BrowseToSignIn.browseToSignIn;
import static co.com.sofka.tasks.signin.FillCreateAccountForm.fillCreateAccountForm;
import static co.com.sofka.tasks.signin.FillSignInForm.fillSignInForm;
import static co.com.sofka.userinterfaces.contactus.ContactUsPage.SUCCESS_ALERT;
import static co.com.sofka.userinterfaces.signin.SignInPage.CREATE_SUCCESSFUL;
import static co.com.sofka.userinterfaces.signin.SignInPage.SIGN_IN_SUCCESSFUL;
import static co.com.sofka.utils.contactus.Success.SUCCESS_MESSAGE;
import static co.com.sofka.utils.signin.SignedIn.MYACC;
import static co.com.sofka.utils.signin.Title.MR;
import static co.com.sofka.utils.signin.Title.MRS;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class SignInStepDefinition extends Setup {

    private static final Logger LOGGER = Logger.getLogger(SignInStepDefinition.class);
    private static final String ACTOR_NAME = "Iván";
    SignInFormModel signInFormModel;

    @Given("the client is in the landing page of Yours Logo and browse to the sign in section")
    public void theClientIsInTheLandingPageOfYoursLogoAndBrowseToTheSignInSection() {
        try{
            actorSetUpTheBrowser(ACTOR_NAME);

            theActorInTheSpotlight().wasAbleTo(
                    openLandingPage(),
                    browseToSignIn()
            );
        } catch (Exception e){
            Assertions.fail(e.getMessage());
            LOGGER.warn(e.getMessage(),e);
        }
    }

    // First scenario
    @When("the client wants to create an account, fill the form and submit it")
    public void theClientWantsToCreateAnAccountFillTheFormAndSubmitIt() {
        try{
            generateFullCustomer();

            theActorInTheSpotlight().attemptsTo(
                    fillCreateAccountForm()
                            .withTheEmail(signInFormModel.getEmail())
                            .andTheTitle(signInFormModel.getTitle())
                            .andTheFirstName(signInFormModel.getFirstName())
                            .andTheLastName(signInFormModel.getLastName())
                            .andThePassword(signInFormModel.getPassword())
                            .andTheAddress(signInFormModel.getAddress())
                            .andTheCity(signInFormModel.getCity())
                            .andTheZipCode(signInFormModel.getZipCode())
                            .andTheMobilePhone(signInFormModel.getMobilePhone())
                            .andFinallyTheAlias(signInFormModel.getAddressAlias())
            );
        } catch (Exception e){
            Assertions.fail(e.getMessage());
            LOGGER.warn(e.getMessage(),e);
        }
    }
    @Then("the client is redirected to my account and signed in")
    public void theClientIsRedirectedToMyAccountAndSignedIn() {
        try{
            theActorInTheSpotlight().should(
                    seeThat(
                            customerWasSuccessfullyCreated()
                                    .withTheWelcomeMessage(MYACC.getValue())
                                    .is(), equalTo(true)
                    )
                            .orComplainWith(
                                    ValidationTextDoNotMatch.class,
                                    String.format(VALIDATION_DO_NOT_MATCH, compareWithSystemOutcome())
                            ),
                    seeThat(
                            customerSignInSuccessfully()
                                    .withCustomersName(signInFormModel.getFirstName() + " " +
                                            signInFormModel.getLastName())
                                    .is(), equalTo(true)
                    )
                            .orComplainWith(
                                    ValidationTextDoNotMatch.class,
                                    String.format(VALIDATION_DO_NOT_MATCH, compareWithSignInOutcome())
                            )
            );
        } catch (Exception e){
            Assertions.fail(e.getMessage());
            LOGGER.warn(e.getMessage(),e);
        }
    }

    // Second scenario
    @When("the client want to sign in, fill the form and submit it")
    public void theClientWantToSignInFillTheFormAndSubmitIt() {
        try{
            generateSignInCustomer();

            theActorInTheSpotlight().attemptsTo(
                    fillSignInForm()
                            .withTheEmail(signInFormModel.getEmail())
                            .andThePassword(signInFormModel.getPassword())
            );
        } catch (Exception e){
            Assertions.fail(e.getMessage());
            LOGGER.warn(e.getMessage(),e);
        }
    }
    @Then("the client sign in the website")
    public void theClientSignInTheWebsite() {
        try{
            theActorInTheSpotlight().should(
                    seeThat(
                            customerSignInSuccessfully()
                                    .withCustomersName(signInFormModel.getFirstName() + " " +
                                            signInFormModel.getLastName())
                                    .is(), equalTo(true)
                    )
                            .orComplainWith(
                                    ValidationTextDoNotMatch.class,
                                    String.format(VALIDATION_DO_NOT_MATCH, compareWithSignInOutcome())
                            )
            );
        } catch (Exception e){
            Assertions.fail(e.getMessage());
            LOGGER.warn(e.getMessage(),e);
        }
    }

    private void generateFullCustomer(){
        signInFormModel = new SignInFormModel();
        signInFormModel.setTitle(MR.getValue());
        signInFormModel.setFirstName("Snow");
        signInFormModel.setLastName("Dust");
        signInFormModel.setEmail("snow.dust@myemail.com");
        signInFormModel.setPassword("SnowDust123");
        signInFormModel.setAddress("111 N, ORANGE WAY");
        signInFormModel.setCity("Orlando");
        signInFormModel.setZipCode("32789");
        signInFormModel.setMobilePhone("900123123");
        signInFormModel.setAddressAlias("Home");
    }

    private void generateSignInCustomer(){
        signInFormModel = new SignInFormModel();
        signInFormModel.setFirstName("Snow");
        signInFormModel.setLastName("Dust");
        signInFormModel.setEmail("snow.dust@myemail.com");
        signInFormModel.setPassword("SnowDust123");
    }

    private String compareWithSignInOutcome(){
        return "\n" + "Expected : System Outcome" +
                "\n" + signInFormModel.getFirstName() + " " + signInFormModel.getLastName() + " : " +
                SIGN_IN_SUCCESSFUL.resolveFor(theActorInTheSpotlight()).getText();
    }
    private String compareWithSystemOutcome(){
        return "\n" + "Expected : System Outcome" +
                "\n" + MYACC.getValue() + " : " +
                CREATE_SUCCESSFUL.resolveFor(theActorInTheSpotlight()).getText();
    }
}
