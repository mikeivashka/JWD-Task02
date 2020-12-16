package by.tc.task01.enumeration;

public enum ApplianceType {
    LAPTOP("Laptop"),
    OVEN("Oven"),
    REFRIGERATOR("Refrigerator"),
    SPEAKERS("Speakers"),
    TABLETPC("TabletPC"),
    VACUUMCLEANER("VacuumCleaner");

    private final String className;

    ApplianceType(String className) {
        this.className = className;
    }

    public String getClassName() {
        return this.className;
    }
}
