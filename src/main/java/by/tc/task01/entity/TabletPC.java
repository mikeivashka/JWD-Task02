package by.tc.task01.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Data
@Builder
public class TabletPC implements Appliance {
    private double batteryCapacity;
    private double memoryRom;
    private double displayInches;
    private double flashMemoryCapacity;
    private String color;
}
