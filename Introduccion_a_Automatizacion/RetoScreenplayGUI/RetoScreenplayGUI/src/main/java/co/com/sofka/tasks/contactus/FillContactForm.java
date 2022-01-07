package co.com.sofka.tasks.contactus;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.conditions.Check;

import static co.com.sofka.userinterfaces.contactus.ContactUsPage.*;
import static co.com.sofka.utils.contactus.Subject.CUSTOMERSERVICE;

public class FillContactForm implements Task {

    private String subject;
    private String email;
    private String reference;
    private String message;

    public FillContactForm withSubject(String subject){
        this.subject = subject;
        return this;
    }

    public FillContactForm andTheEmail(String email){
        this.email = email;
        return this;
    }

    public FillContactForm andTheReference(String reference){
        this.reference = reference;
        return this;
    }

    public FillContactForm andTheMessage(String message){
        this.message = message;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Check.whether(subject.equals(CUSTOMERSERVICE.getValue()))
                        .andIfSo(
                                Scroll.to(CUSTOMER_SERVICE_OPTION),
                                Click.on(CUSTOMER_SERVICE_OPTION)
                        )
                        .otherwise(
                                Scroll.to(WEBMASTER_OPTION),
                                Click.on(WEBMASTER_OPTION)
                        ),

                Scroll.to(EMAIL_FIELD),
                Enter.theValue(email).into(EMAIL_FIELD),

                Scroll.to(ORDER_FIELD),
                Enter.theValue(reference).into(ORDER_FIELD),

                Scroll.to(MESSAGE_FIELD),
                Enter.theValue(message).into(MESSAGE_FIELD),

                Scroll.to(SUBMIT_MESSAGE_BUTTON),
                Click.on(SUBMIT_MESSAGE_BUTTON)
        );
    }

    public static FillContactForm fillContactForm(){
        return new FillContactForm();
    }
}
