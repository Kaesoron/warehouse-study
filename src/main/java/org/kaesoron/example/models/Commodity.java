package org.kaesoron.example.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.List;


@Entity
@Table(name = "commodities")
public class Commodity {

    @Id
    @GeneratedValue
    private long commodityId;
    @Size(min=1, message = "Name should not be empty")
    private String commodityName;
    @Column
    private String description;
    @OneToOne()
    private Slot slot;

    @OneToMany
    private List<Journal> journal;

    @Column
    private boolean isPresent;

    @Override
    public String toString() {
        return "ID " + commodityId +
                " " + commodityName;
    }

    public long getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(long commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot=slot;
    }
}
