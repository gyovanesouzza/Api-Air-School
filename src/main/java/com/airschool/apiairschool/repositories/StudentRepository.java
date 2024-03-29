package com.airschool.apiairschool.repositories;

import com.airschool.apiairschool.model.Student;
import io.swagger.models.auth.In;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

Optional<Student> findStudentsByStudentRegistration(Long studentRegistration);

}