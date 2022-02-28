package com.airschool.apiairschool.resources;

import com.airschool.apiairschool.model.Student;
import com.airschool.apiairschool.model.User;
import com.airschool.apiairschool.model.dto.StudenteNewDTO;
import com.airschool.apiairschool.model.enums.Userperfil;
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


    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> findAll() {

        List<Student> objs = studentServices.findAll();
        return ResponseEntity.ok().body(objs);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Student> findByID(@PathVariable Integer id) {
        Student obj = studentServices.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "",method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody StudenteNewDTO objDto) {
        Student obj = studentServices.fromDTO(objDto);
        obj = studentServices.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


}
