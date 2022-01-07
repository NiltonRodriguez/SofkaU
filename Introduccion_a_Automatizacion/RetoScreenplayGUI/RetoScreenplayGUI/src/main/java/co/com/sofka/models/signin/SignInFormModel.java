package co.com.sofka.models.signin;

import lombok.Data;

@Data
public class SignInFormModel {
    private String title;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String birthDay;
    private String birthMonth;
    private String birthYear;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String mobilePhone;
    private String addressAlias;
}
