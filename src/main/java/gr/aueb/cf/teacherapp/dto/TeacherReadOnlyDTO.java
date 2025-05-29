package gr.aueb.cf.teacherapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class TeacherReadOnlyDTO {

    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedA;
    private String uuid;
    private String firstname;
    private String lastname;
    private String vat;
    private String region;
}
