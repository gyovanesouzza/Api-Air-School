package com.airschool.apiairschool.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@JsonTypeName("student")
@NoArgsConstructor
public class Student extends Person implements Serializable {

    @NotNull
    @Column(unique=true)
    private Long studentRegistration;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },mappedBy = "students")
    private Set<Activity> activities;


    @JsonBackReference
    @OneToMany(mappedBy = "primaryKey.student",
            cascade = CascadeType.ALL)
    private Set<StudentClasse> studentClasses = new HashSet<StudentClasse>();


    public Student(Integer id, String name, String cpf, Date birthDate, String photo, String phoneNumber, User user, Long studentRegistration,byte statusActive) {
        super(id, name, cpf, birthDate, photo, phoneNumber, user,statusActive);
        this.studentRegistration = studentRegistration;
    }

    public Student(Integer id, String name, String cpf, Date birthDate, String photo, String phoneNumber,byte statusActive) {
        super(id, name, cpf, birthDate, photo, phoneNumber,statusActive);
    }


    public void addGroup(StudentClasse classe) {
        this.studentClasses.add(classe);
    }


    public Set<StudentClasse> getStudentClasse() {
        return studentClasses;
    }

    public Long getStudentRegistration() {
        return studentRegistration;
    }

    public void setStudentRegistration(Long studentRegistration) {
        this.studentRegistration = studentRegistration;
    }

    public Set<Activity> getActivities() {
        return activities;
    }

    public void setActivities(Set<Activity> activities) {
        this.activities = activities;
    }
}

