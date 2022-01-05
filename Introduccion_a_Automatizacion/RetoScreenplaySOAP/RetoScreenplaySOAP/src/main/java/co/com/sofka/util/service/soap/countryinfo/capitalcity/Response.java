package co.com.sofka.util.service.soap.countryinfo.capitalcity;

public enum Response {
    SEARCH_RESPONSE("<m:CapitalCityResult>%s</m:CapitalCityResult>");

    private final String value;

    Response(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
