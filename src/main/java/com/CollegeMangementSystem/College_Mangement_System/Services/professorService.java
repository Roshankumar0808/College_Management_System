package com.CollegeMangementSystem.College_Mangement_System.Services;

import com.CollegeMangementSystem.College_Mangement_System.Entities.professorEntity;
import com.CollegeMangementSystem.College_Mangement_System.Entities.studentEntity;
import com.CollegeMangementSystem.College_Mangement_System.Entities.subjectEntity;
import com.CollegeMangementSystem.College_Mangement_System.Repositories.detailsRepo;
import com.CollegeMangementSystem.College_Mangement_System.Repositories.professorRepo;
import com.CollegeMangementSystem.College_Mangement_System.Repositories.studentRepo;
import com.CollegeMangementSystem.College_Mangement_System.Repositories.subjectRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class professorService {
    private detailsRepo detailsRepo;
    private professorRepo professorRepo;
    private studentRepo studentRepo;
    private subjectRepo subjectRepo;

    public professorService(com.CollegeMangementSystem.College_Mangement_System.Repositories.detailsRepo detailsRepo, com.CollegeMangementSystem.College_Mangement_System.Repositories.professorRepo professorRepo, com.CollegeMangementSystem.College_Mangement_System.Repositories.studentRepo studentRepo, com.CollegeMangementSystem.College_Mangement_System.Repositories.subjectRepo subjectRepo) {
        this.detailsRepo = detailsRepo;
        this.professorRepo = professorRepo;
        this.studentRepo = studentRepo;
        this.subjectRepo = subjectRepo;
    }

  public List<professorEntity> getAllprofessor(){
        List<professorEntity> allprofessors=professorRepo.findAll();
        return allprofessors;
  }
  public professorEntity getProfessorById(Long ProfId){
        return professorRepo.findById(ProfId).orElse(null);
  }

  public professorEntity createProfessor(professorEntity professor){
        return professorRepo.save(professor);
  }

  public professorEntity assignSubjectToProfessor(Long professorId,Long subjectId){
      Optional<professorEntity>professor=professorRepo.findById(professorId);
      Optional<subjectEntity>subject=subjectRepo.findById(subjectId);
      return professor.flatMap(prof->subject.map(subjectexmpl->{
            subjectexmpl.setProfessor(prof);
            subjectRepo.save(subjectexmpl);
            prof.getSubjectEntityset().add(subjectexmpl);

            return prof;
      })).orElse(null);
  }

    public professorEntity assignStudentToProfessor(Long professorId,Long studentId){
        Optional<professorEntity>professor=professorRepo.findById(professorId);
        Optional<studentEntity>student=studentRepo.findById(studentId);
        return professor.flatMap(prof->student.map(studentexmpl->{
            studentexmpl.getProfessorStudent().add(prof);
            studentRepo.save(studentexmpl);
              prof.getStudentEntities().add(studentexmpl);
               professorRepo.save(prof);
            return prof;
        })).orElse(null
        );
    }



}
