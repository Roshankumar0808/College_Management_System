package com.CollegeMangementSystem.College_Mangement_System.Services;

import com.CollegeMangementSystem.College_Mangement_System.Entities.subjectEntity;
import com.CollegeMangementSystem.College_Mangement_System.Repositories.detailsRepo;
import com.CollegeMangementSystem.College_Mangement_System.Repositories.professorRepo;
import com.CollegeMangementSystem.College_Mangement_System.Repositories.studentRepo;
import com.CollegeMangementSystem.College_Mangement_System.Repositories.subjectRepo;
import org.springframework.stereotype.Service;

@Service
public class subjectService {
  private final professorRepo professorRepo;
  private final studentRepo studentRepo;
  private final subjectRepo subjectRepo;
  private final detailsRepo detailsRepo;

    public subjectService(com.CollegeMangementSystem.College_Mangement_System.Repositories.professorRepo professorRepo, com.CollegeMangementSystem.College_Mangement_System.Repositories.studentRepo studentRepo, com.CollegeMangementSystem.College_Mangement_System.Repositories.subjectRepo subjectRepo, com.CollegeMangementSystem.College_Mangement_System.Repositories.detailsRepo detailsRepo) {
        this.professorRepo = professorRepo;
        this.studentRepo = studentRepo;
        this.subjectRepo = subjectRepo;
        this.detailsRepo = detailsRepo;
    }

   public subjectEntity getSubjectById(Long subjectId){
        return subjectRepo.findById(subjectId).orElse(null);
   }
    public subjectEntity createSubject(subjectEntity subject) {
        return subjectRepo.save(subject);
    }
}
