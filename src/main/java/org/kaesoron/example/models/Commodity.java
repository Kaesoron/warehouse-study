package org.kaesoron.example.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "commodities")
public class Commodity {

    @Id
    @GeneratedValue
    private long commodityId;
    @NotBlank (message = "Name should not be empty")
    private String commodityName;
    @Column
    private String description;
    @NotBlank (message = "Measure should not be empty")
    private static Measures measure;
    @NotBlank (message = "Quantity should not be empty")
    @Min(value = 0, message = "Quantity shall be 0 or greater")
    private int quantity;
    @NotBlank (message = "Volume should not be empty")
    @Min(value = 0, message = "Volume shall be 0 or greater")
    private double volume;

    @Override
    public String toString() {
        return "ID " + commodityId +
                " " + commodityName;
    }

}
