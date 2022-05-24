package aminrahman.dotin.springproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.ZonedDateTime;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<ErrorResponse> handleGeneralRuntimeException(RuntimeException exception, HttpServletRequest request) {
        return new ResponseEntity<>(ErrorResponse.builder().message("We can't process request " + request.getRequestURI() + ". Exception message: " + exception.getMessage()).time(ZonedDateTime.now()).statusCode(HttpStatus.BAD_REQUEST).build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
