package com.CollegeMangementSystem.College_Mangement_System.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
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
//
//    @ManyToMany
//    @JoinTable(name = "Professor_Table" ,joinColumns = @JoinColumn(name="professor_id"),inverseJoinColumns = @JoinColumn(name="student_id"))
//    @JsonIgnore
//    private Set<studentEntity>studentEntities;
@ManyToMany
@JoinTable(
        name = "professor_student",
        joinColumns = @JoinColumn(name = "professor_id"),
        inverseJoinColumns = @JoinColumn(name = "student_id")
)
@JsonIgnore
private Set<studentEntity> studentEntities ;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof professorEntity that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getTitle(), that.getTitle()) && Objects.equals(getSubjectEntityset(), that.getSubjectEntityset()) && Objects.equals(getStudentEntities(), that.getStudentEntities());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getSubjectEntityset(), getStudentEntities());
    }
}

