package cn.ouctechnology.oodb.beauty.exception;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-14 09:40
 * @description: TODO
 **/
public class BeautifulException extends RuntimeException {
    public BeautifulException() {
        super();
    }

    public BeautifulException(String message) {
        super(message);
    }

    public BeautifulException(String message, Throwable cause) {
        super(message, cause);
    }

    public BeautifulException(Throwable cause) {
        super(cause);
    }

    protected BeautifulException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
