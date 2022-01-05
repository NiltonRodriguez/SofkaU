package co.com.sofka.runners.services.soap.tempconvert;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/services/soap/tempconvert/celsiustofahrenheit/convert.feature"},
        glue = {"co.com.sofka.stepdefinitions.services.soap.tempconvert"}
)
public class ConvertTest {

}
