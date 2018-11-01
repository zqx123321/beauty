package cn.ouctechnology.oodb.exception;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-31 15:15
 * @description: TODO
 **/
public class ParseException extends RuntimeException {

    public ParseException(Throwable cause) {
        super(cause);
    }

    public ParseException() {
        super();
    }

    public ParseException(String message) {
        super(message);
    }

    public ParseException(String message, Throwable cause) {
        super(message, cause);
    }

    protected ParseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
