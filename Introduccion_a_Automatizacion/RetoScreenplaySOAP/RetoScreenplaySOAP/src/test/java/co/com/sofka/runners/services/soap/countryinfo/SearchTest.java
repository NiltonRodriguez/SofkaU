package co.com.sofka.runners.services.soap.countryinfo;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/services/soap/countryinfo/capitalcity/search.feature"},
        glue = {"co.com.sofka.stepdefinitions.services.soap.countryinfo"}
)
public class SearchTest {
}
