package com.airschool.apiairschool.resources;

import com.airschool.apiairschool.model.Student;
import com.airschool.apiairschool.model.dto.StudenteNewDTO;
import com.airschool.apiairschool.model.dto.StudenteUpdateDTO;
import com.airschool.apiairschool.services.StudentClasseServices;
import com.airschool.apiairschool.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/students")
public class StudentResource {

    @Autowired
    StudentServices studentServices;

    @Autowired
    StudentClasseServices studentClasseServices;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> findAll() {

        List<Student> objs = studentServices.findAll();
        return ResponseEntity.ok().body(objs);
    }

    @RequestMapping(value = "/{studentRegistration}", method = RequestMethod.GET)
    public ResponseEntity<Student> findByStudentRegistration(@PathVariable Long studentRegistration) {
        Student obj = studentServices.findByStudentRegistration(studentRegistration);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody StudenteNewDTO objDto) {
        Student obj = studentServices.fromDTO(objDto);
        obj = studentServices.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{studentRegistration}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody StudenteUpdateDTO objDto, @PathVariable Long studentRegistration) {
        Student obj = studentServices.findByStudentRegistration(studentRegistration);
        obj = studentServices.fromDTO(obj, objDto);
        obj.setStudentRegistration(studentRegistration);
        obj = studentServices.update(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/deactive/{studentRegistration}", method = RequestMethod.PUT)
    public ResponseEntity<Void> deactiveStudent(@PathVariable Long studentRegistration) {
        Student obj = studentServices.activeOrDeactiveStudent(studentRegistration, 0);

        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/active/{studentRegistration}", method = RequestMethod.PUT)
    public ResponseEntity<Void> activeStudent(@PathVariable Long studentRegistration) {
        Student obj = studentServices.activeOrDeactiveStudent(studentRegistration, 1);

        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/add_classe/{studentRegistration}/{id_class}", method = RequestMethod.GET)
    public ResponseEntity<Void> add_student_class(@PathVariable Long studentRegistration, @PathVariable int id_class) {
        studentClasseServices.addStudentClass(studentRegistration, id_class);

        return ResponseEntity.noContent().build();
    }

}
