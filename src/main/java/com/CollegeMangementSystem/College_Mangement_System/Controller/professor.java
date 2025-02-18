package com.CollegeMangementSystem.College_Mangement_System.Controller;

import com.CollegeMangementSystem.College_Mangement_System.Entities.professorEntity;
import com.CollegeMangementSystem.College_Mangement_System.Services.professorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/professors")
public class professor {
    private final professorService professorService;
    @Autowired
    public professor(com.CollegeMangementSystem.College_Mangement_System.Services.professorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping
    public List<professorEntity> getAllProfessor(){
        return professorService.getAllprofessor();
    }

    @GetMapping(path = "/{professorId}")
    public professorEntity getProfessorById(@PathVariable Long professorId){
        return professorService.getProfessorById(professorId);
    }

    @PostMapping
    public professorEntity createProfessor(@RequestBody professorEntity professorEntity){
        return professorService.createProfessor(professorEntity);
    }

    @PutMapping(path = "/{professorId}/subject/{subjectId}")
    public professorEntity assignSubjectToProfessor(@PathVariable Long professorId,@PathVariable Long subjectId){
        return professorService.assignSubjectToProfessor(professorId,subjectId);
    }

    @PutMapping(path = "/{professorId}/student/{studentId}")
    public professorEntity assignStudentToProfessor(@PathVariable Long professorId,@PathVariable Long studentId){
        return professorService.assignStudentToProfessor(professorId,studentId);
    }


}
