package edu.miu.cs.cs425.fsap.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.miu.cs.cs425.fsap.model.Faculty;
import edu.miu.cs.cs425.fsap.repository.FacultyRepository;
import edu.miu.cs.cs425.fsap.service.FacultyService;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {

    private FacultyRepository facultyRepository;

    @Autowired
    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAll(Sort.by("fullName"));
    }

    @Override
    public Page<Faculty> getAllFacultyPaged(int pageNo) {
        return facultyRepository.findAll(PageRequest.of(pageNo, 5, Sort.by("fullName")));
    }
}
