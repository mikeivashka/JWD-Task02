package by.tc.task01.entity;

import by.tc.task01.enumeration.OperatingSystem;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Data
@Builder
public class Laptop implements Appliance {
    private double batteryCapacity;
    private OperatingSystem operatingSystem;
    private int memoryRom;
    private int systemMemory;
    private double cpu;
    private int displayInches;
}
