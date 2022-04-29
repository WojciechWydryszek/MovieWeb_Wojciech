package cat.uvic.teknos.m06.MovieWeb.app.exception;

public class AppUnchekedException extends RuntimeException{
    public AppUnchekedException() {
    }

    public AppUnchekedException(String message) {
        super(message);
    }

    public AppUnchekedException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppUnchekedException(Throwable cause) {
        super(cause);
    }

    public AppUnchekedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
