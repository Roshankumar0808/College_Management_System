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



    @ManyToMany
    @JoinTable(name = "Subject_Student" ,joinColumns = @JoinColumn(name="subject_id"),inverseJoinColumns = @JoinColumn(name="student_id"))
    @JsonIgnore
    private Set<studentEntity>studentSubject;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof subjectEntity that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getTitle(), that.getTitle()) && Objects.equals(getProfessor(), that.getProfessor()) && Objects.equals(getStudentSubject(), that.getStudentSubject());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getProfessor(), getStudentSubject());
    }
}
