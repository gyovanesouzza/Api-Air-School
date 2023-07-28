package com.airschool.apiairschool.resources;


import com.airschool.apiairschool.model.Classe;
import com.airschool.apiairschool.model.dto.ClasseNewDTO;
import com.airschool.apiairschool.services.ClasseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/classe")
public class ClasseResource {

    @Autowired
    ClasseServices classeServices;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Classe>> findAll() {

        List<Classe> objs = classeServices.findAll();
        return ResponseEntity.ok().body(objs);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Classe> findByID(@PathVariable int id) {
        Classe obj = classeServices.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody ClasseNewDTO objDto) {
        Classe classe = classeServices.fromDTO(objDto);
        classe.setRegisteredDate(LocalDateTime.now());
        classe = classeServices.insert(classe);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(classe.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }



}
