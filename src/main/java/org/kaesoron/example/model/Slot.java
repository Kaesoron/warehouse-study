package org.kaesoron.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

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
    @NotBlank
    private boolean isEmpty;

    @Override
    public String toString() {
        return "Slot number " + slotId +
                " contains commodity: " + commodity;
    }
}
