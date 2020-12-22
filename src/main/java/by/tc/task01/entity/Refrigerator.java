package by.tc.task01.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Data
@Builder
public class Refrigerator implements Appliance{
    private int powerConsumption;
    private double freezerCapacity;
    private double overallCapacity;
    private double weight;
    private double width;
    private double height;
}
