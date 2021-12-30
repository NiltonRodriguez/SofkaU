package co.com.sofka.stepdefinition;

import co.com.sofka.model.DespegarSearchModel;
import co.com.sofka.page.DespegarSearchPage;
import co.com.sofka.setup.WebUI;
import co.com.sofka.util.ClassType;
import co.com.sofka.util.Journey;
import co.com.sofka.util.MonthSpecs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class DespegarSearchStepDefinition extends WebUI {
    private static final Logger LOGGER = Logger.getLogger(DespegarSearchStepDefinition.class);
    private DespegarSearchModel roundtrip;
    private DespegarSearchPage despegarSearchPage;
    private static final String ASSERTION_EXCEPTION_MESSAGE = "Los valores suministrados no son los esperados: %s";

    @Given("a client that wants to make a flying tickets reservation on despegar website")
    public void aClientThatWantsToMakeAFlyingTicketsReservationOnDespegarWebsite() {
        try{
            generalSetup();
        } catch (Exception exception){
            quitDriver();
            LOGGER.warn(exception.getMessage(), exception);
        }
    }

    // First scenario.
    @When("the client fill the search form for a roundtrip flight and confirm the action")
    public void theClientFillTheSearchFormForARoundtripFlightAndConfirmTheAction() {
        try{
            generateRoundtripSearch();
            despegarSearchPage = new DespegarSearchPage(super.driver, 30, roundtrip);
            despegarSearchPage.fillRoundtripSearchFields();
        } catch (Exception exception){
            quitDriver();
            LOGGER.warn(exception.getMessage(), exception);
        }
    }
    /*@When("the client select the cheapest flight")
    public void theClientSelectTheCheapestFlight() {
        try{
            generalSetup();
        } catch (Exception exception){
            quitDriver();
            LOGGER.warn(exception.getMessage(), exception);
        }
    }*/
    @Then("the client see the information and the price of the selected flight")
    public void theClientSeeTheInformationAndThePriceOfTheSelectedFlight() {
        try{
            Assertions.assertEquals(
                despegarSearchPage.isRoundtripSearchDone(),
                roundtripSearchSubmitted(),
                String.format(ASSERTION_EXCEPTION_MESSAGE, outcome(despegarSearchPage.isRoundtripSearchDone(),
                        roundtripSearchSubmitted()))
            );
        } catch (Exception exception){
            quitDriver();
            LOGGER.warn(exception.getMessage(), exception);
        } finally {
            quitDriver();
        }
    }

    // Functions for Scenario 1
    private void generateRoundtripSearch(){
        roundtrip = new DespegarSearchModel();
        roundtrip.setJourney(Journey.IDA_VUELTA);
        roundtrip.setOrigin(" Bogotá");
        roundtrip.setDestination("Medellín");
        roundtrip.setDepartureDay("6");
        roundtrip.setMonthInfo(MonthSpecs.FEB, roundtrip.getDepartureMonth());
        roundtrip.setDepartureYear("2022");
        roundtrip.setReturnDay("10");
        roundtrip.setMonthInfo(MonthSpecs.FEB, roundtrip.getReturnMonth());
        roundtrip.setReturnYear("2022");
        roundtrip.setAdults("3");
        roundtrip.setChildren("0");
        roundtrip.setClassType(ClassType.PREMIUM_ECONOMY);
    }

    private List<String> roundtripSearchSubmitted(){
        List<String> searchSubmitted = new ArrayList<>();
        return searchSubmitted;
    }

    // Function for all scenarios.
    private String outcome(List<String> result, List<String> submitted){
        return "\n" + result.toString() + "\n\r" + submitted.toString();
    }
}
