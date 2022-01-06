package co.com.sofka.model.register;

public enum ErrorMessage {
    ERROR("Note: Only defined users succeed registration");

    private final String value;

    ErrorMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
