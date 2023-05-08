package org.kaesoron.example.model;

import java.util.List;

public class Shelf {
    private long shelfId;
    private List<Slot> slots;

    @Override
    public String toString() {
        return new StringBuffer(
                "Shelf number "+getShelfId()+
                        " contains slots: "+getSlots()
        ).toString();
    }

    public long getShelfId() {
        return shelfId;
    }

    public void setShelfId(long shelfId) {
        this.shelfId = shelfId;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Shelf> shelves) {
        this.slots = slots;
    }
}
