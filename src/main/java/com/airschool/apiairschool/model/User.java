package com.airschool.apiairschool.model;

import com.airschool.apiairschool.model.enums.Userperfil;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String login;
    private String email;
    private String password;

    @JsonBackReference
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private Person person;
    public User(Integer id, String login, String email, String password) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.password = password;
        addPerfil(Userperfil.STUDENT);

    }

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "PERFIS_USER")
    private Set<Integer> perfis = new HashSet<>();


    public Set<Userperfil> getPerfis() {
        return perfis.stream().map(x -> Userperfil.toEnum(x)).collect(Collectors.toSet());
    }

    public void addPerfil(Userperfil userperfil) {
        perfis.add(userperfil.getId());
    }

}
