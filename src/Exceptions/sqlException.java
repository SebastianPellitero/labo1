package Exceptions;

public class sqlException extends Exception {
    public sqlException() {
    }

    public sqlException(String message) {
        super(message);
    }

    public sqlException(String message, Throwable cause) {
        super(message, cause);
    }

    public sqlException(Throwable cause) {
        super(cause);
    }
}
