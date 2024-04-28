package top.soest.exception;

public class AccountAlreadyExists extends BaseException{

    public AccountAlreadyExists() {

    }

    public AccountAlreadyExists(String message) {
        super(message);
    }
}
