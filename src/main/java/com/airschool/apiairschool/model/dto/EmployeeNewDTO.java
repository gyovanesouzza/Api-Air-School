package com.airschool.apiairschool.model.dto;

import com.airschool.apiairschool.model.Address;
import com.airschool.apiairschool.model.Employee;
import com.airschool.apiairschool.model.Student;
import com.airschool.apiairschool.model.User;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class EmployeeNewDTO implements Serializable {

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

    public EmployeeNewDTO() {
    }

    public EmployeeNewDTO(Employee employee, Address address , User user) {
        this.name = employee.getName();
        this.cpf = employee.getCpf();
        this.birthDate = employee.getBirthDate();
        this.photo = employee.getPhoto();
        this.phoneNumber = employee.getPhoneNumber();
        this.zipCode = address.getZipCode();
        this.number = address.getNumber();
        this.complement = address.getComplement();
        this.login = user.getLogin();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }


}
