package com.airschool.apiairschool.repositories;

import com.airschool.apiairschool.model.Classe;
import com.airschool.apiairschool.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Integer> {

    Optional<Classe> findByLetterIsAndYearClasseIsAndYearIs(char letter, Integer year_class, String year);
}