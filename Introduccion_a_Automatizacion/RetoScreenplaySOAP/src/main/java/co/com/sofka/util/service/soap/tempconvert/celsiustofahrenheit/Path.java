package co.com.sofka.util.service.soap.tempconvert.celsiustofahrenheit;

import static co.com.sofka.util.Utilities.*;

public enum Path {
    CELSIUSTOFAHRENHEIT(osPathModify(defineOS(),getUserDir() +
            "/src/test/resources/files/services/soap/tempconvert/celsiustofahrenheit/convertion.xml"));

    private final String value;

    Path(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
