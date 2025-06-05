package gr.aueb.cf.teacherapp.model.static_data;

import gr.aueb.cf.teacherapp.model.Student;
import gr.aueb.cf.teacherapp.model.Teacher;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "regions")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Getter(AccessLevel.PRIVATE)
    @OneToMany(mappedBy = "region")
    private Set<Teacher> teachers = new HashSet<>();

    public Set<Teacher> getAllTeachers() {
        if (teachers == null) teachers = new HashSet<>();
        return Collections.unmodifiableSet(teachers);
    }

    public void addTeacher(Teacher teacher) {
        if (teachers == null) teachers = new HashSet<>();
        teachers.add(teacher);
        teacher.setRegion(this);
    }

    @Getter(AccessLevel.PRIVATE)
    @OneToMany(mappedBy = "region")
    private Set<Student> students = new HashSet<>();

    public Set<Student> getAllStudents() {
        if (students == null) students = new HashSet<>();
        return Collections.unmodifiableSet(students);
    }

    public void addStudent(Student student) {
        if (students == null) students = new HashSet<>();
        students.add(student);
        student.setRegion(this);
    }
}
