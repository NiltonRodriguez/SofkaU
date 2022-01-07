package co.com.sofka.questions.contactus;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.userinterfaces.contactus.ContactUsPage.SUCCESS_ALERT;

public class ContactFormWasSuccessfullySend implements Question<Boolean> {

    private String successMessage;

    public ContactFormWasSuccessfullySend withSuccessMessage(String successMessage){
        this.successMessage = successMessage;
        return this;
    }
    
    public ContactFormWasSuccessfullySend is(){
        return this;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return (SUCCESS_ALERT.resolveFor(actor).containsOnlyText(successMessage));
    }

    public static ContactFormWasSuccessfullySend contactFormWasSuccessfullySend(){
        return new ContactFormWasSuccessfullySend();
    }
}
