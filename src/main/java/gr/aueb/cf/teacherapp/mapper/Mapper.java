package gr.aueb.cf.teacherapp.mapper;

import gr.aueb.cf.teacherapp.core.enums.Role;
import gr.aueb.cf.teacherapp.dto.*;
import gr.aueb.cf.teacherapp.model.Student;
import gr.aueb.cf.teacherapp.model.Teacher;
import gr.aueb.cf.teacherapp.model.User;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    private Mapper(){}

    public Teacher mapToTeacherEntity(TeacherInsertDTO insertDTO) {
        Teacher teacher = new Teacher();
        teacher.setFirstname(insertDTO.getFirstname());
        teacher.setLastname(insertDTO.getLastname());
        teacher.setVat(insertDTO.getVat());
        return teacher;
    }

    public TeacherReadOnlyDTO mapToTeacherReadOnlyDTO(Teacher teacher) {
        return new TeacherReadOnlyDTO(teacher.getId(), teacher.getCreatedAt(), teacher.getUpdatedAt(),
                teacher.getUuid(), teacher.getFirstname(), teacher.getLastname(), teacher.getVat(),
                teacher.getRegion().getName());
    }

    public User mapToUserEntity(UserInsertDTO insertDTO) {

        return new User(null, insertDTO.getUsername(), insertDTO.getPassword(),
                Role.valueOf(insertDTO.getRole().toUpperCase()));
    }

    public StudentReadOnlyDTO mapToStudentReadOnlyDTO(Student student) {
        return new StudentReadOnlyDTO(student.getId(), student.getCreatedAt(), student.getUpdatedAt(),
                student.getUuid(), student.getFirstname(), student.getLastname(), student.getEmail(),
                student.getVat(), student.getPhoneNumber(), student.getRegion().getName());
    }

    public Student mapToStudentEntity(StudentInsertDTO insertDTO) {
        return new Student(null, insertDTO.getFirstname(), insertDTO.getLastname(), insertDTO.getEmail(),
                insertDTO.getPhone(), null, insertDTO.getVat(), null);
    }
}
