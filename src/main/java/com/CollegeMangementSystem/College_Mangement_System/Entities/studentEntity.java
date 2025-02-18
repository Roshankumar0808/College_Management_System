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

@Table(name = "Student_Table")
public class studentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(nullable = false)
    private String name;


    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private detailsEntity details;

//    @ManyToMany(mappedBy = "studentEntities")
//    private Set<professorEntity> professorStudent;

    @ManyToMany(mappedBy = "studentSubject")
    private Set<subjectEntity>subjectstudent;

    @ManyToMany(mappedBy = "studentEntities")
    private Set<professorEntity> professorStudent = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof studentEntity that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getDetails(), that.getDetails()) && Objects.equals(getProfessorStudent(), that.getProfessorStudent()) && Objects.equals(getSubjectstudent(), that.getSubjectstudent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDetails(), getProfessorStudent(), getSubjectstudent());
    }
}
