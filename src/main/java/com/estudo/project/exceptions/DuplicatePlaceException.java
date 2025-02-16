package com.estudo.project.exceptions;

public class DuplicatePlaceException extends RuntimeException {

    public DuplicatePlaceException() { super("Você já registrou este lugar"); }

    public DuplicatePlaceException(String message) { super(message); }
}
