package com.CollegeMangementSystem.College_Mangement_System.Services;

import com.CollegeMangementSystem.College_Mangement_System.Entities.detailsEntity;
import com.CollegeMangementSystem.College_Mangement_System.Entities.studentEntity;
import com.CollegeMangementSystem.College_Mangement_System.Repositories.detailsRepo;
import com.CollegeMangementSystem.College_Mangement_System.Repositories.professorRepo;
import com.CollegeMangementSystem.College_Mangement_System.Repositories.studentRepo;
import com.CollegeMangementSystem.College_Mangement_System.Repositories.subjectRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class detailsService {

private final detailsRepo detailsRepo;
private final professorRepo professorRepo;
private final studentRepo studentRepo;
private final subjectRepo subjectRepo;

    public detailsService(com.CollegeMangementSystem.College_Mangement_System.Repositories.detailsRepo detailsRepo, com.CollegeMangementSystem.College_Mangement_System.Repositories.professorRepo professorRepo, com.CollegeMangementSystem.College_Mangement_System.Repositories.studentRepo studentRepo, com.CollegeMangementSystem.College_Mangement_System.Repositories.subjectRepo subjectRepo) {
        this.detailsRepo = detailsRepo;
        this.professorRepo = professorRepo;
        this.studentRepo = studentRepo;
        this.subjectRepo = subjectRepo;
    }

    public detailsEntity getDetailById(Long detailId){
        return detailsRepo.findById(detailId).orElse(null);
    }

    public detailsEntity createDeatil(detailsEntity details){
        return detailsRepo.save(details);
    }

    public detailsEntity mapstudent(Long detailId,Long studentId){
        Optional<detailsEntity>details=detailsRepo.findById(detailId);
        Optional<studentEntity>student=studentRepo.findById(studentId);
        return details.flatMap(deatailtemp->student.map(studenttemp->{
            deatailtemp.setStudent(studenttemp);
            return detailsRepo.save(deatailtemp);
        })).orElse(null);
    }
}
