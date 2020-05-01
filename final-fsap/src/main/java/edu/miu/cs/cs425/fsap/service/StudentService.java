package edu.miu.cs.cs425.fsap.service;

import org.springframework.data.domain.Page;

import edu.miu.cs.cs425.fsap.model.Student;

import java.util.List;

public interface StudentService {

    public abstract List<Student> getAllStudents();
    public abstract Page<Student> getAllStudentsPaged(int pageNo);
    public abstract Student saveStudent(Student student);
    public abstract Student getStudentById(Long productId);

}
