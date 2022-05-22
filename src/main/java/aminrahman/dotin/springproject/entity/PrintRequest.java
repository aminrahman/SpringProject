package aminrahman.dotin.springproject.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table(name = "T_PRINT_REQUEST")
public class PrintRequest {
    @EmbeddedId
    @Column(name = "C_PRINT_ID")
    public PrintPK printId;
    @Column(name = "C_PERSONNEL_CODE")
    @NotNull
    @Size(min = 5, max = 10, message = "Characters length should be between 5 to 10.")
    public String personnelCode;
    @Column(name = "C_CARD_PAN")
    @Size(min = 16, max = 16)
    @Pattern(regexp = "\\d+", message = "Only numbers with a length of 16 are accepted.")
    public String cardPAN;
}
