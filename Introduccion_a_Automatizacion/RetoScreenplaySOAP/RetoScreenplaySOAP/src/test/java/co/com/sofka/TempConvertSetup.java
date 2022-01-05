package co.com.sofka;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.apache.log4j.PropertyConfigurator;

import java.util.HashMap;

import static co.com.sofka.util.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;
import static co.com.sofka.util.Utilities.*;

public class TempConvertSetup {
    public static final String BASE_URL = "https://www.w3schools.com/";
    public static final String RESOURCE = "xml/tempconvert.asmx?wsdl";//?op=CelsiusToFahrenheit
    protected final Actor actor = new Actor("Iván");

    protected void setup(){
        setUpLog4j();
        actorCan();
    }

    private void actorCan(){
        actor.can(CallAnApi.at(BASE_URL));
    }

    protected HashMap<String, Object> headers(){
        HashMap<String, Object> headersCollection = new HashMap<>();
        headersCollection.put("Content-Type", "text/xml;charset=UTF-8");
        headersCollection.put("SOAPAction", "https://www.w3schools.com/xml/CelsiusToFahrenheit");
        return headersCollection;
    }

    private void setUpLog4j(){
        PropertyConfigurator.configure(osPathModify(defineOS(),getUserDir() + LOG4J_PROPERTIES_FILE_PATH.getValue()));
    }

}
