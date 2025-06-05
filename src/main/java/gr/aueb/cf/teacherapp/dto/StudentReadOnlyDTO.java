package gr.aueb.cf.teacherapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentReadOnlyDTO {

    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String uuid;
    private String firstname;
    private String lastname;
    private String email;
    private String vat;
    private String phone;
    private String region;
}
