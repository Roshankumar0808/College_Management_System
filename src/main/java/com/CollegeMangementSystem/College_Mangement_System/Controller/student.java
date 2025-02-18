package com.CollegeMangementSystem.College_Mangement_System.Controller;

import com.CollegeMangementSystem.College_Mangement_System.Entities.studentEntity;
import com.CollegeMangementSystem.College_Mangement_System.Services.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/student")
public class student {
    private final studentService studentService;
    @Autowired
    public student(com.CollegeMangementSystem.College_Mangement_System.Services.studentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "/{studentId}")
    public studentEntity getstudentById(@PathVariable Long studentId){
        return studentService.getstudentById(studentId);
    }


    @PostMapping
    public studentEntity createStudent(@RequestBody studentEntity studentEntity){
        return studentService.createStudent(studentEntity);
    }

    @PutMapping(path = "/{subjectId}/subject/{studentId}")
    public studentEntity assignSubjectToStudent(@PathVariable Long subjectId,@PathVariable Long studentId){
        return studentService.assignSubjectToStudent(subjectId,studentId);
    }



}
