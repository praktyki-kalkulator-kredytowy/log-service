package com.praktyki.log.web.exceptions;

public class NotSuchEntityException extends Exception {
    public NotSuchEntityException() {
        super("Not such entity in base");
    }
}
