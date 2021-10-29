package hw8.enums;

public enum Navigation {
    HOME("Home"),
    CONTACT("Contact form"),
    SERVICE("Service"),
    METALS_COLORS("Metals & Colors");

    String value;

    Navigation(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
