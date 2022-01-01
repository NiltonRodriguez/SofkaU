package co.com.sofka.util;

public enum MonthSpecs {
    JAN("Enero"),
    JAN_NUM("01"),
    JAN_SHORT("ene"),
    JAN_DAYS("31"),
    FEB("Febrero"),
    FEB_NUM("02"),
    FEB_SHORT("feb"),
    FEB_DAYS("28"),
    FEB_ODD_DAYS("29"),
    MAR("Marzo"),
    MAR_NUM("03"),
    MAR_SHORT("mar"),
    MAR_DAYS("31"),
    APR("Abril"),
    APR_NUM("04"),
    APR_SHORT("abr"),
    APR_DAYS("30"),
    MAY("Mayo"),
    MAY_NUM("05"),
    MAY_SHORT("may"),
    MAY_DAYS("31"),
    JUN("Junio"),
    JUN_NUM("06"),
    JUN_SHORT("jun"),
    JUN_DAYS("30"),
    JUL("Julio"),
    JUL_NUM("07"),
    JUL_SHORT("jul"),
    JUL_DAYS("31"),
    AUG("Agosto"),
    AUG_NUM("08"),
    AUG_SHORT("ago"),
    AUG_DAYS("31"),
    SEP("Septiembre"),
    SEP_NUM("09"),
    SEP_SHORT("sep"),
    SEP_DAYS("30"),
    OCT("Octubre"),
    OCT_NUM("10"),
    OCT_SHORT("oct"),
    OCT_DAYS("31"),
    NOV("Noviembre"),
    NOV_NUM("11"),
    NOV_SHORT("nov"),
    NOV_DAYS("30"),
    DEC("Diciembre"),
    DEC_NUM("12"),
    DEC_SHORT("dec"),
    DEC_DAYS("31");

    private final String value;

    MonthSpecs(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
