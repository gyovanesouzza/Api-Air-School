package com.airschool.apiairschool.services.exceptions;

public class ObjectDuplicateException extends RuntimeException {
    public ObjectDuplicateException(String msg) {
        super(msg);
    }

    public ObjectDuplicateException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
