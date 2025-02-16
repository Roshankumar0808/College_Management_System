package com.CollegeMangementSystem.College_Mangement_System.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "Subject_Table")
public class subjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="professor_id",referencedColumnName = "id")
    @JsonIgnore
    private professorEntity professor;

    @ManyToMany(mappedBy = "subjectEntities")
    private Set<professorEntity> professorEntitySet;



}
