package com.CollegeMangementSystem.College_Mangement_System.Repositories;

import com.CollegeMangementSystem.College_Mangement_System.Entities.detailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface detailsRepo extends JpaRepository<detailsEntity,Long> {
}
