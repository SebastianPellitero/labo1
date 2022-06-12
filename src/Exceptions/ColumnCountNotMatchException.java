package Exceptions;

public class ColumnCountNotMatchException extends DAOException {
    public ColumnCountNotMatchException() {
    }

    public ColumnCountNotMatchException(String message) {
        super(message);
    }

    public ColumnCountNotMatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public ColumnCountNotMatchException(Throwable cause) {
        super(cause);
    }
}
