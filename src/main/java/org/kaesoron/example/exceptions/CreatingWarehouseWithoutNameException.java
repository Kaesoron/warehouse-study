package org.kaesoron.example.exceptions;

public class CreatingWarehouseWithoutNameException extends RuntimeException {
    public CreatingWarehouseWithoutNameException(String message) {
        super(message);
    }
}
