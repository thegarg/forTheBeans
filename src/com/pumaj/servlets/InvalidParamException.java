package com.pumaj.servlets;

public class InvalidParamException extends Exception {
    public InvalidParamException() {

    }

    public InvalidParamException(String m) {
        super(m);
    }
}
