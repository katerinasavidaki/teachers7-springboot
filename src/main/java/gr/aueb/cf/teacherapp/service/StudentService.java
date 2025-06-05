package gr.aueb.cf.teacherapp.service;

import gr.aueb.cf.teacherapp.core.exceptions.EntityAlreadyExistsException;
import gr.aueb.cf.teacherapp.core.exceptions.EntityInvalidArgumentException;
import gr.aueb.cf.teacherapp.core.exceptions.EntityNotFoundException;
import gr.aueb.cf.teacherapp.dto.StudentInsertDTO;
import gr.aueb.cf.teacherapp.dto.StudentReadOnlyDTO;
import gr.aueb.cf.teacherapp.mapper.Mapper;
import gr.aueb.cf.teacherapp.model.Student;
import gr.aueb.cf.teacherapp.model.static_data.Region;
import gr.aueb.cf.teacherapp.repository.RegionRepository;
import gr.aueb.cf.teacherapp.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService {

    private final StudentRepository studentRepository;
    private final Mapper mapper;
    private final RegionRepository regionRepository;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public Student saveStudent(StudentInsertDTO insertDTO) throws EntityAlreadyExistsException, EntityInvalidArgumentException {

        if (studentRepository.findByVat(insertDTO.getVat()).isPresent()) {
            throw new EntityAlreadyExistsException("Student", "Student with VAT " + insertDTO.getVat() + " already exists");
        }

        Student student = mapper.mapToStudentEntity(insertDTO);

        Region region = regionRepository.findById(insertDTO.getRegionId())
                .orElseThrow(() -> new EntityInvalidArgumentException("Region", "Invalid region id"));

        region.addStudent(student);
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) throws EntityInvalidArgumentException, EntityNotFoundException {

        if (id == null || id <= 0) {
            throw new EntityInvalidArgumentException("Student", "Invalid student ID");
        }

        return studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student", "Student with ID " + id + " not found"));
    }

    @Override
    public Page<StudentReadOnlyDTO> getPaginatedStudents(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Student> studentPage = studentRepository.findAll(pageable);
        return studentPage.map(mapper::mapToStudentReadOnlyDTO);
    }
}
