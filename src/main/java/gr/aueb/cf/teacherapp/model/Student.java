package gr.aueb.cf.teacherapp.model;

import gr.aueb.cf.teacherapp.model.static_data.Region;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@Getter
@Setter
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Student extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String firstname;
    private String lastname;

    @Email
    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String phoneNumber;

    @Column(unique = true)
    private String uuid;

    @Column(unique = true)
    private String vat;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    public void initializeUUID() {
        if (uuid == null) {
            uuid = java.util.UUID.randomUUID().toString();
        }
    }


}
