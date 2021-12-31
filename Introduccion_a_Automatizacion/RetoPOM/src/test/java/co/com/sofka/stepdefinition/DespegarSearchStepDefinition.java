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
    private DespegarSearchModel oneWay;
    private DespegarSearchPage despegarSearchPage;
    private static final String ASSERTION_EXCEPTION_MESSAGE = "Los valores suministrados no son los esperados: %s";

    @Given("a client that wants to make a flying tickets reservation at despegar website")
    public void aClientThatWantsToMakeAFlyingTicketsReservationAtDespegarWebsite() {
        try{
            generalSetup();
        } catch (Exception exception){
            quitDriver();
            LOGGER.warn(exception.getMessage(), exception);
        }
    }

    // First scenario.
    @When("the client fill the search form for a roundtrip flight for three passengers and confirm the action")
    public void theClientFillTheSearchFormForARoundtripFlightForThreeAndConfirmTheAction() {
        try{
            generateRoundtripSearch();
            despegarSearchPage = new DespegarSearchPage(super.driver, 30, roundtrip);
            despegarSearchPage.fillRoundtripSearchFields();
        } catch (Exception exception){
            quitDriver();
            LOGGER.warn(exception.getMessage(), exception);
        }
    }
    @When("the client select the cheapest flight")
    public void theClientSelectTheCheapestFlight() {
        try{
            despegarSearchPage.selectFight();
        } catch (Exception exception){
            quitDriver();
            LOGGER.warn(exception.getMessage(), exception);
        }
    }
    @Then("the client see the information and the full price of the selected flight")
    public void theClientSeeTheInformationAndTheFullPriceOfTheSelectedFlight() {
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

    // Second scenario.
    @When("the client fill the search form for a one way flight for one passenger and confirm the action")
    public void theClientFillTheSearchFormForAOneWayFlightForOnePassengerAndConfirmTheAction() {
        try{
            generateOneWaySearch();
            despegarSearchPage = new DespegarSearchPage(super.driver, 30, oneWay);
            despegarSearchPage.fillOneWaySearchFields();
        } catch (Exception exception){
            quitDriver();
            LOGGER.warn(exception.getMessage(), exception);
        }
    }
    @When("the client select the first flight")
    public void theClientSelectTheFirstFlight() {
        try{
            despegarSearchPage.selectFight();
        } catch (Exception exception){
            quitDriver();
            LOGGER.warn(exception.getMessage(), exception);
        }
    }
    @Then("the client see the information and the price of the selected flight")
    public void theClientSeeTheInformationAndThePriceOfTheSelectedFlight() {
        try{
            Assertions.assertEquals(
                    despegarSearchPage.isOneWaySearchDone(),
                    oneWaySearchSubmitted(),
                    String.format(ASSERTION_EXCEPTION_MESSAGE, outcome(despegarSearchPage.isOneWaySearchDone(),
                            oneWaySearchSubmitted()))
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
        roundtrip.setDestination(" Medellín");
        roundtrip.setDepartureDay("25");
        roundtrip.setMonthInfo(MonthSpecs.FEB, roundtrip.getDepartureMonth());
        roundtrip.setDepartureYear("2022");
        roundtrip.setReturnDay("4");
        roundtrip.setMonthInfo(MonthSpecs.MAR, roundtrip.getReturnMonth());
        roundtrip.setReturnYear("2022");
        roundtrip.setAdults("3");
        roundtrip.setChildren("0");
        roundtrip.setClassType(ClassType.ECONOMICA);
    }

    private List<String> roundtripSearchSubmitted(){
        String depatureEarly = "0" + roundtrip.getDepartureDay() + " " + roundtrip.getDepartureMonth().getMonthShort() +
                " " + roundtrip.getDepartureYear();
        String depatureLate = roundtrip.getDepartureDay() + " " + roundtrip.getDepartureMonth().getMonthShort() +
                " " + roundtrip.getDepartureYear();
        String returnEarly = "0" + roundtrip.getReturnDay() + " " + roundtrip.getReturnMonth().getMonthShort() + " " +
                roundtrip.getReturnYear();
        String returnLate = roundtrip.getReturnDay() + " " + roundtrip.getReturnMonth().getMonthShort() + " " +
                roundtrip.getReturnYear();
        List<String> searchSubmitted = new ArrayList<>();
        searchSubmitted.add(roundtrip.getPrices().get(0));
        searchSubmitted.add(roundtrip.getPrices().get(1));
        searchSubmitted.add(roundtrip.getPrices().get(2));
        searchSubmitted.add(roundtrip.getOrigin().trim() + " - " + roundtrip.getDestination().trim());
        searchSubmitted.add(roundtrip.getJourney().getValue() + ", " + roundtrip.getAdults() + " adultos");
        if(Integer.parseInt(roundtrip.getDepartureDay()) < 10 && Integer.parseInt(roundtrip.getReturnDay()) < 10){
            searchSubmitted.add(depatureEarly);
            searchSubmitted.add(returnEarly);
        } else if (Integer.parseInt(roundtrip.getDepartureDay()) < 10) {
            searchSubmitted.add(depatureEarly);
            searchSubmitted.add(returnLate);
        } else if (Integer.parseInt(roundtrip.getReturnDay()) < 10){
            searchSubmitted.add(depatureLate);
            searchSubmitted.add(returnEarly);
        } else {
            searchSubmitted.add(depatureLate);
            searchSubmitted.add(returnLate);
        }

        return searchSubmitted;
    }

    // Functions for Scenario 2.
    private void generateOneWaySearch(){
        oneWay = new DespegarSearchModel();
        oneWay.setJourney(Journey.IDA);
        oneWay.setOrigin(" Cartagena de Indias");
        oneWay.setDestination(" Bogotá");
        oneWay.setDepartureDay("15");
        oneWay.setMonthInfo(MonthSpecs.MAR, oneWay.getDepartureMonth());
        oneWay.setDepartureYear("2022");
        oneWay.setAdults("1");
        oneWay.setChildren("0");
        oneWay.setClassType(ClassType.ECONOMICA);
    }

    private List<String> oneWaySearchSubmitted(){
        List<String> searchSubmitted = new ArrayList<>();
        searchSubmitted.add(oneWay.getPrices().get(0));
        searchSubmitted.add(oneWay.getPrices().get(1));
        searchSubmitted.add(oneWay.getPrices().get(2));
        searchSubmitted.add(oneWay.getOrigin().trim() + " - " + oneWay.getDestination().trim());
        searchSubmitted.add("Solo " + oneWay.getJourney().getValue().toLowerCase() + ", " + oneWay.getAdults() +
                " adulto");
        if(Integer.parseInt(oneWay.getDepartureDay()) < 10){
            searchSubmitted.add("0" + oneWay.getDepartureDay() + " " + oneWay.getDepartureMonth().getMonthShort() + " " +
                    oneWay.getDepartureYear());
        } else {
            searchSubmitted.add(oneWay.getDepartureDay() + " " + oneWay.getDepartureMonth().getMonthShort() + " " +
                    oneWay.getDepartureYear());
        }
        return searchSubmitted;
    }

    // Function for all scenarios.
    private String outcome(List<String> result, List<String> submitted){
        return "\n" + result.toString() + "\n\r" + submitted.toString();
    }
}
