package co.com.sofka.stepdefinitions.services.soap.countryinfo;

import co.com.sofka.CountryInfoSetup;
import co.com.sofka.model.Capital;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;

import static co.com.sofka.questions.ReturnSoapServiceResponse.returnSoapServiceResponse;
import static co.com.sofka.tasks.DoPost.doPost;
import static co.com.sofka.util.FileUtilities.readFile;
import static co.com.sofka.util.service.soap.countryinfo.capitalcity.Path.CAPITALCITY;
import static co.com.sofka.util.service.soap.countryinfo.capitalcity.Response.SEARCH_RESPONSE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.containsString;

public class SearchCapitalStepDefinition extends CountryInfoSetup {
    private Capital capitalCity;

    // Background.
    @Given("a user that wants to know the capital city of a country")
    public void aUserThatWantsToKnowTheCapitalCityOfACountry() {
        super.setup();
        capitalCity = new Capital();
    }

    // First Scenario.
    @When("the user send the ISO code of Colombia {string}")
    public void theUserSendTheISOCodeOfColombia(String isoCode) {
        capitalCity.setIsoCode(isoCode);
        actor.attemptsTo(
                doPost()
                        .withTheResource(RESOURCE)
                        .andTheHeaders(super.headers())
                        .andTheBodyRequest(bodyRequest())
        );
    }
    @Then("the user obtains the capital city {string}")
    public void theUserObtainsTheCapitalCity(String capital) {
        capitalCity.setCapitalCity(capital);
        actor.should(
                seeThatResponse("El código de respuesta HTTP debe ser: ",
                        response -> response.statusCode(HttpStatus.SC_OK)),
                seeThat("El resultado de la consulta debe ser: ",
                        returnSoapServiceResponse(),
                        containsString(bodyResponse()))
        );
    }

    // Second Scenario.
    @When("the user send the ISO code {string} that doesn't exists")
    public void theUserSendTheISOCodeThatDoesntExists(String isoCode) {
        capitalCity.setIsoCode(isoCode);
        actor.attemptsTo(
                doPost()
                        .withTheResource(RESOURCE)
                        .andTheHeaders(super.headers())
                        .andTheBodyRequest(bodyRequest())
        );
    }
    @Then("the user obtains the the message {string}")
    public void theUserObtainsTheTheMessage(String message) {
        capitalCity.setCapitalCity(message);
        actor.should(
                seeThatResponse("El código de respuesta HTTP debe ser: ",
                        response -> response.statusCode(HttpStatus.SC_OK)),
                seeThat("El resultado de la consulta debe ser: ",
                        returnSoapServiceResponse(),
                        containsString(bodyResponse()))
        );
    }

    private Capital capitalCity(){
        return capitalCity;
    }

    private String bodyRequest(){
        return String.format(readFile(CAPITALCITY.getValue()), capitalCity().getIsoCode());
    }

    private String bodyResponse(){
        return String.format(SEARCH_RESPONSE.getValue(), capitalCity().getCapitalCity());
    }
}
