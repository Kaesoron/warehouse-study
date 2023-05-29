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
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "warehouse")
    private List<Shelf> shelves;

    @Override
    public String toString() {
        return "Warehouse  " + warehouseName +
                ", ID: " + warehouseId +
                ", description: " + warehouseDescription +
                ", contains shelves: " + getShelves().size();
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
        return this.shelves;
    }

    public void addShelf(Shelf shelf) {
        this.shelves.add(shelf);
    }
}
