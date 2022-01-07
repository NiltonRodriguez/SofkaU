package co.com.sofka.utils.contactus;

public enum Subject {
    CUSTOMERSERVICE("Customer Service"),
    WEBMASTER("Webmaster");

    private final String value;

    Subject(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
