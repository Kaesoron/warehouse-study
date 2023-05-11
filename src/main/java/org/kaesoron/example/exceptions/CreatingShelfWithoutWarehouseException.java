package org.kaesoron.example.exceptions;

public class CreatingShelfWithoutWarehouseException extends RuntimeException {
    public CreatingShelfWithoutWarehouseException(String message) {
        super(message);
    }
}
