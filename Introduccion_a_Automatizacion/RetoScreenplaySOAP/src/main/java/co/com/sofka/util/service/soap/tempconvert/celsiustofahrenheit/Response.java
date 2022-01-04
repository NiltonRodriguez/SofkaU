package co.com.sofka.util.service.soap.tempconvert.celsiustofahrenheit;

public enum Response {
    CONVERTION_RESPONSE("<CelsiusToFahrenheitResult>%s</CelsiusToFahrenheitResult>");

    private final String value;

    Response(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
