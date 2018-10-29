package cn.ouctechnology.oodb.exception;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-29 10:08
 * @description: TODO
 **/
public class DbException extends RuntimeException {
    public DbException() {
        super();
    }

    public DbException(String message) {
        super(message);
    }

    public DbException(String message, Throwable cause) {
        super(message, cause);
    }

    public DbException(Throwable cause) {
        super(cause);
    }
}
