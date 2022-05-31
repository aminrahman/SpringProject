package aminrahman.dotin.springproject.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

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
            "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])", message = "Only values in IP format are accepted for Ip Addresses.")
    @NotNull
    @Column(name = "C_IP_ADDRESS")
    public String ipAddress;

    @Size(min = 3, message = "Minimum length for Branch Code is 3.")
    @NotNull
    @Column(name = "C_BRANCH_CODE")
    public String branchCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PrintPK)) return false;
        PrintPK printPK = (PrintPK) o;
        return ipAddress.equals(printPK.ipAddress) && branchCode.equals(printPK.branchCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ipAddress, branchCode);
    }
}
