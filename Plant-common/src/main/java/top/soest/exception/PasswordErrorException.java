package top.soest.exception;

public class PasswordErrorException extends Exception{

    public PasswordErrorException() {

    }

    public PasswordErrorException(String message) {
        super(message);
    }
}
