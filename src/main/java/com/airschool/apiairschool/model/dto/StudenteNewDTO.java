package com.airschool.apiairschool.model.dto;

import com.airschool.apiairschool.model.Address;
import com.airschool.apiairschool.model.Student;
import com.airschool.apiairschool.model.User;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class StudenteNewDTO implements Serializable {

    private Long studentRegistration;
    private String name;
    private String cpf;
    private Date birthDate;
    private String photo;
    private String phoneNumber;


    private String zipCode;
    private String number;
    private String complement;

    private String login;
    private String email;
    private String password;

    public StudenteNewDTO() {
    }

    public StudenteNewDTO(Student student, Address address , User user) {
        this.studentRegistration = student.getStudentRegistration();
        this.name = student.getName();
        this.cpf = student.getCpf();
        this.birthDate = student.getBirthDate();
        this.photo = student.getPhoto();
        this.phoneNumber = student.getPhoneNumber();
        this.zipCode = address.getZipCode();
        this.number = address.getNumber();
        this.complement = address.getComplement();
        this.login = user.getLogin();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }


}
