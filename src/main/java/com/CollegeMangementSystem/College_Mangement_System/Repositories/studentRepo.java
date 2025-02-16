package com.CollegeMangementSystem.College_Mangement_System.Repositories;

import com.CollegeMangementSystem.College_Mangement_System.Entities.studentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface studentRepo extends JpaRepository<studentEntity,Long> {
}
