package org.javaCar;

public class InvalidMotorTypeException extends RuntimeException {
    public InvalidMotorTypeException(String message) {
        super(message);
    }
}
