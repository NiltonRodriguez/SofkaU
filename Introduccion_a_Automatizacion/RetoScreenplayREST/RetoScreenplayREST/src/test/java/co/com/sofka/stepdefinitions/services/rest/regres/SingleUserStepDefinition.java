package co.com.sofka.stepdefinitions.services.rest.regres;

import co.com.sofka.ReqresSetup;
import co.com.sofka.model.singleuser.Data;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static co.com.sofka.question.ReturnUserJsonResponse.returnUserJsonResponse;
import static co.com.sofka.task.GetUser.getUser;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class SingleUserStepDefinition extends ReqresSetup {
    private static final Logger LOGGER = Logger.getLogger(SingleUserStepDefinition.class);
    private String userId;

    @Given("an administrator of the website that wants to list a single user information")
    public void anAdministratorOfTheWebsiteThatWantsToListASingleUserInformation() {
        try {
            super.setup();
        } catch (Exception e){
            Assertions.fail(e.getMessage());
            LOGGER.warn(e.getMessage(), e);
        }
    }
    // First Scenario
    @When("the administrator sends the list request for user {string}")
    public void theAdministratorSendsTheListRequestForUser(String id) {
        try {
            userId = id;
            actor.attemptsTo(
                    getUser()
                            .withTheResource(String.format(RESOURCE_SINGLE_USER, id))
            );
        } catch (Exception e){
            Assertions.fail(e.getMessage());
            LOGGER.warn(e.getMessage(), e);
        }
    }
    @Then("the administrator see a success response code and the user information")
    public void theAdministratorSeeASuccessResponseCodeAndTheUserInformation() {
        try {
            Data userResponse = returnUserJsonResponse().answeredBy(actor).getData();
            actor.should(
                    seeThatResponse("El código de respuesta HTTP debe ser: " + HttpStatus.SC_OK,
                            response -> response.statusCode(HttpStatus.SC_OK)
                    ),
                    seeThat("Recupera la información de un usuario: ",
                            act -> userResponse, notNullValue()
                    )
            );
            actor.should(
                    seeThat("El id de del usuario recuperado es: ",
                            act -> userResponse.getId(), equalTo(Integer.valueOf(userId)))
            );
        } catch (Exception e){
            Assertions.fail(e.getMessage());
            LOGGER.warn(e.getMessage(), e);
        }
    }
    // Second Scenario
    @When("the administrator sends the list request for the non existent user {string}")
    public void theAdministratorSendsTheListRequestForTheNonExistentUser(String id) {
        try {
            actor.attemptsTo(
                    getUser()
                            .withTheResource(String.format(RESOURCE_SINGLE_USER, id))
            );
        } catch (Exception e){
            Assertions.fail(e.getMessage());
            LOGGER.warn(e.getMessage(), e);
        }
    }
    @Then("the administrator see a Not Found response code")
    public void theAdministratorSeeANotFoundResponseCode() {
        try {
            actor.should(
                    seeThatResponse("El código de respuesta HTTP debe ser: " + HttpStatus.SC_NOT_FOUND,
                            response -> response.statusCode(HttpStatus.SC_NOT_FOUND)
                    )
            );
        } catch (Exception e){
            Assertions.fail(e.getMessage());
            LOGGER.warn(e.getMessage(), e);
        }
    }
}
