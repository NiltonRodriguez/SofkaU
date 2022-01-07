package co.com.sofka.tasks.signin;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.conditions.Check;

import static co.com.sofka.userinterfaces.signin.SignInPage.*;
import static co.com.sofka.utils.signin.Title.MR;

public class FillCreateAccountForm implements Task {

    private String title;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;
    private String city;
    private String zipCode;
    private String mobilePhone;
    private String addressAlias;

    public FillCreateAccountForm withTheEmail(String email){
        this.email = email;
        return this;
    }

    public FillCreateAccountForm andTheTitle(String title){
        this.title = title;
        return this;
    }

    public FillCreateAccountForm andTheFirstName(String firstName){
        this.firstName = firstName;
        return this;
    }

    public FillCreateAccountForm andTheLastName(String lastName){
        this.lastName = lastName;
        return this;
    }

    public FillCreateAccountForm andThePassword(String password){
        this.password = password;
        return this;
    }

    public FillCreateAccountForm andTheAddress(String address){
        this.address = address;
        return this;
    }

    public FillCreateAccountForm andTheCity(String city){
        this.city = city;
        return this;
    }

    public FillCreateAccountForm andTheZipCode(String zipCode){
        this.zipCode = zipCode;
        return this;
    }

    public FillCreateAccountForm andTheMobilePhone(String mobile){
        this.mobilePhone = mobile;
        return this;
    }

    public FillCreateAccountForm andFinallyTheAlias(String alias){
        this.addressAlias = alias;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(CREATE_EMAIL),
                Enter.theValue(email).into(CREATE_EMAIL),

                Scroll.to(CREATE_ACCOUNT_BUTTON),
                Click.on(CREATE_ACCOUNT_BUTTON),

                Check.whether(title.equals(MR.getValue()))
                                .andIfSo(
                                        Scroll.to(CREATE_TITLE_MR),
                                        Click.on(CREATE_TITLE_MR)
                                )
                                .otherwise(
                                        Scroll.to(CREATE_TITLE_MRS),
                                        Click.on(CREATE_TITLE_MRS)
                                ),

                Scroll.to(CREATE_FIRST_NAME),
                Enter.theValue(firstName).into(CREATE_FIRST_NAME),

                Scroll.to(CREATE_LAST_NAME),
                Enter.theValue(lastName).into(CREATE_LAST_NAME),

                Scroll.to(CREATE_PASSWORD),
                Enter.theValue(password).into(CREATE_PASSWORD),

                Scroll.to(CREATE_ADDRESS),
                Enter.theValue(address).into(CREATE_ADDRESS),

                Scroll.to(CREATE_CITY),
                Enter.theValue(city).into(CREATE_CITY),

                Scroll.to(CREATE_STATE),
                Click.on(CREATE_STATE),

                Scroll.to(CREATE_ZIP_CODE),
                Enter.theValue(zipCode).into(CREATE_ZIP_CODE),

                Scroll.to(CREATE_MOBILE_PHONE),
                Enter.theValue(mobilePhone).into(CREATE_MOBILE_PHONE),

                Scroll.to(CREATE_ADDRESS_ALIAS),
                Enter.theValue(addressAlias).into(CREATE_ADDRESS_ALIAS),

                Scroll.to(CREATE_SUBMIT_BUTTON),
                Click.on(CREATE_SUBMIT_BUTTON)
        );
    }

    public static FillCreateAccountForm fillCreateAccountForm(){
        return new FillCreateAccountForm();
    }
}
