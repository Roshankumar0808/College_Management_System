package com.CollegeMangementSystem.College_Mangement_System.Controller;

import com.CollegeMangementSystem.College_Mangement_System.Entities.subjectEntity;
import com.CollegeMangementSystem.College_Mangement_System.Services.subjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/subject")
public class subject {
    private final subjectService subjectService;
    @Autowired
    public subject(com.CollegeMangementSystem.College_Mangement_System.Services.subjectService subjectService) {
        this.subjectService = subjectService;
    }

   @GetMapping(path = "/{subjectId}")
    public subjectEntity getSubjectById(@PathVariable Long subjectId){
        return subjectService.getSubjectById(subjectId);
   }

   @PostMapping
    public subjectEntity createSubject(@RequestBody subjectEntity subjectEntity){
        return subjectService.createSubject(subjectEntity);
   }

}
