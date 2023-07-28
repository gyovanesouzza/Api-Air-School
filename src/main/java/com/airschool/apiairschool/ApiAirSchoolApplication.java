package com.airschool.apiairschool;

import com.airschool.apiairschool.model.Employee;
import com.airschool.apiairschool.model.Student;
import com.airschool.apiairschool.model.User;
import com.airschool.apiairschool.model.enums.EmployeeType;
import com.airschool.apiairschool.model.enums.Userperfil;
import com.airschool.apiairschool.repositories.EmployeeRepository;
import com.airschool.apiairschool.repositories.StudentRepository;
import com.airschool.apiairschool.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class ApiAirSchoolApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmployeeRepository employeeRepository;


    public static void main(String[] args) {
        SpringApplication.run(ApiAirSchoolApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        User u1 = new User(null, "prof", "prof@g", "33kff", Userperfil.TEACHER);
//        Employee e1 = new Employee(null, "Pro", "22", null, "", "", u1, 121332L, EmployeeType.TEACHER);
//        u1.setPerson(e1);
//
//        userRepository.save(u1);
//        employeeRepository.save(e1);

    }
}
