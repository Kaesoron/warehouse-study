package org.kaesoron.example.models;

import jakarta.persistence.*;
import org.springframework.util.StringUtils;

import java.util.List;

@Entity
@Table(name = "shelves")
public class Shelf {
    @Id
    @GeneratedValue
    private long shelfId;
    @ManyToOne(fetch = FetchType.EAGER)
    private Warehouse warehouse;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Slot> slots;

    @Override
    public String toString() {
        return "Warehouse " + getWarehouse().getWarehouseName() +
                " shelf number " + getShelfId() +
                " contains slots: %n" + StringUtils.collectionToDelimitedString(slots, "%n");
    }

    public long getShelfId() {
        return shelfId;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }
}
