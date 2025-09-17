package com.plataforma.exception;

public class CursoLlenoException extends Exception {

    public CursoLlenoException(String message){
        super(message);
    }

    public CursoLlenoException(String message, Throwable cause){
        super(message, cause);
    }
}
