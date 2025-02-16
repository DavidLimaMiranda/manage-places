package com.estudo.project.exceptions;

public class PlaceNotFoundException extends RuntimeException{

    public PlaceNotFoundException() {super("Lugar não encontrado");}

    public PlaceNotFoundException(String message) {super(message);}
}
