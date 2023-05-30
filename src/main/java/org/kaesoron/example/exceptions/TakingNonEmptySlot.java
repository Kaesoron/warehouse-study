package org.kaesoron.example.exceptions;

public class TakingNonEmptySlot extends RuntimeException {
    public TakingNonEmptySlot(String message) {
        super(message);
    }
}
