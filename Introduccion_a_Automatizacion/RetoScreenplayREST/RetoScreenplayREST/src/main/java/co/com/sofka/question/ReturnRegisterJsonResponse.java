package co.com.sofka.question;

import co.com.sofka.model.register.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ReturnRegisterJsonResponse implements Question<Response> {

    @Override
    public Response answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(Response.class);
    }

    public static ReturnRegisterJsonResponse returnRegisterJsonResponse(){
        return new ReturnRegisterJsonResponse();
    }
}
