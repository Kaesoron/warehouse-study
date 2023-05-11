package org.kaesoron.example.exceptions;

public class CreatingCommodityWithoutQuantityException extends RuntimeException {
    public CreatingCommodityWithoutQuantityException(String message) {
        super(message);
    }
}
