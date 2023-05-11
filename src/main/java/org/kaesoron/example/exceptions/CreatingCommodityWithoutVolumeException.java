package org.kaesoron.example.exceptions;

public class CreatingCommodityWithoutVolumeException extends RuntimeException {
    public CreatingCommodityWithoutVolumeException(String message) {
        super(message);
    }
}
