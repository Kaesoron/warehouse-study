package org.kaesoron.example.models;

import jakarta.persistence.*;
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
    @OneToOne(fetch = FetchType.LAZY)
    private Slot slot;

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

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        slot.setEmpty(false);
        this.slot=slot;
    }
}
