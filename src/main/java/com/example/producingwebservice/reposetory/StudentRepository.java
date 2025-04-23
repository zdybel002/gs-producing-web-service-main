package com.example.producingwebservice.reposetory;


import com.example.producingwebservice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT i FROM Student i")
    List<Student> findAll();
}
