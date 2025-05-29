package gr.aueb.cf.teacherapp.service;

import gr.aueb.cf.teacherapp.core.exceptions.EntityAlreadyExistsException;
import gr.aueb.cf.teacherapp.core.exceptions.EntityInvalidArgumentException;
import gr.aueb.cf.teacherapp.dto.TeacherInsertDTO;
import gr.aueb.cf.teacherapp.dto.TeacherReadOnlyDTO;
import gr.aueb.cf.teacherapp.mapper.Mapper;
import gr.aueb.cf.teacherapp.model.Teacher;
import gr.aueb.cf.teacherapp.model.static_data.Region;
import gr.aueb.cf.teacherapp.repository.RegionRepository;
import gr.aueb.cf.teacherapp.repository.TeacherRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // for DI with final fields
public class TeacherService implements ITeacherService {

    private final TeacherRepository teacherRepository;
    private final RegionRepository regionRepository;
    private final Mapper mapper;

//    @Autowired // for DI
//    public TeacherService(TeacherRepository teacherRepository, RegionRepository regionRepository, Mapper mapper) {
//        this.teacherRepository = teacherRepository;
//        this.regionRepository = regionRepository;
//        this.mapper = mapper;
//    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public Teacher saveTeacher(TeacherInsertDTO teacherInsertDTO)
            throws EntityAlreadyExistsException,EntityInvalidArgumentException {

        if (teacherRepository.findByVat(teacherInsertDTO.getVat()).isPresent()) {
            throw new EntityAlreadyExistsException("Teacher", "Teacher with vat " + teacherInsertDTO.getVat() + " already exists");
        }

        Teacher teacher = mapper.mapToTeacherEntity(teacherInsertDTO);

        Region region = regionRepository.findById(teacherInsertDTO.getRegionId())
                .orElseThrow(() -> new EntityInvalidArgumentException("Region", "Invalid region id"));

        region.addTeacher(teacher);
        return teacherRepository.save(teacher);

    }

    @Override
    @Transa
    public Page<TeacherReadOnlyDTO> getPaginatedTeachers(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Teacher> teacherPage = teacherRepository.findAll(pageable);
        return teacherPage.map(mapper::mapToTeacherReadOnlyDTO);
    }
}
