package co.com.sofka.page;

import co.com.sofka.model.ZonaFitFormModel;
import co.com.sofka.page.common.CommonActionsOnPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static co.com.sofka.util.Utilities.getRandomNumber;


public class ZonaFitFormPage extends CommonActionsOnPages {
    private final ZonaFitFormModel zonaFitFormModel;

    // Webelement locators.
    private final By productsMenu = By.xpath("//*[contains(@id, 'mega-menu-item')]/a[text()='Productos']");
    private final By selectFlavor = By.xpath("//*[contains(@id, 'pa_sabor')]/option[2]");
    private final By addToCartButton = By.xpath("//button[text()='Añadir al carrito']");
    @CacheLookup
    @FindBy(xpath = "//*[@id=\"masthead\"]/div/div[4]/ul/li[5]/div/a")
    private WebElement cart;
    @CacheLookup
    @FindBy(xpath = "//a[text()='Vaciar Carrito']")
    private WebElement clearCart;
    @CacheLookup
    @FindBy(xpath = "//p[text()='Tu carrito está vacío.']")
    private WebElement emptyCartMessage;
    @CacheLookup
    @FindBy(xpath = "//*[@id=\"main\"]/div[2]/div/div[2]/div[2]/div/div[1]/div/a")
    private WebElement proceedPurchase;
    @CacheLookup
    @FindBy(id = "billing_myfield12")
    private WebElement idField;
    @CacheLookup
    @FindBy(id = "billing_email")
    private WebElement emailField;
    @CacheLookup
    @FindBy(id = "billing_first_name")
    private WebElement firstNameField;
    @CacheLookup
    @FindBy(id = "billing_last_name")
    private WebElement lastNameField;
    @CacheLookup
    @FindBy(xpath = "//*[@id=\"select2-billing_city-container\"]")
    private WebElement citySelector;
    @CacheLookup
    @FindBy(id = "billing_address_1")
    private WebElement addressField;
    @CacheLookup
    @FindBy(id = "billing_address_2")
    private WebElement compAddressField;
    @CacheLookup
    @FindBy(id = "billing_phone")
    private WebElement phoneField;
    @CacheLookup
    @FindBy(id = "terms")
    private WebElement termsCheck;
    @CacheLookup
    //@FindBy(id = "place_order")
    @FindBy(xpath = "//button[text()='Realizar el pedido']")
    private WebElement orderButton;
    @CacheLookup
    @FindBy(xpath = "//*[@id=\"order_review\"]/table/tfoot/tr[5]/td/strong/span/bdi")
    private WebElement orderTotal;

    // Assertion locators.
    @CacheLookup
    @FindBy(xpath = "//*[@id=\"main\"]/div[2]/div/div/div[2]/div/p/strong")
    private WebElement confirmationMessage;
    @CacheLookup
    @FindBy(xpath = "//*[@id=\"main\"]/div[2]/div/div/div[2]/div/ul/li[3]/strong/span/bdi")
    private WebElement priceConfirmed;

    // Constructor.
    public ZonaFitFormPage(WebDriver driver, int waitTime, ZonaFitFormModel zonaFitFormModel) {
        super(driver, waitTime);
        this.zonaFitFormModel = zonaFitFormModel;
        PageFactory.initElements(driver, this);
    }

    // Locator functions
    public By selectProductLocator(String position){
        switch(position){
            case "7":
                position = "19";
                break;
            case "10":
                position = "20";
                break;
            case "12":
                position = "21";
                break;
            case "13":
                position = "24";
                break;
            case "14":
                position = "25";
                break;
            default:
        }
        return By.xpath(String.format("//*[@id=\"main\"]/div/div[2]/div/div[2]/div[%s]/div/div[2]/div[2]/div[3]/a", position));
    }

    private By stateLocator(String state){
        return By.xpath(String.format("//option[text()='%s']", state));
    }

    private By cityLocator(String city){
        return By.xpath(String.format("//li[contains(text(), '%s')]", city));
    }

    // Run functions.
    public void selectProducts(){
        int amount = 0;
        while(amount < zonaFitFormModel.getProducts()){
            waitClick(productsMenu);
            waitClick(productsMenu);

            By productLocator = selectProductLocator(String.valueOf(getRandomNumber(1, 18)));
            scrollTo(productLocator);
            waitClick(productLocator);

            waitClick(selectFlavor);

            scrollTo(addToCartButton);
            waitClick(addToCartButton);

            amount += 1;
        }
    }
     // First scenario functions
    public void clearTheCart(){
        scrollTo(cart);
        waitClick(cart);

        waitClick(clearCart);
        waitText(emptyCartMessage, "Tu carrito está vacío");
    }

    public String isCartEmpty(){
        return getText(emptyCartMessage);
    }

    // Second scenario functions.
    public void confirmCart(){
        scrollTo(cart);
        waitClick(cart);

        waitClick(proceedPurchase);
    }

    public void fillBillingForm(){
        waitClick(idField);
        typeInto(idField, zonaFitFormModel.getIdNumber());

        scrollTo(emailField);
        click(emailField);
        typeInto(emailField, zonaFitFormModel.getEmail());

        click(firstNameField);
        typeInto(firstNameField, zonaFitFormModel.getFirstName());

        click(lastNameField);
        typeInto(lastNameField, zonaFitFormModel.getLastName());

        waitClick(stateLocator(zonaFitFormModel.getState()));

        waitClick(citySelector);
        waitClick(cityLocator(zonaFitFormModel.getCity()));

        click(addressField);
        typeInto(addressField, zonaFitFormModel.getAddress());

        click(phoneField);
        typeInto(phoneField, zonaFitFormModel.getCellphone());

        zonaFitFormModel.setOrderPrice(getText(orderTotal));

        scrollTo(termsCheck);
        waitSpace(termsCheck);

        waitClick(orderButton);

        waitElement(confirmationMessage);
    }

    public List<String> isBillingFormDone(){
        List<String> submittedFormResult = new ArrayList<>();
        submittedFormResult.add(getText(confirmationMessage));
        submittedFormResult.add(getText(priceConfirmed));
        return submittedFormResult;
    }
}
