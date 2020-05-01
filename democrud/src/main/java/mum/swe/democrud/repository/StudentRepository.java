package mum.swe.democrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mum.swe.democrud.model.Student;

@Repository("studentRepository")// refer by name
public interface StudentRepository extends JpaRepository<Student, Long> {
}
