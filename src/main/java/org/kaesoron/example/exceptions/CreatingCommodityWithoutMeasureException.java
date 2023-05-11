package org.kaesoron.example.exceptions;

public class CreatingCommodityWithoutMeasureException extends RuntimeException {
    public CreatingCommodityWithoutMeasureException(String message) {
        super(message);
    }
}
