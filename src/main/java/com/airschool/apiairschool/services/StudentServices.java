package com.airschool.apiairschool.services;

import com.airschool.apiairschool.model.Address;
import com.airschool.apiairschool.model.Classe;
import com.airschool.apiairschool.model.Student;
import com.airschool.apiairschool.model.User;
import com.airschool.apiairschool.model.dto.StudenteNewDTO;
import com.airschool.apiairschool.model.dto.StudenteUpdateDTO;
import com.airschool.apiairschool.model.enums.Userperfil;
import com.airschool.apiairschool.repositories.AddressRepository;
import com.airschool.apiairschool.repositories.ClasseRepository;
import com.airschool.apiairschool.repositories.StudentRepository;
import com.airschool.apiairschool.repositories.UserRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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

    @Autowired
    ClasseRepository classeRepository;
    public List<Student> findAll() {

        return (List<Student>) studentRepository.findAll();
    }

    public Student findByStudentRegistration(Long studentRegistration) {
        Optional<Student> obj = studentRepository.findStudentsByStudentRegistration(studentRegistration);
        return obj.orElseThrow(() -> new ObjectNotFoundException("null", "null"));
    }

    public Student insert(Student obj) {
        obj.setId(null);
        userRepository.save(obj.getUser());
        obj = studentRepository.save(obj);
        addressRepository.saveAll(obj.getAddress());

        return obj;
    }

    public Student update(Student obj) {
        obj = studentRepository.save(obj);
        addressRepository.saveAll(obj.getAddress());

        return obj;
    }

    public Student activeOrDeactiveStudent(Long studentRegistration, int status) {
        Student obj = findByStudentRegistration(studentRegistration);
        obj.setStatusActive((byte) status);
        obj = studentRepository.save(obj);
        return obj;

    }

    public Student add_student_class(Long studentRegistration, int id_class) {
        Student obj = findByStudentRegistration(studentRegistration);
        Classe classe = classeRepository.findById(id_class).orElseThrow(() -> new IllegalArgumentException());

        return studentRepository.save(obj);
    }

    public Student fromDTO(StudenteNewDTO objDto) {

        User user = new User(null, objDto.getLogin(), objDto.getEmail(), objDto.getPassword(), Userperfil.STUDENT, (byte) 1);

        Student student = new Student(null, objDto.getName(), objDto.getCpf(), objDto.getBirthDate(), objDto.getPhoto(), objDto.getPhoneNumber(), user, objDto.getStudentRegistration(), (byte) 1);

        Address address = new Address(null, objDto.getZipCode(), objDto.getNumber(), objDto.getComplement(), student);

        student.setAddress(Arrays.asList(address));

        return student;
    }

    public Student fromDTO(StudenteUpdateDTO objDto) {
        Student student = new Student(null, objDto.getName(), objDto.getCpf(), objDto.getBirthDate(), objDto.getPhoto(), objDto.getPhoneNumber(), (byte) 1);

        return student;
    }

    public Student fromDTO(Student obj, StudenteUpdateDTO objDto) {
        if (objDto.getName() != null) {
            obj.setName(objDto.getName());
        }
        if (objDto.getCpf() != null) {
            obj.setCpf(objDto.getCpf());
        }
        if (objDto.getBirthDate() != null) {
            obj.setBirthDate(objDto.getBirthDate());
        }
        if (objDto.getPhoto() != null) {
            obj.setPhoto(objDto.getPhoto());
        }
        if (objDto.getPhoneNumber() != null) {
            obj.setPhoneNumber(objDto.getPhoto());
        }


        return obj;

    }



}
