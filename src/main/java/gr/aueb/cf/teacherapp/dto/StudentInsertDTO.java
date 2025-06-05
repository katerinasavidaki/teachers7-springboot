package gr.aueb.cf.teacherapp.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentInsertDTO {

    @NotNull(message = "Firstname must not be empty")
    @Size(min = 4, message = "Firstname must contain at least 4 characters")
    private String firstname;

    @NotNull(message = "Lastname must not be empty")
    @Size(min = 4, message = "Lastname must contain at least 4 characters")
    private String lastname;

    @NotNull(message = "Email must not be empty")
    @Pattern(regexp = "^.+@.+\\.[a-zA-Z]{2,}$")
    private String email;

    @NotNull(message = "Vat must not be empty")
    @Pattern(regexp = "\\d{9,}", message = "Vat can not be less than 9 characters")
    private String vat;

    @NotNull(message = "Phone must not be empty")
    @Pattern(regexp = "^\\d{9,}$", message = "Phone must contain at least 9 digits")
    private String phone;

    @NotNull(message = "Region must not be empty")
    private Long regionId;
}
