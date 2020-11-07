package by.realovka.service.Exception;

public class SuchUserIsPresentException extends RuntimeException {

    public SuchUserIsPresentException() {
        super();
    }

    public SuchUserIsPresentException(String message) {
        super(message);
    }

    public SuchUserIsPresentException(String message, Throwable cause) {
        super(message, cause);
    }

    public SuchUserIsPresentException(Throwable cause) {
        super(cause);
    }

    protected SuchUserIsPresentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
