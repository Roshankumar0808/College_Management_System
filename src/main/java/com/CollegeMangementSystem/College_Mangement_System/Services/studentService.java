package com.CollegeMangementSystem.College_Mangement_System.Services;

import com.CollegeMangementSystem.College_Mangement_System.Entities.studentEntity;
import com.CollegeMangementSystem.College_Mangement_System.Entities.subjectEntity;
import com.CollegeMangementSystem.College_Mangement_System.Repositories.detailsRepo;
import com.CollegeMangementSystem.College_Mangement_System.Repositories.professorRepo;
import com.CollegeMangementSystem.College_Mangement_System.Repositories.studentRepo;
import com.CollegeMangementSystem.College_Mangement_System.Repositories.subjectRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class studentService {
    private final detailsRepo detailsRepo;
    private final studentRepo studentRepo;
    private final subjectRepo subjectRepo;
    private final professorRepo professorRepo;

    public studentService(com.CollegeMangementSystem.College_Mangement_System.Repositories.detailsRepo detailsRepo, com.CollegeMangementSystem.College_Mangement_System.Repositories.studentRepo studentRepo, com.CollegeMangementSystem.College_Mangement_System.Repositories.subjectRepo subjectRepo, com.CollegeMangementSystem.College_Mangement_System.Repositories.professorRepo professorRepo) {
        this.detailsRepo = detailsRepo;
        this.studentRepo = studentRepo;
        this.subjectRepo = subjectRepo;
        this.professorRepo = professorRepo;
    }

    public studentEntity getstudentById(Long studentId){
        return studentRepo.findById(studentId).orElse(null);
    }

    public studentEntity createStudent(studentEntity student){
        return studentRepo.save(student);
    }

    public studentEntity assignSubjectToStudent(@PathVariable Long subjectId, @PathVariable Long studentId){
        Optional<studentEntity>student=studentRepo.findById(studentId);
        Optional<subjectEntity>subject=subjectRepo.findById(subjectId);
        return student.flatMap(studenttemp->subject.map(subjecttemp->{
            subjecttemp.getStudentSubject().add(studenttemp);
            subjectRepo.save(subjecttemp);
            studenttemp.getSubjectstudent().add(subjecttemp);
            return studenttemp;
        })).orElse(null);

    }
}
