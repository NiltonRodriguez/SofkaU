package co.com.sofka.page;

import co.com.sofka.model.DespegarSearchModel;
import co.com.sofka.page.common.CommonActionsOnPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class DespegarSearchPage extends CommonActionsOnPages {
    private final DespegarSearchModel despegarSearchModel;

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
    private final By returnDate = By.xpath("//*[@id=\"searchbox-sbox-box-flights\"]/div/div[2]/div[1]/div[1]/div[2]" +
            "/div/div[2]/div/div/div/div/input");
    private final By displayedMonth = By.xpath("//*[@id=\"component-modals\"]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]");
    private final By leftArrow = By.xpath("//*[@id=\"component-modals\"]/div[1]/div[1]/div[2]/a[1]");
    private final By rightArrow = By.xpath("//*[@id=\"component-modals\"]/div[1]/div[1]/div[2]/a[2]");
    private final By dateApplyButton = By.xpath("//*[@id=\"component-modals\"]/div[1]/div[2]/div[1]/button");
    private final By passengers = By.xpath("//*[@id=\"searchbox-sbox-box-flights\"]/div/div[2]/div[1]/div[1]/div[4]" +
            "/div/div/div/div/input");
    private final By addAdult = By.xpath("//*[@id=\"component-modals\"]/div[3]/div/div/div[1]/div[1]/div[2]/div/button[2]");
    private final By addChild = By.xpath("//*[@id=\"component-modals\"]/div[3]/div/div/div[1]/div[2]/div[2]/div/button[2]");
    private final By passengersApplyButton = By.xpath("//a[@class='sbox5-3-btn -md -primary']");
    private final By submit = By.xpath("//button[@class='sbox5-box-button-ovr--3LK5x sbox5-3-btn -secondary -icon -lg']");

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

    private boolean monthMatch(By locator, String month){
        String currentMonth = getText(locator);
        return month.equals(currentMonth);
    }

    // Functions first scenario
    public void fillRoundtripSearchFields(){

        waitClick(loginAlertClose);

        if(despegarSearchModel.getJourney().getValue().equals("Ida y vuelta")){
            click(roundTrip);
        } else if(despegarSearchModel.getJourney().getValue().equals("Ida")){
            click(oneWay);
        } else if(despegarSearchModel.getJourney().getValue().equals("Multidestino")){
            click(multyCity);
        }

        click(origin);
        clearText(origin);
        typeInto(origin, despegarSearchModel.getOrigin());
        waitClick(originList);

        waitClick(destination);
        typeInto(destination, despegarSearchModel.getDestination());
        waitClick(destination);
        pressEnter(destination);
        typeInto(destination, " ");
        waitClick(destinationList);

        click(startDate);
        while(!monthMatch(displayedMonth, despegarSearchModel.getDepartureMonth().getMonth())){
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

        return submittedSearchResult;
    }

    // Functions second scenario
}
