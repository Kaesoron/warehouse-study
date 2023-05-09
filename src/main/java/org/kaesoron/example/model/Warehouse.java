package org.kaesoron.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name="warehouses")
public class Warehouse {
    @Id
    @GeneratedValue
    private long warehouseId;
    @NotBlank
    private String warehouseName;
    private String warehouseDescription;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "shelves")
    private List<Shelf> shelves;

    @Override
    public String toString() {
        return new StringBuffer(
                "Warehouse  "+warehouseName+
                        " ID: "+warehouseId+
                        " description: "+warehouseDescription+
                        " contains shelves: "+shelves.size()
        ).toString();
    }
}
