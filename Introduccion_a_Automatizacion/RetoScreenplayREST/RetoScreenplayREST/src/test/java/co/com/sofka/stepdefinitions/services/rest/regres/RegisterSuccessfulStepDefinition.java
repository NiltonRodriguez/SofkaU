package co.com.sofka.stepdefinitions.services.rest.regres;

import co.com.sofka.ReqresSetup;
import co.com.sofka.model.register.Response;
import co.com.sofka.model.register.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static co.com.sofka.model.register.ErrorMessage.ERROR;
import static co.com.sofka.question.ReturnRegisterJsonResponse.returnRegisterJsonResponse;
import static co.com.sofka.task.DoPost.doPost;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class RegisterSuccessfulStepDefinition extends ReqresSetup {
    private static final Logger LOGGER = Logger.getLogger(RegisterSuccessfulStepDefinition.class);
    private User user;

    @Given("the allowed user is in the website registration page")
    public void theAllowedUserIsInTheWebsiteRegistrationPage() {
        try {
            super.setup();
            user = new User();
        } catch (Exception e){
            Assertions.fail(e.getMessage());
            LOGGER.warn(e.getMessage(), e);
        }
    }
    @When("the user send a registration request with the email {string} and the password {string}")
    public void theUserSendARegistrationRequestWithTheEmailAndThePassword(String email, String password) {
        try {
            user.setEmail(email);
            user.setPassword(password);
            actor.attemptsTo(
                    doPost()
                            .withTheResource(RESOURCE_REGISTER)
                            .andTheBodyRequest(user)
            );
        } catch (Exception e){
            Assertions.fail(e.getMessage());
            LOGGER.warn(e.getMessage(), e);
        }
    }
    @Then("the user sees a success response code and an id with a response token")
    public void theUserSeesASuccessResponseCodeAndAnIdWithAResponseToken() {
        try {
            Response actualResponse = returnRegisterJsonResponse().answeredBy(actor);
            actor.should(
                    seeThatResponse("El código de respuesta es: " + HttpStatus.SC_OK,
                            response -> response.statusCode(HttpStatus.SC_OK)),
                    seeThat("Retorna información",
                            act -> actualResponse, notNullValue())
            );
            actor.should(
                    seeThat("El id generado es 4",
                            act -> actualResponse.getId(), equalTo(4)),
                    seeThat("Se genera un toquen",
                            act -> actualResponse.getToken(), notNullValue())
            );
        } catch (Exception e){
            Assertions.fail(e.getMessage());
            LOGGER.warn(e.getMessage(), e);
        }
    }

    // Second Scenario
    @Given("a not allowed user of the website attempts to register")
    public void aNotAllowedUserOfTheWebsiteAttemptsToRegister() {
        try {
            super.setup();
            user = new User();
        } catch (Exception e){
            Assertions.fail(e.getMessage());
            LOGGER.warn(e.getMessage(), e);
        }
    }
    @When("the user attempt a registration request with the email {string} and the password {string}")
    public void theUserAttemptARegistrationRequestWithTheEmailAndThePassword(String email, String password) {
        try {
            user.setEmail(email);
            user.setPassword(password);
            actor.attemptsTo(
                    doPost()
                            .withTheResource(RESOURCE_REGISTER)
                            .andTheBodyRequest(user)
            );
        } catch (Exception e){
            Assertions.fail(e.getMessage());
            LOGGER.warn(e.getMessage(), e);
        }
    }
    @Then("the user sees a bad request response code and an error message")
    public void theUserSeesABadRequestResponseCodeAndAnErrorMessage() {
        try {
            Response actualResponse = returnRegisterJsonResponse().answeredBy(actor);
            actor.should(
                    seeThatResponse("El código de respuesta es: " + HttpStatus.SC_BAD_REQUEST,
                            response -> response.statusCode(HttpStatus.SC_BAD_REQUEST)),
                    seeThat("Retorna información",
                            act -> actualResponse, notNullValue())
            );
            actor.should(
                    seeThat("Se genera un error",
                            act -> actualResponse.getError(), equalTo(ERROR.getValue()))
            );
        } catch (Exception e){
            Assertions.fail(e.getMessage());
            LOGGER.warn(e.getMessage(), e);
        }
    }
}
