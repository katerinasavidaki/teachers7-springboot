package gr.aueb.cf.teacherapp.repository;

import gr.aueb.cf.teacherapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>, JpaSpecificationExecutor<Student> {

    List<Student> findByRegionId(Long id);
    Optional<Student> findByUuid(String uuid);
    Optional<Student> findByVat(String vat);
    Optional<Student> findByEmail(String email);
}
