package by.tc.task01.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class TabletPC extends Appliance {
    private double batteryCapacity;
    private double memoryRom;
    private double displayInches;
    private double flashMemoryCapacity;
    private String color;
}
