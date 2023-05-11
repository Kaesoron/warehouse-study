package org.kaesoron.example.exceptions;

public class CallForWarehouseNotCreatedException extends RuntimeException {
    public CallForWarehouseNotCreatedException(String message) {
        super(message);
    }
}
