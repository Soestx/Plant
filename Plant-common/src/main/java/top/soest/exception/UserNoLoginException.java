package top.soest.exception;

public class UserNoLoginException extends BaseException{

    public UserNoLoginException() {

    }

    public UserNoLoginException(String message) {
        super(message);
    }
}
