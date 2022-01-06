package co.com.sofka.runners.services.rest.regres;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/services/rest/regres/registerSuccessful.feature"},
        glue = {"co.com.sofka.stepdefinitions.services.rest.regres"}
)
public class RegisterSuccessfulTest {
}
