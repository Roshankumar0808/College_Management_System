package com.CollegeMangementSystem.College_Mangement_System.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Details_Table")
@Data
public class detailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double fees;

    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    @JsonIgnore
    private studentEntity student;


}
