package org.kaesoron.example.exceptions;

public class CreatingCommodityWithoutNameException extends RuntimeException {
    public CreatingCommodityWithoutNameException(String message) {
        super(message);
    }
}
