package co.com.sofka.question;


import co.com.sofka.model.singleuser.User;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;


public class ReturnUserJsonResponse implements Question<User> {
    @Override
    public User answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(User.class);
    }

    public static ReturnUserJsonResponse returnUserJsonResponse(){
        return new ReturnUserJsonResponse();
    }
}
