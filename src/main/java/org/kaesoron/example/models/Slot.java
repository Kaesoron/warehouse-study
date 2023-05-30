package org.kaesoron.example.models;

import jakarta.persistence.*;

@Entity
@Table(name = "slots")
public class Slot {
    @Id
    @GeneratedValue
    private long slotId;
    @ManyToOne(fetch = FetchType.LAZY)
    private Shelf shelf;
    @OneToOne(fetch = FetchType.EAGER)
    private Commodity commodity;

    private boolean isEmpty = true;

    @Override
    public String toString() {
        return "Slot number " + slotId +
                " contains commodity: " + commodity;
    }

    public long getSlotId() {
        return slotId;
    }

    public void setSlotId(long slotId) {
        this.slotId = slotId;
    }

    public Shelf getShelf() {
        return shelf;
    }

    public void setShelf(Shelf shelf) {
        this.shelf = shelf;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }
}
