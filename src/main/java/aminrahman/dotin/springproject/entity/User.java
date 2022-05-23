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
@Entity(name = "T_USER")
public class User {

    @Id
    @Column(name = "C_PERSONNEL_CODE")
    public String personnelCode;
    @Column(name = "C_CARD_PAN")
    public String cardPan;
}
