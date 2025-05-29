package gr.aueb.cf.teacherapp.mapper;

import gr.aueb.cf.teacherapp.dto.TeacherInsertDTO;
import gr.aueb.cf.teacherapp.dto.TeacherReadOnlyDTO;
import gr.aueb.cf.teacherapp.model.Teacher;
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
}
