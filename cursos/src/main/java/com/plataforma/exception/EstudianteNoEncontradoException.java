package com.plataforma.exception;

public class EstudianteNoEncontradoException extends Exception{

    public EstudianteNoEncontradoException(String message){
        super(message);
    }

    public EstudianteNoEncontradoException(String message, Throwable cause){
        super(message, cause);
    }
}
