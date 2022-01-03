package co.com.sofka.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ZonaFitFormModel {
    private String idNumber;
    private String email;
    private String firstName;
    private String lastName;
    private String state;
    private String city;
    private String address;
    private String addressDetails;
    private String cellphone;
    private int products;
    private String orderPrice;
}
