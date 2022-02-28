package com.airschool.apiairschool;

import com.airschool.apiairschool.model.Student;
import com.airschool.apiairschool.model.User;
import com.airschool.apiairschool.model.enums.Userperfil;
import com.airschool.apiairschool.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class ApiAirSchoolApplication implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;


    public static void main(String[] args) {
        SpringApplication.run(ApiAirSchoolApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        Student s1 = new Student();
        s1.setId(1);
        s1.setCpf("123344");
        s1.setStudentRegistration(1234568910L);
        s1.setName("Gyovane");

        Student s2 = new Student();
        s2.setId(2);
        s2.setCpf("123144");
        s2.setStudentRegistration(13234568910L);
        s2.setName("Lucas");

        studentRepository.save(s1);
        studentRepository.save(s2);
    }
}
