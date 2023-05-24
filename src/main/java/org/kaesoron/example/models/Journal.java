package org.kaesoron.example.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "journal")
public class Journal {
    @Id
    @GeneratedValue
    private long operationId;
    @NotBlank
    private OperationType operationType;
    @NotBlank
    @OneToOne
    private Commodity commodity;
    @Column
    private String operationTime;
}
