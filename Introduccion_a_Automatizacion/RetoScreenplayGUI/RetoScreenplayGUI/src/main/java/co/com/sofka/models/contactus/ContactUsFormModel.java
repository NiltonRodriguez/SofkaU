package co.com.sofka.models.contactus;

import lombok.Data;

@Data
public class ContactUsFormModel {
    private String subject;
    private String email;
    private String reference;
    private String message;
}
