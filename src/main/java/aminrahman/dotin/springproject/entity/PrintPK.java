package aminrahman.dotin.springproject.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class PrintPK implements Serializable {

    @Pattern(regexp = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])\\." +
            "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])\\." +
            "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])\\." +
            "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])", message = "Only IP addresses are accepted.")
    @NotNull
    public String ipAddress;
    @Size(min = 3)
    @NotNull
    public String branchCode;
}
