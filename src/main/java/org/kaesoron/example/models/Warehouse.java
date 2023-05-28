package org.kaesoron.example.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="warehouses")
public class Warehouse {
    @Id
    @GeneratedValue
    private long warehouseId;
    @NotBlank(message = "Name should not be empty")
    private String warehouseName;
    private String warehouseDescription;
    @OneToMany
    private List<Shelf> shelves;

    @Override
    public String toString() {
        if (this.getShelves()==null) {
            return "Warehouse  " + warehouseName +
                    ", ID: " + warehouseId +
                    ", description: " + warehouseDescription +
                    ", contains shelves: " + 0;
        } else {
            return "Warehouse  " + warehouseName +
                    ", ID: " + warehouseId +
                    ", description: " + warehouseDescription +
                    ", contains shelves: " + this.shelves.size();
        }
    }

    public long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getWarehouseDescription() {
        return warehouseDescription;
    }

    public void setWarehouseDescription(String warehouseDescription) {
        this.warehouseDescription = warehouseDescription;
    }

    public List<Shelf> getShelves() {
        return shelves;
    }

    public void setShelves(List<Shelf> shelves) {
        this.shelves = shelves;
    }
}
