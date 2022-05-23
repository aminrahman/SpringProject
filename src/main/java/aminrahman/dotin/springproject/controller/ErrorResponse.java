package aminrahman.dotin.springproject.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponse {
    private HttpStatus statusCode;
    private String message;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private ZonedDateTime time;
}
