package com.revature.demo.excpetion;

public class NotFoundException extends RuntimeException {

    public NotFoundException(){
        super();
    }

    public NotFoundException(String message){
        super(message);
    }

}
