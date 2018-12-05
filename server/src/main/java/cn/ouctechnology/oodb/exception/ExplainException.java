package cn.ouctechnology.oodb.exception;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-18 14:52
 * @description: TODO
 **/
public class ExplainException extends RuntimeException {
    public ExplainException() {
        super();
    }

    public ExplainException(String message) {
        super(message);
    }

    public ExplainException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExplainException(Throwable cause) {
        super(cause);
    }

    protected ExplainException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
