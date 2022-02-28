package com.airschool.apiairschool.model;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@JsonTypeName("student")
@Getter
@Setter
@NoArgsConstructor
public class Student extends Person {

    @NotNull
    @Column(unique=true)
    private Long studentRegistration;


    public Student(Integer id, String name, String cpf, Date birthDate, String photo, String phoneNumber, User user, Long studentRegistration) {
        super(id, name, cpf, birthDate, photo, phoneNumber, user);
        this.studentRegistration = studentRegistration;
    }
}

