package top.soest.exception;

public class UserNoLoginException extends Exception{

    public UserNoLoginException() {

    }

    public UserNoLoginException(String message) {
        super(message);
    }
}
