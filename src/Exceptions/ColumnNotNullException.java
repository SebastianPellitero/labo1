package Exceptions;

public class ColumnNotNullException extends DAOException {
    public ColumnNotNullException() {
    }

    public ColumnNotNullException(String message) {
        super(message);
    }

    public ColumnNotNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public ColumnNotNullException(Throwable cause) {
        super(cause);
    }
}
