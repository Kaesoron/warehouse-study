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
        return "Shelf number " + shelfId +
                " contains slots: %n" + StringUtils.collectionToDelimitedString(slots, "%n");
    }
}
