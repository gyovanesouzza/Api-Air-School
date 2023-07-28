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
public class StudenteUpdateDTO implements Serializable {

    private String name;
    private String cpf;
    private Date birthDate;
    private String photo;
    private String phoneNumber;


    public StudenteUpdateDTO() {
    }

    public StudenteUpdateDTO(Student student, Address address , User user) {
        this.name = student.getName();
        this.cpf = student.getCpf();
        this.birthDate = student.getBirthDate();
        this.photo = student.getPhoto();
        this.phoneNumber = student.getPhoneNumber();
    }


}
