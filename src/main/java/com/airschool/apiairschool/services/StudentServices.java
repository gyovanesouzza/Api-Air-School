package com.airschool.apiairschool.services;

import com.airschool.apiairschool.model.Address;
import com.airschool.apiairschool.model.Student;
import com.airschool.apiairschool.model.User;
import com.airschool.apiairschool.model.dto.StudenteNewDTO;
import com.airschool.apiairschool.model.enums.Userperfil;
import com.airschool.apiairschool.repositories.AddressRepository;
import com.airschool.apiairschool.repositories.StudentRepository;
import com.airschool.apiairschool.repositories.UserRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServices {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    UserRepository userRepository;

    public List<Student> findAll() {

        return (List<Student>) studentRepository.findAll();
    }

    public Student findById(Integer id) {
        Optional<Student> obj = studentRepository.findById(id);
        return obj.orElseThrow(() -> new IllegalArgumentException());

    }


    public Student insert(Student obj) {
        obj.setId(null);
        userRepository.save(obj.getUser());
        obj = studentRepository.save(obj);
        addressRepository.saveAll(obj.getAddress());

        return obj;
    }

    public Student fromDTO(StudenteNewDTO objDto) {

        User user = new User(null, objDto.getLogin(),objDto.getEmail(), objDto.getPassword());

        Student student = new Student(null, objDto.getName(), objDto.getCpf(), objDto.getBirthDate(), objDto.getPhoto(), objDto.getPhoneNumber(), user, objDto.getStudentRegistration());

        Address address = new Address(null, objDto.getZipCode(), objDto.getNumber(), objDto.getComplement(),student);

        student.setAddress(Arrays.asList(address));

        return student;
    }
}
