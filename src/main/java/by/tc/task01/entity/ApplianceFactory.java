package by.tc.task01.entity;

import by.tc.task01.enumeration.ApplianceType;
import by.tc.task01.enumeration.OperatingSystem;

import java.util.Map;

public class ApplianceFactory {
    private ApplianceFactory() {
    }

    public static Appliance getAppliance(ApplianceType applianceType, Map<String, Object> params) {
        switch (applianceType) {
            case LAPTOP:
                return new Laptop.LaptopBuilder()
                        .batteryCapacity(Double.parseDouble((String) params.get("BATTERY_CAPACITY")))
                        .cpu(Double.parseDouble((String) params.get("CPU")))
                        .displayInches(Integer.parseInt((String) params.get("DISPLAY_INCHES")))
                        .memoryRom(Integer.parseInt((String) params.get("MEMORY_ROM")))
                        .operatingSystem(OperatingSystem.valueOf(params.get("OS").toString().toUpperCase()))
                        .systemMemory(Integer.parseInt((String) params.get("SYSTEM_MEMORY")))
                        .build();
            case TABLETPC:
                return new TabletPC.TabletPCBuilder()
                        .batteryCapacity(Double.parseDouble((String) params.get("BATTERY_CAPACITY")))
                        .memoryRom(Integer.parseInt((String) params.get("MEMORY_ROM")))
                        .displayInches(Integer.parseInt((String) params.get("DISPLAY_INCHES")))
                        .color((String) params.get("COLOR"))
                        .flashMemoryCapacity(Double.parseDouble((String) params.get("FLASH_MEMORY_CAPACITY")))
                        .build();
            case OVEN:
                return new Oven.OvenBuilder()
                        .powerConsumption(Integer.parseInt((String) params.get("POWER_CONSUMPTION")))
                        .capacity(Integer.parseInt((String) params.get("CAPACITY")))
                        .depth(Integer.parseInt((String) params.get("DEPTH")))
                        .height(Double.parseDouble((String) params.get("HEIGHT")))
                        .weight(Integer.parseInt((String) params.get("WEIGHT")))
                        .width(Double.parseDouble((String) params.get("WIDTH")))
                        .build();
            case REFRIGERATOR:
                return new Refrigerator.RefrigeratorBuilder()
                        .powerConsumption(Integer.parseInt((String) params.get("POWER_CONSUMPTION")))
                        .height(Double.parseDouble((String) params.get("HEIGHT")))
                        .weight(Double.parseDouble((String) params.get("WEIGHT")))
                        .width(Double.parseDouble((String) params.get("WIDTH")))
                        .freezerCapacity(Double.parseDouble((String) params.get("FREEZER_CAPACITY")))
                        .overallCapacity(Double.parseDouble((String) params.get("OVERALL_CAPACITY")))
                        .build();
            case VACUUMCLEANER:
                return new VacuumCleaner.VacuumCleanerBuilder()
                        .powerConsumption(Integer.parseInt((String) params.get("POWER_CONSUMPTION")))
                        .bagType((String) params.get("BAG_TYPE"))
                        .cleaningWidth(Double.parseDouble((String) params.get("CLEANING_WIDTH")))
                        .motorSpeedRegulation(Double.parseDouble((String) params.get("MOTOR_SPEED_REGULATION")))
                        .filterType((String) params.get("FILTER_TYPE"))
                        .wandType((String) params.get("WAND_TYPE"))
                        .build();
            case SPEAKERS:
                return new Speakers.SpeakersBuilder()
                        .powerConsumption(Double.parseDouble((String) params.get("POWER_CONSUMPTION")))
                        .cordLength(Double.parseDouble((String) params.get("CORD_LENGTH")))
                        .frequencyRange((String) params.get("FREQUENCY_RANGE"))
                        .numberOfSpeakers(Integer.parseInt((String) params.get("NUMBER_OF_SPEAKERS")))
                        .build();
            default:
                return null;
        }
    }
}
