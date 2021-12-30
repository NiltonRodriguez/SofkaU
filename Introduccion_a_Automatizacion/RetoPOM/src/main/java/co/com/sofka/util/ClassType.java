package co.com.sofka.util;

public enum ClassType {
    ECONOMICA("Economica"),
    PREMIUM_ECONOMY("Premium economy"),
    EJECUTIVA("Ejecutiva/Business"),
    PRIMERA_CLASE("Primera Clase");

    private final String value;

    ClassType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
