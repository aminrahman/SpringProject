package aminrahman.dotin.springproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.time.ZonedDateTime;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException exception, HttpServletRequest request) {
        StringBuilder errorMessages = new StringBuilder("|");
        for (ConstraintViolation violation :
                exception.getConstraintViolations()) {
            errorMessages.append(violation.getMessage()).append("|");
        }
        return new ResponseEntity<>(ErrorResponse.builder().message("Can't process request " + request.getRequestURI() + ". " + errorMessages).time(ZonedDateTime.now()).statusCode(HttpStatus.MULTI_STATUS).build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({RecordAlreadyExistsException.class})
    public ResponseEntity<ErrorResponse> handleRecordAlreadyExistsException(RecordAlreadyExistsException exception, HttpServletRequest request) {
        return new ResponseEntity<>(ErrorResponse.builder().message("Can't process request " + request.getRequestURI() + ". " + exception.getMessage()).time(ZonedDateTime.now()).statusCode(HttpStatus.ALREADY_REPORTED).build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({HttpMessageNotReadableException.class, NoSuchElementException.class})
    public ResponseEntity<ErrorResponse> handleRequestBodyException(RuntimeException exception, HttpServletRequest request) {
        return new ResponseEntity<>(ErrorResponse.builder().message("Can't process request " + request.getRequestURI() + ". " + exception.getMessage()).time(ZonedDateTime.now()).statusCode(HttpStatus.BAD_REQUEST).build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
