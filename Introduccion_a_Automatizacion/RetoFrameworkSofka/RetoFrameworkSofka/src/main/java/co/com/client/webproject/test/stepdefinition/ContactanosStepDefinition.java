package co.com.client.webproject.test.stepdefinition;

import co.com.client.webproject.test.controllers.contactus.ConfirmWebController;
import co.com.client.webproject.test.controllers.contactus.ContactUsPageWebController;
import co.com.client.webproject.test.controllers.contactus.ContactUsWebController;
import co.com.client.webproject.test.controllers.openwebpage.StartBrowserWebController;
import co.com.client.webproject.test.data.objects.TestInfo;
import co.com.client.webproject.test.models.ContactUsModel;
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

import static co.com.client.webproject.test.helpers.Dictionary.*;
import static co.com.client.webproject.test.helpers.Helper.generateEmail;
import static co.com.client.webproject.test.utils.AlertMessages.CONTACT_US_SUCCESS;
import static co.com.client.webproject.test.utils.Subject.CUSTOMERSERVICE;
import static co.com.client.webproject.test.utils.Subject.WEBMASTER;
import static co.com.client.webproject.test.utils.Waits.SHORT_WAIT;

public class ContactanosStepDefinition extends GeneralSetup{

    private WebAction webAction;
    private ContactUsModel contactUsModel;

    @Before
    public void setUp(Scenario scenario) {
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
    }

    @Dado("que el cliente se encuentra en la página de inicio")
    public void queElClienteSeEncuentraEnLaPaginaDeInicio() {
        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setFeature(testInfo.getFeatureName());
        startBrowserWebController.abrirTiendaOnline();
    }

    @Cuando("el cliente se ha dirige a la sección contactanos y envía un mensaje al equipo de soporte")
    public void elClienteSeHaDirigeALaSeccionContactanosYEnviaUnMensajeAlEquipoDeSoporte() {
        ContactUsPageWebController contactUsPageWebController = new ContactUsPageWebController();
        contactUsPageWebController.setWebAction(webAction);
        contactUsPageWebController.irHaciaContactUsPage();

        generateContactUsModel(
                CUSTOMERSERVICE.getValue(),
                generateEmail(SPANISH_CODE_LANGUAGE, COUNTRY_CODE, EMAIL_DOMAIN),
                "00001",
                "Aun no recibo mi pedido"
        );

        ContactUsWebController contactUsWebController = new ContactUsWebController();
        contactUsWebController.setWebAction(webAction);
        contactUsWebController.enviarMensajeAContactanos(contactUsModel);
    }

    @Entonces("como resultado el cliente verá un mensaje de éxito.")
    public void comoResultadoElClienteVeraUnMensajeDeExito() {
        ConfirmWebController confirmWebController = new ConfirmWebController();
        confirmWebController.setWebAction(webAction);

        Assert.Hard
                .thatString(confirmWebController.obtenerAlertaExitosa())
                .isEqualTo(CONTACT_US_SUCCESS.getValue());
    }

    // Segundo Escenario.
    @Cuando("el cliente se ha dirige a la sección contactanos y envía un mensaje al Webmaster")
    public void elClienteEnviaUnMensajeAlWebmaster() {
        ContactUsPageWebController contactUsPageWebController = new ContactUsPageWebController();
        contactUsPageWebController.setWebAction(webAction);
        contactUsPageWebController.irHaciaContactUsPage();

        generateContactUsModel(
                WEBMASTER.getValue(),
                generateEmail(SPANISH_CODE_LANGUAGE, COUNTRY_CODE, EMAIL_DOMAIN),
                "00002",
                "Aun no recibí confirmación de mi pedido"
        );

        ContactUsWebController contactUsWebController = new ContactUsWebController();
        contactUsWebController.setWebAction(webAction);
        contactUsWebController.enviarMensajeAContactanos(contactUsModel);
    }
    @Entonces("como resultado el usuario verá un mensaje exitoso.")
    public void comoResultadoElUsuarioVeraUnMensajeExitoso() {
        ConfirmWebController confirmWebController = new ConfirmWebController();
        confirmWebController.setWebAction(webAction);
        String mensaje = CONTACT_US_SUCCESS.getValue();
        Assert.Hard
                .thatString(confirmWebController.obtenerAlertaExitosa())
                .isEqualTo(mensaje);
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

    private void generateContactUsModel(String subject, String email, String reference, String message){
        contactUsModel = new ContactUsModel();
        contactUsModel.setSubject(subject);
        contactUsModel.setEmail(email);
        contactUsModel.setReference(reference);
        contactUsModel.setMessage(message);
    }
}
