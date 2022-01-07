package co.com.sofka.utils.contactus;

public enum Success {
    SUCCESS_MESSAGE("Your message has been successfully sent to our team.");

    private final String value;

    Success(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
