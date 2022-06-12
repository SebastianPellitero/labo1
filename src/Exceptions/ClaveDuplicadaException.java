package Exceptions;

public class ClaveDuplicadaException extends DAOException {

    public ClaveDuplicadaException() {
    }

    public ClaveDuplicadaException(String message) {
        super(message);
    }

    public ClaveDuplicadaException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClaveDuplicadaException(Throwable cause) {
        super(cause);
    }
}
