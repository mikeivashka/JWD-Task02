package by.tc.task01.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Data
@Builder
public class Oven implements Appliance{
    private int powerConsumption;
    private int weight;
    private int capacity;
    private int depth;
    private double height;
    private double width;
}
