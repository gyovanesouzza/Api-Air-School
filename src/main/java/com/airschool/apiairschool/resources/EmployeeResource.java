package com.airschool.apiairschool.resources;

import com.airschool.apiairschool.model.Employee;
import com.airschool.apiairschool.model.dto.EmployeeDTO;
import com.airschool.apiairschool.model.dto.EmployeeNewDTO;
import com.airschool.apiairschool.services.EmployeeServices;
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

    @RequestMapping(value = "/{functionalNumber}", method = RequestMethod.GET)
    public ResponseEntity<Employee> findByID(@PathVariable Long functionalNumber) {
        Employee obj = employeeServices.findByFunctionalNumber(functionalNumber);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/teachers", method = RequestMethod.POST)
    public ResponseEntity<Void> insertTeacher(@RequestBody EmployeeNewDTO objDto) {
        Employee obj = employeeServices.fromDTOTeacher(objDto);
        obj = employeeServices.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{functionalNumber}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody EmployeeDTO objDto, @PathVariable Long functionalNumber) {
        Employee obj = employeeServices.findByFunctionalNumber(functionalNumber);
        obj = employeeServices.fromUpdateDTO(obj, objDto);
        obj.setFunctionalNumber(functionalNumber);
        obj = employeeServices.update(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/deactive/{functionalNumber}", method = RequestMethod.PUT)
    public ResponseEntity<Void> deactiveStudent(@PathVariable Long functionalNumber) {
        Employee obj = employeeServices.activeOrDeactiveEmployee(functionalNumber, 0);

        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/active/{functionalNumber}", method = RequestMethod.PUT)
    public ResponseEntity<Void> activeStudent(@PathVariable Long functionalNumber) {
        Employee obj = employeeServices.activeOrDeactiveEmployee(functionalNumber, 1);

        return ResponseEntity.noContent().build();
    }
}
