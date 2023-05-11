package org.kaesoron.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "commodities")
public class Commodity {

    @Id
    @GeneratedValue
    private long commodityId;
    @NotBlank
    private String commodityName;
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
