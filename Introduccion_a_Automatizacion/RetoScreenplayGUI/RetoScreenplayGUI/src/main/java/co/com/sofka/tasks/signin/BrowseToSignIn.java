package co.com.sofka.tasks.signin;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.sofka.userinterfaces.signin.SignInPage.SIGN_IN;

public class BrowseToSignIn implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(SIGN_IN),
                Click.on(SIGN_IN)
        );
    }

    public static BrowseToSignIn browseToSignIn(){
        return new BrowseToSignIn();
    }
}
