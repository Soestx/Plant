package top.soest.exception;

public class NoPermissionException extends Exception{

    public NoPermissionException() {

    }

    public NoPermissionException(String message) {
        super(message);
    }
}
