package cat.uvic.teknos.m06.MovieWeb.app.exception;

public class AppCheckExceptions extends Exception {
    public AppCheckExceptions() {
    }

    public AppCheckExceptions(String message) {
        super(message);
    }

    public AppCheckExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public AppCheckExceptions(Throwable cause) {
        super(cause);
    }

    public AppCheckExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
