package com.airschool.apiairschool.services;

import com.airschool.apiairschool.model.Address;
import com.airschool.apiairschool.model.Employee;
import com.airschool.apiairschool.model.User;
import com.airschool.apiairschool.model.dto.EmployeeDTO;
import com.airschool.apiairschool.model.dto.EmployeeNewDTO;
import com.airschool.apiairschool.model.enums.EmployeeType;
import com.airschool.apiairschool.model.enums.Userperfil;
import com.airschool.apiairschool.repositories.AddressRepository;
import com.airschool.apiairschool.repositories.EmployeeRepository;
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

    }

    public List<Employee> findAllDirector() {

        return (List<Employee>) employeeRepository.findEmployeeByPerfis(EmployeeType.DIRECTOR.getId());
    }

    public Employee findByFunctionalNumber(Long functionalNumber) {
        Optional<Employee> obj = employeeRepository.findByFunctionalNumber(functionalNumber);
        return obj.orElseThrow(() -> new IllegalArgumentException());

    }


    public Employee insert(Employee obj) {
        obj.setId(null);
        userRepository.save(obj.getUser());
        obj.setFunctionalNumber(obj.functionalGenerator(employeeRepository.getLastFunctionalNumber()));
        obj = employeeRepository.save(obj);
        addressRepository.saveAll(obj.getAddress());

        return obj;
    }

    public Employee update(Employee obj) {

        obj = employeeRepository.save(obj);


        return obj;
    }

    public Employee activeOrDeactiveEmployee(Long functionalNumber, int status) {
        Employee obj = findByFunctionalNumber(functionalNumber);

        obj.setStatusActive((byte) status);

        obj = employeeRepository.save(obj);
        return obj;
    }

    public Employee fromDTOTeacher(EmployeeNewDTO objDto) {

        User user = new User(null, objDto.getLogin(), objDto.getEmail(), objDto.getPassword(), Userperfil.toEnum("Teacher"), (byte) 2);

        Employee employee = new Employee(null, objDto.getName(), objDto.getCpf(), objDto.getBirthDate(), objDto.getPhoto(), objDto.getPhoneNumber(), user, EmployeeType.toEnum("Teacher"), (byte) 1);

        Address address = new Address(null, objDto.getZipCode(), objDto.getNumber(), objDto.getComplement(), employee);

        employee.setAddress(Arrays.asList(address));

        return employee;
    }

    public Employee fromUpdateDTO(Employee employee, EmployeeDTO objDto) {

        if (objDto.getCpf() != null) {
            employee.setCpf(objDto.getCpf());
        }
        if (objDto.getBirthDate() != null) {
            employee.setBirthDate(objDto.getBirthDate());

        }
        if (objDto.getName() != null) {
            employee.setCpf(objDto.getName());

        }
        if (objDto.getPhoto() != null) {
            employee.setCpf(objDto.getPhoto());

        }


        return employee;
    }


}
