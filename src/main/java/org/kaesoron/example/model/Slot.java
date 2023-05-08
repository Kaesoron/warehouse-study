package org.kaesoron.example.model;

public class Slot {
    private long slotId;
    private Shelf shelf;
    private Commodity commodity;
    private boolean isEmpty;

    @Override
    public String toString() {
        return new StringBuffer(
                "Slot number "+getSlotId()+
                        " contains commodity: "+getCommodity()
        ).toString();
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
