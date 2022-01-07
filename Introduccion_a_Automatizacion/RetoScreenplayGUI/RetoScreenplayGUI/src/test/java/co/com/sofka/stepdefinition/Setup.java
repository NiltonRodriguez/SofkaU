package co.com.sofka.stepdefinition;

import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import static co.com.sofka.utils.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;
import static co.com.sofka.utils.Utilities.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class Setup {
    @Managed()
    protected WebDriver webdriver;

    private void setupUser(String name, WebDriver webdriver){
        OnStage.setTheStage(new OnlineCast());
        theActorCalled(name).can(BrowseTheWeb.with(webdriver));
    }

    protected void actorSetUpTheBrowser(String name){
        setUpLog4j();
        setupUser(name, webdriver);
    }

    private void setUpLog4j(){
        PropertyConfigurator.configure(osPathModify(defineOS(),getUserDir() + LOG4J_PROPERTIES_FILE_PATH.getValue()));
    }
}
