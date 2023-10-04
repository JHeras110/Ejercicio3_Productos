package com.example.exceptions;

public class ProductoVacioException extends RuntimeException{
    public ProductoVacioException(String mensaje) {
        super(mensaje);
    }
}
