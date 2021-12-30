package co.com.sofka.util;

public enum Journey {
    IDA_VUELTA("Ida y vuelta"),
    IDA("Ida"),
    MULTIDESTINO("Multidestino");

    private final String value;

    Journey(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
