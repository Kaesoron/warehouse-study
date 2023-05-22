package org.kaesoron.example.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "commodities")
public class Commodity {

    @Id
    @GeneratedValue
    private long commodityId;
    @NotBlank
    private String commodityName;
    @Column
    private String description;
    @NotBlank
    private static Measures measure;
    @NotBlank
    private int quantity;
    @NotBlank
    private double volume;

    @Override
    public String toString() {
        return "ID " + commodityId +
                " " + commodityName;
    }

}
