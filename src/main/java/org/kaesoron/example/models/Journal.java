package org.kaesoron.example.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "journal")
public class Journal {
    @Id
    @GeneratedValue
    private long operationId;
    @Column
    private OperationType operationType;
    @Column
    private String commodityName;
    @Column
    private String operationTime;

    public long getOperationId() {
        return operationId;
    }

    public void setOperationId(long operationId) {
        this.operationId = operationId;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String newName) {
        this.commodityName = newName;
    }

    public String getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(String operationTime) {
        this.operationTime = operationTime;
    }

    public Journal(){
        this.setOperationTime(new Date().toString());
    }
    public Journal(OperationType type, String newName) {
        this.setOperationTime(new Date().toString());
        this.setOperationType(type);
        this.setCommodityName(newName);
    }
}
