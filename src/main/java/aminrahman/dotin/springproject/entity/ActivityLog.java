package aminrahman.dotin.springproject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Builder(toBuilder = true)
@Entity
@Table(name = "T_ACTIVITY_LOG")
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "T_ACTIVITY_ID")
    private Integer activityId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    @Column(name = "C_ISSUE_DATE")
    private Timestamp issueDate;
    @Column(name = "C_ISSUE_OPERATION_NAME")
    private String issueOperationName;
    @Column(name = "C_PERSONNEL_CODE")
    @NotNull
    @Size(min = 5, max = 10, message = "Characters length should be between 5 to 10.")
    private String personnelCode;
    @Column(name = "C_PAN_NUMBER")
    @Size(min = 16, max = 16)
    @NotNull
    @Pattern(regexp = "\\d+", message = "Only numbers with a length of 16 are accepted.")
    private String panNumber;
    @Column(name = "C_APPLICATION_TYPE")
    private Integer applicationType;
}
