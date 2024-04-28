package top.soest.exception;

/**
 * 账号不存在异常
 */
public class IdNotFoundException extends BaseException {

    public IdNotFoundException() {
    }

    public IdNotFoundException(String msg) {
        super(msg);
    }

}
