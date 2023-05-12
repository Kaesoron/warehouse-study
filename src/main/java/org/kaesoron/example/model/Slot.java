package org.kaesoron.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "slots")
public class Slot {
    @Id
    @GeneratedValue
    private long slotId;
    @ManyToOne(fetch = FetchType.LAZY)
    private Shelf shelf;
    @OneToOne(fetch = FetchType.EAGER, mappedBy = "commodities")
    private Commodity commodity;
    @NotBlank
    private boolean isEmpty;

    @Override
    public String toString() {
        return "Slot number " + slotId +
                " contains commodity: " + commodity;
    }
}
