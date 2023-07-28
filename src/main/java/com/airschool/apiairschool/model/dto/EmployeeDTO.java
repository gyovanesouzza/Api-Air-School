package com.airschool.apiairschool.model.dto;

import com.airschool.apiairschool.model.Address;
import com.airschool.apiairschool.model.Employee;
import com.airschool.apiairschool.model.User;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class EmployeeDTO implements Serializable {

    private String name;
    private String cpf;
    private Date birthDate;
    private String photo;
    private String phoneNumber;
    private String responsibility;


    private String zipCode;
    private String number;
    private String complement;

    private String login;
    private String email;
    private String password;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Employee employee) {
        this.name = employee.getName();
        this.cpf = employee.getCpf();
        this.birthDate = employee.getBirthDate();
        this.photo = employee.getPhoto();
        this.phoneNumber = employee.getPhoneNumber();

    }


}
