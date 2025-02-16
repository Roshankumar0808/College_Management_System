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

@Table(name = "Professor_Table")
public class professorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @OneToMany(mappedBy = "professor")
    private Set<subjectEntity> subjectEntityset;

    @ManyToMany
    @JoinTable(name = "Professor_Table" ,joinColumns = @JoinColumn(name="professor_id"),inverseJoinColumns = @JoinColumn(name="subject_id"))
    @JsonIgnore
    private Set<subjectEntity>subjectEntities;

    }

