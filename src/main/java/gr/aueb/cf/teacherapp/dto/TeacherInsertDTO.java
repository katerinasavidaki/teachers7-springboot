package gr.aueb.cf.teacherapp.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class TeacherInsertDTO {

    @NotNull(message = "Firstname must not be empty")
    @Size(min = 2, message = "Firstname must contain at least 2 characters")
    private String firstname;

    @NotNull(message = "Lastname must not be empty")
    @Size(min = 2, message = "Lastname must contain at least 2 characters")
    private String lastname;

    @Pattern(regexp = "\\d{9,}", message = "Vat can not be less than 9 characters")
    private String vat;

    @NotNull(message = "Region must not be empty")
    private Long regionId;
}
