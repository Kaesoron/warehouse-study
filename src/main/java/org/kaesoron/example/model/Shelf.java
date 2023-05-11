package org.kaesoron.example.model;

import jakarta.persistence.*;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "shelves")
public class Shelf {
    @Id
    @GeneratedValue
    private long shelfId;
    @ManyToOne(fetch = FetchType.EAGER)
    private Warehouse warehouse;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "slots")
    private List<Slot> slots;

    @Override
    public String toString() {
        return new StringBuffer(
                "Shelf number "+String.valueOf(shelfId)+
                        " contains slots: %n"+ StringUtils.collectionToDelimitedString(slots, "%n")
                ).toString();
    }
}