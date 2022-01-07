package co.com.sofka.questions.signin;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.userinterfaces.signin.SignInPage.SIGN_IN_SUCCESSFUL;

public class CustomerSignInSuccessfully implements Question<Boolean> {

    private String customersName;

    public CustomerSignInSuccessfully withCustomersName(String fullName){
        this.customersName = fullName;
        return this;
    }

    public CustomerSignInSuccessfully is(){
        return this;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return (SIGN_IN_SUCCESSFUL.resolveFor(actor).containsOnlyText(customersName));
    }

    public static CustomerSignInSuccessfully customerSignInSuccessfully(){
        return new CustomerSignInSuccessfully();
    }
}
