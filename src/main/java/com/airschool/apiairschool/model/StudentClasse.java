package com.airschool.apiairschool.model;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "STUDENT_CLASSE")
@AssociationOverrides({
        @AssociationOverride(name = "primaryKey.student",
                joinColumns = @JoinColumn(name = "STUDENT_ID")),
        @AssociationOverride(name = "primaryKey.classe",
                joinColumns = @JoinColumn(name = "CLASSE_ID"))})
public class StudentClasse implements Serializable {
    @EmbeddedId
    private StudentClasseId primaryKey = new StudentClasseId();
    private boolean activated;
    private Date registeredDate;

    public StudentClasse(StudentClasseId primaryKey) {
        this.primaryKey = primaryKey;
    }
    public StudentClasse() {

    }

    @EmbeddedId
    public StudentClasseId getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(StudentClasseId primaryKey) {
        this.primaryKey = primaryKey;
    }

    @Transient
    public Student getStudent() {
        return getPrimaryKey().getStudent();
    }

    public void setStudent(Student student) {
        getPrimaryKey().setStudent(student);
    }

    @Transient
    public Classe getClasse() {
        return getPrimaryKey().getClasse();
    }

    public void setClasse(Classe classe) {
        getPrimaryKey().setClasse(classe);
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }


    @Column(name = "REGISTERED_DATE")
    @Temporal(TemporalType.DATE)
    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }
}
