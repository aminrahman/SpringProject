package aminrahman.dotin.springproject.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class PrintPK implements Serializable {

    @Pattern(regexp = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])\\." +
            "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])\\." +
            "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])\\." +
            "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])", message = "Only IP addresses are accepted.")
    @NotNull
    @Column(name = "C_IP_ADDRESS")
    public String ipAddress;

    @Size(min = 3)
    @NotNull
    @Column(name = "C_BRANCH_CODE")
    public String branchCode;
}
