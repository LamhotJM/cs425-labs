package edu.miu.cs.cs425.fsap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.miu.cs.cs425.fsap.model.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
}
