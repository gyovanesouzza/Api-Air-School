package com.airschool.apiairschool.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class StudentClasseId implements Serializable {
    private Student student;
    private Classe classe;

    @JsonManagedReference
    @ManyToOne(cascade = CascadeType.ALL)
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @JsonManagedReference
    @ManyToOne(cascade = CascadeType.ALL)
    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }
}
