package aminrahman.dotin.springproject.entity;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "T_PRINTER")
public class Printer {
    @Id
    @Column(name = "C_IP_ADDRESS")
    public String ipAddress;
    @Column(name = "C_BRANCH_CODE")
    public String branchCode;
}
