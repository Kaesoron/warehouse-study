package org.kaesoron.example.model;

public class Commodity {
    private final long commodityId;
    private String name;
    private String description;
    private static String measure;
    private int quantity;
    private int volume;

    @Override
    public String toString() {
        return new StringBuffer(
                "ID "+getCommodityId()+
                        " "+getName()
        ).toString();
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    private Slot slot;

    public long getCommodityId() {
        return commodityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static String getMeasure() {
        return measure;
    }

    public static void setMeasure(String measure) {
        Commodity.measure = measure;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }
}
