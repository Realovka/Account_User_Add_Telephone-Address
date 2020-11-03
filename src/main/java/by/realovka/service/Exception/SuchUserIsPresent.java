package by.realovka.service.Exception;

public class SuchUserIsPresent extends RuntimeException {

    public SuchUserIsPresent() {
        super();
    }

    public SuchUserIsPresent(String message) {
        super(message);
    }

    public SuchUserIsPresent(String message, Throwable cause) {
        super(message, cause);
    }

    public SuchUserIsPresent(Throwable cause) {
        super(cause);
    }

    protected SuchUserIsPresent(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
