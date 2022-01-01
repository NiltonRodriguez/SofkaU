package co.com.sofka.page;

import co.com.sofka.model.DespegarSearchModel;
import co.com.sofka.page.common.CommonActionsOnPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class DespegarSearchPage extends CommonActionsOnPages {
    private final DespegarSearchModel despegarSearchModel;
    // Webelements locators.
    private final By loginAlertClose = By.xpath("//*[@id=\"incentive-login\"]/i[2]");
    private final By roundTrip = By.xpath("//label[@for='rt-sbox5']");
    private final By oneWay = By.xpath("//label[@for='ow-sbox5']");
    private final By multyCity = By.xpath("//label[@for='ms-sbox5']");
    private final By origin = By.xpath("//*[@id=\"searchbox-sbox-box-flights\"]/div/div[2]/div[1]/div[1]/div[1]/div" +
            "/div[1]/div[1]/div/input");
    private final By originList = By.xpath("/html/body/div[4]/div/div[1]/ul/li[1]/span");
    private final By destination = By.xpath("//*[@id=\"searchbox-sbox-box-flights\"]/div/div[2]/div[1]/div[1]/div[1]" +
            "/div/div[2]/div/div/input");
    private final By destinationList = By.xpath("/html/body/div[4]/div/div[1]/ul/li[1]/span");
    private final By startDate = By.xpath("//*[@id=\"searchbox-sbox-box-flights\"]/div/div[2]/div[1]/div[1]/div[2]" +
            "/div/div[1]/div/div/div/div/input");
    private final By displayedMonth = By.xpath("//*[@id=\"component-modals\"]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]");
    private final By rightArrow = By.xpath("//*[@id=\"component-modals\"]/div[1]/div[1]/div[2]/a[2]");
    private final By dateApplyButton = By.xpath("//*[@id=\"component-modals\"]/div[1]/div[2]/div[1]/button");
    private final By passengers = By.xpath("//*[@id=\"searchbox-sbox-box-flights\"]/div/div[2]/div[1]/div[1]/div[4]" +
            "/div/div/div/div/input");
    private final By addAdult = By.xpath("//*[@id=\"component-modals\"]/div[3]/div/div/div[1]/div[1]/div[2]/div/button[2]");
    private final By addChild = By.xpath("//*[@id=\"component-modals\"]/div[3]/div/div/div[1]/div[2]/div[2]/div/button[2]");
    private final By passengersApplyButton = By.xpath("//a[@class='sbox5-3-btn -md -primary']");
    private final By submit = By.xpath("//button[@class='sbox5-box-button-ovr--3LK5x sbox5-3-btn -secondary -icon -lg']");
    private final By pricePerAdult = By.xpath("//*[@id=\"clusters\"]/span[1]/div/span/cluster/div/div/div[2]/fare/" +
            "span/span/main-fare/span/span[1]/span/p");
    private final By currentPrice = By.xpath("//*[@id=\"clusters\"]/span[1]/div/span/cluster/div/div/div[2]/fare/span" +
            "/span/fare-details-items/div/span/item-fare[1]/p/span/flights-price/span/flights-price-element/span/span/em/span[2]");
    private final By currentTaxes = By.xpath("//*[@id=\"clusters\"]/span[1]/div/span/cluster/div/div/div[2]/fare/span/" +
            "span/fare-details-items/div/span/item-fare[2]/p/span/flights-price/span/flights-price-element/span/span/em/span[2]");
    private final By totalPrice = By.xpath("//*[@id=\"clusters\"]/span[1]/div/span/cluster/div/div/div[2]/fare/span/" +
            "span/fare-details-items/div/item-fare/p/span/flights-price/span/flights-price-element/span/span/em/span[2]");
    private final By buyButton = By.xpath("//*[@id=\"clusters\"]/span[1]/div/span/cluster/div/div/div[2]/fare/span/span/" +
            "div[2]/buy-button/a");
    private final By baggageMessage = By.xpath("//*[@id=\"upselling-popup-position\"]/upselling-popup/div/div[2]/h3");
    private final By continueButton = By.xpath("//button[@class='eva-3-btn pricebox-sticky-button -lg -primary']");
    private final By paymentDetail = By.xpath("//p[@class='chk-pricebox-title-text']");
    // Assertion locators.
    private static final String BASE_XPATH = "//*[@id=\"checkout-content\"]/div[2]/div/purchase-detail-component/div/" +
            "products-detail-component-v2/div/";
    private final By assertionPrice = By.xpath("//*[@id=\"pricebox-list-detail\"]/ul/div[1]/div[2]/money/div/span[3]");
    private final By assertionTax = By.xpath("//*[@id=\"pricebox-list-detail\"]/ul/div[2]/div[2]/money/div/span[3]");
    private final By assertionTotal = By.xpath("//*[@id=\"chk-total-price\"]/div[2]/money/div/span[3]");
    private final By assertionOriginDestination = By.xpath(BASE_XPATH + "div/product-title-v2/div/div[2]/div");
    private final By assertionJourneyPassengers = By.xpath(BASE_XPATH + "div/product-description-v2/div/div/span");
    private final By assertionStartDate = By.xpath(BASE_XPATH + "div/flight-info-v2/div[1]/product-dates-v2/div/div/div[2]");
    private final By assertionOneWayDate = By.xpath(BASE_XPATH + "div/flight-info-v2/div/product-dates-v2/div/div/div[2]");
    private final By assertionReturnDate = By.xpath(BASE_XPATH + "div/flight-info-v2/div[2]/product-dates-v2/div/div/div[2]");

    // Constructor
    public DespegarSearchPage(WebDriver driver, int waitTime, DespegarSearchModel despegarSearchModel) {
        super(driver, waitTime);
        this.despegarSearchModel = despegarSearchModel;
    }

    // Locator functions.
    private By classSelectionLocator(String classSelection){
        return By.xpath(String.format("//select[@class=\"select-tag\"]/option[text()=\"%s\"]", classSelection));
    }

    private By flightDateLocator(String year, String monthNumber, String monthDays, String day){
        return By.xpath(String.format("//div[@id='component-modals']//div[@data-month='%s-%s' and @class='sbox5-" +
                "monthgrid']//div[@class='sbox5-monthgrid-dates sbox5-monthgrid-dates-%s']//div[@class='sbox5-" +
                "monthgrid-datenumber-number' and text()='%s']", year, monthNumber, monthDays, day));
    }

    private boolean matchMonth(By locator, String month){
        String currentMonth = getText(locator);
        return !month.equals(currentMonth);
    }

    // Functions first scenario
    public void fillRoundtripSearchFields(){

        waitClick(loginAlertClose);

        switch (despegarSearchModel.getJourney().getValue()) {
            case "Ida y vuelta":
                click(roundTrip);
                break;
            case "Ida":
                click(oneWay);
                break;
            case "Multidestino":
                click(multyCity);
                break;
            default:
        }

        click(origin);
        clearText(origin);
        typeInto(origin, despegarSearchModel.getOrigin());
        waitClick(originList);

        waitClick(destination);
        pressEnter(destination);
        typeInto(destination, despegarSearchModel.getDestination());
        pressRightArrow(destination);
        typeInto(destination, " ");
        waitClick(destinationList);

        scrollTo(startDate);
        click(startDate);
        while(matchMonth(displayedMonth, despegarSearchModel.getDepartureMonth().getMonth())){
            waitClick(rightArrow);
        }

        click(flightDateLocator(despegarSearchModel.getDepartureYear(),
                despegarSearchModel.getDepartureMonth().getMonthNumber(),
                despegarSearchModel.getDepartureMonth().getMonthDays(),
                despegarSearchModel.getDepartureDay()));

        click(flightDateLocator(despegarSearchModel.getReturnYear(),
                despegarSearchModel.getReturnMonth().getMonthNumber(),
                despegarSearchModel.getReturnMonth().getMonthDays(),
                despegarSearchModel.getReturnDay()));

        waitClick(dateApplyButton);

        waitClick(passengers);

        int currentAdults = 1;
        int currentChildren = 0;
        while(currentAdults < Integer.parseInt(despegarSearchModel.getAdults())){
            waitClick(addAdult);
            currentAdults += 1;
        }

        while(currentChildren < Integer.parseInt(despegarSearchModel.getChildren())){
            waitClick(addChild);
            currentChildren += 1;
        }

        waitClick(classSelectionLocator(despegarSearchModel.getClassType().getValue()));

        waitClick(passengersApplyButton);

        waitClick(submit);
    }

    public List<String> isRoundtripSearchDone(){
        List<String> submittedSearchResult = new ArrayList<>();
        submittedSearchResult.add(getText(assertionPrice));
        submittedSearchResult.add(getText(assertionTax));
        submittedSearchResult.add(getText(assertionTotal));
        submittedSearchResult.add(getText(assertionOriginDestination));
        submittedSearchResult.add(getText(assertionJourneyPassengers));
        submittedSearchResult.add(getText(assertionStartDate));
        submittedSearchResult.add(getText(assertionReturnDate));
        return submittedSearchResult;
    }

    // Functions second scenario.
    public void fillOneWaySearchFields(){

        waitClick(loginAlertClose);

        switch (despegarSearchModel.getJourney().getValue()) {
            case "Ida y vuelta":
                click(roundTrip);
                break;
            case "Ida":
                click(oneWay);
                break;
            case "Multidestino":
                click(multyCity);
                break;
            default:
        }

        click(origin);
        clearText(origin);
        typeInto(origin, despegarSearchModel.getOrigin());
        waitClick(originList);

        waitClick(destination);
        pressEnter(destination);
        typeInto(destination, despegarSearchModel.getDestination());
        pressRightArrow(destination);
        typeInto(destination, " ");
        waitClick(destinationList);

        scrollTo(startDate);
        click(startDate);
        while(matchMonth(displayedMonth, despegarSearchModel.getDepartureMonth().getMonth())){
            waitClick(rightArrow);
        }

        click(flightDateLocator(despegarSearchModel.getDepartureYear(),
                despegarSearchModel.getDepartureMonth().getMonthNumber(),
                despegarSearchModel.getDepartureMonth().getMonthDays(),
                despegarSearchModel.getDepartureDay()));

        waitClick(passengers);

        int currentAdults = 1;
        int currentChildren = 0;
        while(currentAdults < Integer.parseInt(despegarSearchModel.getAdults())){
            waitClick(addAdult);
            currentAdults += 1;
        }

        while(currentChildren < Integer.parseInt(despegarSearchModel.getChildren())){
            waitClick(addChild);
            currentChildren += 1;
        }

        waitClick(classSelectionLocator(despegarSearchModel.getClassType().getValue()));

        waitClick(passengersApplyButton);

        waitClick(submit);
    }

    public List<String> isOneWaySearchDone(){
        List<String> submittedSearchResult = new ArrayList<>();
        submittedSearchResult.add(getText(assertionPrice));
        submittedSearchResult.add(getText(assertionTax));
        submittedSearchResult.add(getText(assertionTotal));
        submittedSearchResult.add(getText(assertionOriginDestination));
        submittedSearchResult.add(getText(assertionJourneyPassengers));
        submittedSearchResult.add(getText(assertionOneWayDate));

        return submittedSearchResult;
    }

    // Functions all scenarios.
    public void selectFight(){
        waitText(pricePerAdult, "Precio por adulto");
        scrollTo(pricePerAdult);
        returnCurrentPrices();
        waitClick(buyButton);
        waitText(baggageMessage, "Suma equipaje y lleva lo que necesites");
        waitClick(continueButton);
        waitText(paymentDetail, "Detalle del pago");
    }

    public void returnCurrentPrices(){
        List<String> prices = new ArrayList<>();
        prices.add(getText(currentPrice));
        prices.add(getText(currentTaxes));
        prices.add(getText(totalPrice));
        despegarSearchModel.setPrices(prices);
    }
}
