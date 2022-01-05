package co.com.sofka;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.apache.log4j.PropertyConfigurator;

import java.util.HashMap;

import static co.com.sofka.util.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;
import static co.com.sofka.util.Utilities.*;

public class CountryInfoSetup {
    public static final String BASE_URL = "http://webservices.oorsprong.org/";
    public static final String RESOURCE = "websamples.countryinfo/CountryInfoService.wso?wsdl";//op=CapitalCity
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
        headersCollection.put("SOAPAction", "");
        return headersCollection;
    }

    private void setUpLog4j(){
        PropertyConfigurator.configure(osPathModify(defineOS(),getUserDir() + LOG4J_PROPERTIES_FILE_PATH.getValue()));
    }

}
