package dev.waiver.com.util.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String msg){
        super(msg);
    }

    public NotFoundException(){}
}
