package org.kaesoron.example.exceptions;

public class CreatingWarehouseWithBlankNameException extends RuntimeException {
    public CreatingWarehouseWithBlankNameException(String message) {
        super(message);
    }
}
