package org.kaesoron.example.exceptions;

public class CreatingSlotWithoutShelfException extends RuntimeException {
    public CreatingSlotWithoutShelfException(String message) {
        super(message);
    }
}
