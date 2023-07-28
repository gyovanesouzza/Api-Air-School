package com.airschool.apiairschool.model;

import com.airschool.apiairschool.model.enums.ClasseType;
import com.airschool.apiairschool.model.enums.EmployeeType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Classe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private char letter;
    private Integer yearClasse;
    private String year;

    @Enumerated(EnumType.STRING)
    @Column(name="classeType")
    private ClasseType type;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime registeredDate;
    @JsonBackReference
    @OneToMany(mappedBy = "primaryKey.classe",
            cascade = CascadeType.ALL)
    private Set<StudentClasse> studentClasses = new HashSet<StudentClasse>();


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coordinatingTeacher_id", unique = true)
    private Employee coordinatingTeacher;

    @JsonIgnore
    @OneToMany(mappedBy = "classe")
    private Set<Grade> grades;

    public Classe() {
    }

    public Classe(Integer id, char letter, Integer yearClasse, String year, ClasseType type) {
        this.id = id;
        this.letter = letter;
        this.yearClasse = yearClasse;
        this.year = year;
        this.type = type;
    }
    public Classe(char letter, Integer yearClasse, String year, ClasseType type) {
        this.letter = letter;
        this.yearClasse = yearClasse;
        this.year = year;
        this.type = type;
    }
    public void addGroup(StudentClasse classe) {
        this.studentClasses.add(classe);
    }


    public Set<StudentClasse> getStudentClasse() {
        return studentClasses;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public Integer getYearClasse() {
        return yearClasse;
    }

    public void setYearClasse(Integer year) {
        this.yearClasse = year;
    }

    public String getSchoolYear() {
        return year;
    }

    public void setSchoolYear(String year) {
        this.year = year;
    }

    public Employee getCoordinatingTeacher() {
        return coordinatingTeacher;
    }

    public void setCoordinatingTeacher(Employee coordinatingTeacher) {
        this.coordinatingTeacher = coordinatingTeacher;
    }

    public Set<Grade> getGrades() {
        return grades;
    }

    public void setGrades(Set<Grade> grades) {
        this.grades = grades;
    }

    @Temporal(TemporalType.DATE)
    public LocalDateTime getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(LocalDateTime registeredDate) {
        this.registeredDate = registeredDate;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public ClasseType getType() {
        return type;
    }

    public void setType(ClasseType type) {
        this.type = type;
    }
}
