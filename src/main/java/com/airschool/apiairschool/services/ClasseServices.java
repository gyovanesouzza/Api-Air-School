package com.airschool.apiairschool.services;

import com.airschool.apiairschool.model.Classe;
import com.airschool.apiairschool.model.dto.ClasseNewDTO;
import com.airschool.apiairschool.model.enums.ClasseType;
import com.airschool.apiairschool.repositories.ClasseRepository;
import com.airschool.apiairschool.repositories.EmployeeRepository;
import com.airschool.apiairschool.services.exceptions.ObjectDuplicateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClasseServices {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ClasseRepository classeRepository;

    public List<Classe> findAll() {
        return classeRepository.findAll();
    }

    public Classe findById(int id) {
        Optional<Classe> obj = classeRepository.findById(id);
        return obj.orElseThrow(() -> new IllegalArgumentException());
    }

    public Classe fromDTO(ClasseNewDTO objDto) {
        return new Classe(objDto.getLetter(), objDto.getYearClasse(), objDto.getYear(), ClasseType.toEnum(objDto.getType()));
    }

    public Classe insert(Classe obj) {
        Optional<Classe> classe = classeRepository.findByLetterIsAndYearClasseIsAndYearIs(obj.getLetter(), obj.getYearClasse(), obj.getYear());
        if(!classe.isEmpty()){
            throw new ObjectDuplicateException("Class already exists");
        }

        return classeRepository.save(obj);
    }
}
