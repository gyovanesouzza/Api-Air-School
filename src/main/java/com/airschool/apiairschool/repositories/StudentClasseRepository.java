package com.airschool.apiairschool.repositories;

import com.airschool.apiairschool.model.Student;
import com.airschool.apiairschool.model.StudentClasse;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.function.Function;

@Repository
public interface StudentClasseRepository extends JpaRepository<StudentClasse, Long> {

    @Query("SELECT sc FROM StudentClasse sc WHERE sc.primaryKey.student = :student")
    List<StudentClasse> findByStudent(@Param("student") Student student);
}