package top.soest.exception;

public class PasswordEditFailedException extends Exception{

    public PasswordEditFailedException() {

    }

    public PasswordEditFailedException(String message) {
        super(message);
    }
}
