package co.com.sofka.tasks.signin;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.sofka.userinterfaces.signin.SignInPage.*;

public class FillSignInForm implements Task {

    private String email;
    private String password;

    public FillSignInForm withTheEmail(String email){
        this.email = email;
        return this;
    }

    public FillSignInForm andThePassword(String password){
        this.password = password;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(SIGN_IN_EMAIL),
                Enter.theValue(email).into(SIGN_IN_EMAIL),

                Scroll.to(SIGN_IN_PASSWORD),
                Enter.theValue(password).into(SIGN_IN_PASSWORD),

                Scroll.to(SIGN_IN_BUTTON),
                Click.on(SIGN_IN_BUTTON)
        );
    }

    public static FillSignInForm fillSignInForm(){
        return new FillSignInForm();
    }
}
