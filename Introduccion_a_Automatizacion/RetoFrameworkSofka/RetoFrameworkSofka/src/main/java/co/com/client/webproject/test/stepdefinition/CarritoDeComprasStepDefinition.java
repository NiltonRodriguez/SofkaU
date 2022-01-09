package co.com.client.webproject.test.stepdefinition;

import co.com.client.webproject.test.controllers.CreateAnAccountWebController;
import co.com.client.webproject.test.controllers.LoginPageWebController;
import co.com.client.webproject.test.controllers.openwebpage.StartBrowserWebController;
import co.com.client.webproject.test.controllers.shoppingcart.*;
import co.com.client.webproject.test.data.objects.TestInfo;
import co.com.client.webproject.test.models.ProductModel;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Assert;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

import static co.com.client.webproject.test.utils.AlertMessages.EMPTY_CART;
import static co.com.client.webproject.test.utils.Waits.SHORT_WAIT;

public class CarritoDeComprasStepDefinition extends GeneralSetup{

    private WebAction webAction;
    private ProductModel product;

    @Before
    public void setUp(Scenario scenario) {
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
    }

    @Dado("que el cliente ingresa a la página de inicio y se ha logueado de forma exitosa")
    public void queElClienteIngresaALaPaginaDeInicioYSeHaLogueadoDeFormaExitosa() {
        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setFeature(testInfo.getFeatureName());
        startBrowserWebController.abrirTiendaOnline();

        LoginPageWebController loginPageWebController = new LoginPageWebController();
        loginPageWebController.setWebAction(webAction);
        loginPageWebController.irHaciaLoginPage();

        CreateAnAccountWebController createAnAccountWebController = new CreateAnAccountWebController();
        createAnAccountWebController.setWebAction(webAction);
        createAnAccountWebController.crearUnaCuenta();
    }

    // Primer escenario.
    @Cuando("el cliente elige productos que desea comprar y los agrega al carrito")
    public void elClienteEligeProductosQueDeseaComprarYLosAgregaAlCarrito() {
        ProductsPageWebController productWebController = new ProductsPageWebController();
        productWebController.setWebAction(webAction);
        productWebController.irHaciaWomenPage();

        SelectProductWebController selectProductWebController = new SelectProductWebController();
        selectProductWebController.setWebAction(webAction);
        selectProductWebController.seleccionarProducto();
        product = selectProductWebController.getProductModel();
    }
    @Entonces("como resultado el cliente verá los productos almacenados en su carrito.")
    public void comoResultadoElClienteVeraLosProductosAlmacenadosEnSuCarrito() {
        ShoppingCartWebController shoppingCartWebController = new ShoppingCartWebController();
        shoppingCartWebController.setWebAction(webAction);

        Assert.Hard
                .thatString(shoppingCartWebController.obtenerNombreYPrecioEnElCarrito())
                .isEqualTo(String.format("Name: %s. Price: %s", product.getProdName(), product.getProdPrice()));
    }

    // Segundo escenario.
    @Cuando("el cliente agrega productos al carrito pero decide eliminarlos")
    public void elClienteAgregaProductosAlCarritoPeroDecideEliminarlos() {
        ProductsPageWebController productWebController = new ProductsPageWebController();
        productWebController.setWebAction(webAction);
        productWebController.irHaciaWomenPage();

        SelectProductWebController selectProductWebController = new SelectProductWebController();
        selectProductWebController.setWebAction(webAction);
        selectProductWebController.seleccionarProducto();

        ClearShoppingCartController clearShoppingCartController = new ClearShoppingCartController();
        clearShoppingCartController.setWebAction(webAction);
        clearShoppingCartController.limpiarElCarrito();
    }
    @Entonces("como resultado el usuario verá su carrito vacío.")
    public void comoResultadoElUsuarioVeraSuCarritoVacio() {
        EmptyCartWebController emptyCartWebController = new EmptyCartWebController();
        emptyCartWebController.setWebAction(webAction);

        Assert.Hard
                .thatString(emptyCartWebController.obtenerMensajeDeCarritoVacio())
                .isEqualTo(EMPTY_CART.getValue());
    }

    @After
    public void tearDown() {

        if (webAction != null && webAction.getDriver() != null)
            webAction.closeBrowser();

        Report.reportInfo("***** HA FINALIZADO LA PRUEBA******" + "\n"
                .concat(testInfo.getFeatureName())
                .concat("-")
                .concat(testInfo.getScenarioName()));
    }
}
