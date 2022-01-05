package co.com.sofka.stepdefinitions.services.soap.tempconvert;

import co.com.sofka.TempConvertSetup;
import co.com.sofka.model.Convertion;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;

import static co.com.sofka.questions.ReturnSoapServiceResponse.returnSoapServiceResponse;
import static co.com.sofka.tasks.DoPost.doPost;
import static co.com.sofka.util.FileUtilities.readFile;
import static co.com.sofka.util.service.soap.tempconvert.celsiustofahrenheit.Path.CELSIUSTOFAHRENHEIT;
import static co.com.sofka.util.service.soap.tempconvert.celsiustofahrenheit.Response.CONVERTION_RESPONSE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.containsString;

public class ConvertStepDefinition extends TempConvertSetup {
    private Convertion convertion;

    // First Scenario.
    @Given("a user of the converter that wants to convert {string} Celsius")
    public void aUserOfTheConverterThatWantsToConvertCelsius(String temperature) {
        super.setup();
        convertion = new Convertion();
        convertion.setTemperature(temperature);
    }
    @When("the user executes the converter to Fahrenheit")
    public void theUserExecutesTheConverterToFahrenheit() {
        actor.attemptsTo(
                doPost()
                        .withTheResource(RESOURCE)
                        .andTheHeaders(super.headers())
                        .andTheBodyRequest(bodyRequest())
        );
    }
    @Then("the user obtains the result {string}")
    public void theUserObtainsTheResult(String result) {
        convertion.setResult(result);
        actor.should(
                seeThatResponse("El código de respuesta HTTP debe ser: ",
                        response -> response.statusCode(HttpStatus.SC_OK)),
                seeThat("El resultado de la conversión debe ser: ",
                        returnSoapServiceResponse(),
                        containsString(bodyResponse()))
        );
    }

    // Second Scenario.
    @Given("a user of the converter that set {string} as Celsius")
    public void aUserOfTheConverterThatSetAsCelsius(String wrongTemp) {
        super.setup();
        convertion = new Convertion();
        convertion.setTemperature(wrongTemp);
    }
    @When("the user attempt to convert it to Fahrenheit")
    public void theUserAttemptToConvertItToFahrenheit() {
        actor.attemptsTo(
                doPost()
                        .withTheResource(RESOURCE)
                        .andTheHeaders(super.headers())
                        .andTheBodyRequest(bodyRequest())
        );
    }
    @Then("the user obtains the message {string}")
    public void theUserObtainsTheMessage(String message) {
        convertion.setResult(message);
        actor.should(
                seeThatResponse("El código de respuesta HTTP debe ser: ",
                        response -> response.statusCode(HttpStatus.SC_OK)),
                seeThat("El mensaje de la conversión debe ser: ",
                        returnSoapServiceResponse(),
                        containsString(bodyResponse()))
        );
    }

    private Convertion convertion(){
        return convertion;
    }
    
    private String bodyRequest(){
        return String.format(readFile(CELSIUSTOFAHRENHEIT.getValue()), convertion().getTemperature());
    }

    private String bodyResponse(){
        return String.format(CONVERTION_RESPONSE.getValue(), convertion().getResult());
    }
}
