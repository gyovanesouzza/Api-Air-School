package com.airschool.apiairschool.resources;

import com.airschool.apiairschool.model.Employee;
import com.airschool.apiairschool.model.Student;
import com.airschool.apiairschool.model.dto.StudenteNewDTO;
import com.airschool.apiairschool.services.EmployeeServices;
import com.airschool.apiairschool.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeResource {

    @Autowired
    EmployeeServices employeeServices;


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> findAll() {

        List<Employee> objs = employeeServices.findAll();
        return ResponseEntity.ok().body(objs);
    }
    @RequestMapping(value = "/teachers", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> findAllTeachers() {

        List<Employee> objs = employeeServices.findAllTeachers();
        return ResponseEntity.ok().body(objs);
    }
    @RequestMapping(value = "/director", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> findAllDirector() {

        List<Employee> objs = employeeServices.findAllDirector();
        return ResponseEntity.ok().body(objs);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Employee> findByID(@PathVariable Integer id) {
        Employee obj = employeeServices.findById(id);
        return ResponseEntity.ok().body(obj);
    }



}
