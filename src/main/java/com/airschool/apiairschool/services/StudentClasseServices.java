package com.airschool.apiairschool.services;

import com.airschool.apiairschool.model.Classe;
import com.airschool.apiairschool.model.Student;
import com.airschool.apiairschool.model.StudentClasse;
import com.airschool.apiairschool.repositories.ClasseRepository;
import com.airschool.apiairschool.repositories.StudentClasseRepository;
import com.airschool.apiairschool.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StudentClasseServices {

    @Autowired
    StudentClasseRepository studentClasseRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ClasseRepository classeRepository;

    public void addStudentClass(Long studentRegistration, int id_class) {
        Student student = studentRepository.findStudentsByStudentRegistration(studentRegistration).orElseThrow(() -> new IllegalArgumentException());
        Classe classe = classeRepository.findById(id_class).orElseThrow(() -> new IllegalArgumentException());

        List<StudentClasse> studentClasses = listClassByStudent(student);
        StudentClasse studentClasse = new StudentClasse();
        studentClasse.setStudent(student);
        studentClasse.setClasse(classe);
        studentClasse.setRegisteredDate(new Date());
        studentClasse.setActivated(true);

        studentClasses.forEach(classeOfStudent -> {
            classeOfStudent.setActivated(false);
            studentClasseRepository.save(classeOfStudent);
        });
        studentClasseRepository.save(studentClasse);


    }

    public List<StudentClasse> listClassByStudent(Student student) {
        return studentClasseRepository.findByStudent(student);
    }
}
