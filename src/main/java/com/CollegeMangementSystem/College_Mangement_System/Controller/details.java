package com.CollegeMangementSystem.College_Mangement_System.Controller;

import com.CollegeMangementSystem.College_Mangement_System.Entities.detailsEntity;
import com.CollegeMangementSystem.College_Mangement_System.Entities.professorEntity;
import com.CollegeMangementSystem.College_Mangement_System.Entities.subjectEntity;
import com.CollegeMangementSystem.College_Mangement_System.Services.detailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/details")
public class details {
    private final detailsService detailsService;
    @Autowired
    public details(com.CollegeMangementSystem.College_Mangement_System.Services.detailsService detailsService) {
        this.detailsService = detailsService;
    }

    @GetMapping(path = "/{detailId}")
    public detailsEntity getDeatailById(@PathVariable Long detailId) {
        return detailsService.getDetailById(detailId);
    }

    @PostMapping
    public detailsEntity createDeatil(@RequestBody detailsEntity createbodydetail){
           return detailsService.createDeatil(createbodydetail);
        }

        @PutMapping(path = "/{detailId}/mapstudent/{studentId}")
    public detailsEntity mapstudent(@PathVariable Long detailId,@PathVariable Long studentId){
          return detailsService.mapstudent(detailId,studentId);
        }







}
