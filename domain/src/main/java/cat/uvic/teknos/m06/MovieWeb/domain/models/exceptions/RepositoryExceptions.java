package cat.uvic.teknos.m06.MovieWeb.domain.models.exceptions;

public class RepositoryExceptions extends RuntimeException {
    public RepositoryExceptions() {}
    public RepositoryExceptions(String message, Throwable cause) {
        super(message, cause);
    }
}
