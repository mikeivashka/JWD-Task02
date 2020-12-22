package by.tc.task01.main;

import by.tc.task01.entity.Appliance;
import lombok.extern.java.Log;

@Log
public class PrintApplianceInfo {

    private PrintApplianceInfo() {}

    public static void print(Appliance appliance) {
        log.info(appliance.toString());
    }
}
