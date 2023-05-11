package org.kaesoron.example.exceptions;

public class DeletingNotEmptyEntityException extends RuntimeException{
    public DeletingNotEmptyEntityException(String message) {
        super(message);
    }
}
