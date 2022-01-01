package co.com.sofka.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class RegisterSuccessfulStepDefinition extends Reqresin{

    private static final Logger LOGGER = Logger.getLogger(RegisterSuccessfulStepDefinition.class);
    private RequestSpecification request;
    private Response response;

    @Given("the user is in the website registration page with the email {string} and the password {string}")
    public void theUserIsInTheWebsiteRegistrationPageWithTheEmailAndThePassword(String email, String password) {
        try {
            generalSetUp();
            request = given().body("{\n" +
                    "    \"email\": \"" + email + "\",\n" +
                    "    \"password\": \"" + password + "\"\n" +
                    "}");
        } catch (Exception e){
            LOGGER.warn(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }
    @When("the user send a registration request")
    public void theUserSendARegistrationRequest() {
        try {
            response = request.post(RESOURCE_REGISTER);
        } catch (Exception e){
            LOGGER.warn(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }
    @Then("the user sees a success response code and an id with a response token")
    public void theUserSeesASuccessResponseCodeAndAnIdWithAResponseToken() {
        try {
            response.then()
                    .statusCode(HttpStatus.SC_OK)
                    .body("id", equalTo(4),
                          "token", notNullValue());
        } catch (Exception e){
            LOGGER.warn(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }
}
