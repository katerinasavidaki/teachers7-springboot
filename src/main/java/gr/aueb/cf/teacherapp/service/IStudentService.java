package gr.aueb.cf.teacherapp.service;

import gr.aueb.cf.teacherapp.core.exceptions.EntityAlreadyExistsException;
import gr.aueb.cf.teacherapp.core.exceptions.EntityInvalidArgumentException;
import gr.aueb.cf.teacherapp.core.exceptions.EntityNotFoundException;
import gr.aueb.cf.teacherapp.dto.StudentReadOnlyDTO;
import gr.aueb.cf.teacherapp.model.Student;
import org.springframework.data.domain.Page;

public interface IStudentService {

    Student saveStudent(Student student)
            throws EntityAlreadyExistsException, EntityInvalidArgumentException;
    Student getStudentById(Long id)
            throws EntityInvalidArgumentException, EntityNotFoundException;
    Page<StudentReadOnlyDTO> getPaginatedStudents(int page, int size);
}
