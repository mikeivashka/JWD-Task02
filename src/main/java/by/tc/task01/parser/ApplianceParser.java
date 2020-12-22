package by.tc.task01.parser;

import by.tc.task01.entity.Appliance;
import by.tc.task01.enumeration.ApplianceType;

public interface ApplianceParser<T> {
    Appliance parse(T source, ApplianceType type);
}
