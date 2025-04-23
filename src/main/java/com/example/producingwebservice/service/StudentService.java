package com.example.producingwebservice.service;

import com.example.producingwebservice.entity.Student;
import com.example.producingwebservice.reposetory.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllItems() {
        log.info("Getting all items");
        return studentRepository.findAll();
    }


}
