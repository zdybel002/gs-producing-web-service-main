package com.example.producingwebservice.controller;


import com.example.producingwebservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import task2.student.GetAllStudentsRequest;
import task2.student.GetAllStudentsResponse;
import task2.student.Student;

import java.util.List;

@Endpoint
public class StudentEndpoint {

    private static final String NAMESPACE_URI = "http://task2/student"; // Przestrzeń nazw z XSD

    private final StudentService studentService;

    @Autowired
    public StudentEndpoint(StudentService studentService) {
        this.studentService = studentService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllStudentsRequest")
    @ResponsePayload
    public GetAllStudentsResponse getStudentList(@RequestPayload GetAllStudentsRequest request) {
        GetAllStudentsResponse response = new GetAllStudentsResponse();

        studentService.getAllItems().forEach(item -> {
            Student itemResponse = new Student();
            itemResponse.setId(item.getId());
            itemResponse.setName(item.getFirstName()); // lub getName(), zależnie od encji

            // Jeśli chcesz przenieść courses:
            item.getCourses().forEach(courseEntity -> {
                task2.student.Course course = new task2.student.Course();
                course.setId(courseEntity.getId());
                course.setTitle(courseEntity.getCourseName());
                itemResponse.getCourses().add(course);
            });

            response.getStudent().add(itemResponse);
        });

        return response;
    }


}
