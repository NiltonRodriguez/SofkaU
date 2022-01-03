package co.com.sofka.stepdefinition;

import co.com.sofka.model.ZonaFitFormModel;
import co.com.sofka.page.ZonaFitFormPage;
import co.com.sofka.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class ZonaFitFormStepDefinition extends WebUI {
    private static final Logger LOGGER = Logger.getLogger(ZonaFitFormStepDefinition.class);
    private ZonaFitFormModel justAmount;
    private ZonaFitFormModel client;
    private ZonaFitFormPage zonaFitFormPage;
    private static final String ASSERTION_EXCEPTION_MESSAGE = "Los valores suministrados no son los esperados: %s";

    @Given("a client that want to buy in zonafit")
    public void aClientThatWantToBuyInZonafit() {
        try{
            generalSetup();
        } catch (Exception exception){
            quitDriver();
            LOGGER.warn(exception.getMessage(), exception);
        }
    }
    // Scenario 1
    @When("the client select a product")
    public void theClientSelectAProduct() {
        try{
            generateAmount();
            zonaFitFormPage = new ZonaFitFormPage(super.driver, 30, justAmount);
            zonaFitFormPage.selectProducts();
        } catch (Exception exception){
            quitDriver();
            LOGGER.warn(exception.getMessage(), exception);
        }
    }
    @When("the client go to the cart and confirm to clear it")
    public void theClientGoToTheCartAndConfirmToClearIt() {
        try{
            zonaFitFormPage.clearTheCart();
        } catch (Exception exception){
            quitDriver();
            LOGGER.warn(exception.getMessage(), exception);
        }
    }
    @Then("the client see a message with the cart empty")
    public void theClientSeeAMessageWithTheCartEmpty() {
        try{
            String expected = "Tu carrito está vacío.";
            Assertions.assertEquals(
                    zonaFitFormPage.isCartEmpty(),
                    expected,
                    String.format(ASSERTION_EXCEPTION_MESSAGE, outcome(zonaFitFormPage.isCartEmpty(), expected))
            );
        } catch (Exception exception){
            quitDriver();
            LOGGER.warn(exception.getMessage(), exception);
        } finally {
            quitDriver();
        }
    }
    // Scenario 2
    @When("the client select products and confirm the cart")
    public void theClientSelectProductsAndConfirmTheCart() {
        try{
            generateClient();
            zonaFitFormPage = new ZonaFitFormPage(super.driver, 30, client);
            zonaFitFormPage.selectProducts();
            zonaFitFormPage.confirmCart();
        } catch (Exception exception){
            quitDriver();
            LOGGER.warn(exception.getMessage(), exception);
        }
    }
    @When("the client fill the billing form and confirm the purchase")
    public void theClientFillTheBillingFormAndConfirmThePurchase() {
        try{
            zonaFitFormPage.fillBillingForm();
        } catch (Exception exception){
            quitDriver();
            LOGGER.warn(exception.getMessage(), exception);
        }
    }
    @Then("the client see the billing and payment information")
    public void theClientSeeTheBillingAndPaymentInformation() {
        try{
            Assertions.assertEquals(
                    zonaFitFormPage.isBillingFormDone(),
                    clientSubmitted(),
                    String.format(ASSERTION_EXCEPTION_MESSAGE, outcome(zonaFitFormPage.isBillingFormDone(), clientSubmitted()))
            );
        } catch (Exception exception){
            quitDriver();
            LOGGER.warn(exception.getMessage(), exception);
        } /*finally {
            quitDriver();
        }*/
    }

    // Functions for First Scenario
    private void generateAmount(){
        justAmount = new ZonaFitFormModel();
        justAmount.setProducts(1);
    }

    private String outcome(String result, String expected){
        return "\n" + result + "\n\r" + expected;
    }

    // Functions for Second Scenario
    private void generateClient(){
        client = new ZonaFitFormModel();
        client.setIdNumber("1010327861");
        client.setFirstName("Angel");
        client.setLastName("Garcia");
        client.setEmail("agarciac@gmail.com");
        client.setState("Bolívar");
        client.setCity("Cartagena");
        client.setAddress("Cra. 64 # 27-77");
        client.setCellphone("3138327654");
        client.setProducts(2);
    }

    private List<String> clientSubmitted(){
        List<String> clientSubmitted = new ArrayList<>();
        clientSubmitted.add("Gracias. Tu pedido ha sido recibido.");
        clientSubmitted.add(client.getOrderPrice());
        return clientSubmitted;
    }

    private String outcome(List<String> result, List<String> submitted){
        return "\n" + result.toString() + "\n\r" + submitted.toString();
    }


}
