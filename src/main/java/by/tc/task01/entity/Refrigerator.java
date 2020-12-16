package by.tc.task01.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class Refrigerator extends Appliance{
    private int powerConsumption;
    private double freezerCapacity;
    private double overallCapacity;
    private double weight;
    private double width;
    private double height;
}
