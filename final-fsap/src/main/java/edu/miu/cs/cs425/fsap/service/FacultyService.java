package edu.miu.cs.cs425.fsap.service;

import org.springframework.data.domain.Page;

import edu.miu.cs.cs425.fsap.model.Faculty;

import java.util.List;

public interface FacultyService {

    public abstract List<Faculty> getAllFaculties();
    public abstract Page<Faculty> getAllFacultyPaged(int pageNo);

}
