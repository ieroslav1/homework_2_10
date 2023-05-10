package pro.sky.homework_2_10.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (HttpStatus.BAD_REQUEST)
public class EmployeeStringUtilsException extends RuntimeException{
    public EmployeeStringUtilsException() {
    }

    public EmployeeStringUtilsException(String message) {
        super(message);
    }

    public EmployeeStringUtilsException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeStringUtilsException(Throwable cause) {
        super(cause);
    }

    public EmployeeStringUtilsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
