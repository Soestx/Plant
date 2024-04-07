package top.soest.exception;

public class EmailErrorException extends Exception{

    public EmailErrorException() {

    }

    public EmailErrorException(String message) {
        super(message);
    }
}
