package crinfotask.task.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiError handleException(MethodArgumentNotValidException ex) {

        String error = ex.getLocalizedMessage();
        String message = ex.getMessage();

        return new ApiError(HttpStatus.BAD_REQUEST, message, error);
    }

}
