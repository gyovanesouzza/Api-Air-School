package com.airschool.apiairschool.services;

import com.airschool.apiairschool.model.Address;
import com.airschool.apiairschool.model.Employee;
import com.airschool.apiairschool.model.Student;
import com.airschool.apiairschool.model.User;
import com.airschool.apiairschool.model.dto.StudenteNewDTO;
import com.airschool.apiairschool.model.enums.EmployeeType;
import com.airschool.apiairschool.repositories.AddressRepository;
import com.airschool.apiairschool.repositories.EmployeeRepository;
import com.airschool.apiairschool.repositories.StudentRepository;
import com.airschool.apiairschool.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServices {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    UserRepository userRepository;

    public List<Employee> findAll() {

        return employeeRepository.findAll();
    }

    public List<Employee> findAllTeachers() {

        return (List<Employee>) employeeRepository.findEmployeeByPerfis(EmployeeType.TEACHER.getId());

    }  public List<Employee> findAllDirector() {

        return (List<Employee>) employeeRepository.findEmployeeByPerfis(EmployeeType.Director.getId());
    }

    public Employee findById(Integer id) {
        Optional<Employee> obj = employeeRepository.findById(id);
        return obj.orElseThrow(() -> new IllegalArgumentException());

    }


    public Employee insert(Employee obj) {
        obj.setId(null);
        userRepository.save(obj.getUser());
        obj = employeeRepository.save(obj);
        addressRepository.saveAll(obj.getAddress());

        return obj;
    }


}
