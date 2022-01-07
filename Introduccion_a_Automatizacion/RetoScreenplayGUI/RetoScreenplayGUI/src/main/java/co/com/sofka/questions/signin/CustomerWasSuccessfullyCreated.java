package co.com.sofka.questions.signin;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.userinterfaces.signin.SignInPage.CREATE_SUCCESSFUL;

public class CustomerWasSuccessfullyCreated implements Question<Boolean> {

    private String welcomeMessage;

    public CustomerWasSuccessfullyCreated withTheWelcomeMessage(String message){
        this.welcomeMessage = message;
        return this;
    }

    public CustomerWasSuccessfullyCreated is(){
        return this;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return (CREATE_SUCCESSFUL.resolveFor(actor).containsOnlyText(welcomeMessage));
    }

    public static CustomerWasSuccessfullyCreated customerWasSuccessfullyCreated(){
        return new CustomerWasSuccessfullyCreated();
    }
}
