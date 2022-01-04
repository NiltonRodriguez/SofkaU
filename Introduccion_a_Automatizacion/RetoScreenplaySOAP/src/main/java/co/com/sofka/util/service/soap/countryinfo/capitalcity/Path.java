package co.com.sofka.util.service.soap.countryinfo.capitalcity;

import static co.com.sofka.util.Utilities.*;

public enum Path {
    CAPITALCITY(osPathModify(defineOS(),getUserDir() +
            "/src/test/resources/files/services/soap/countryinfo/capitalcity/search.xml"));

    private final String value;

    Path(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
