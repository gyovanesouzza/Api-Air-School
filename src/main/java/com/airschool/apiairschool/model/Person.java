package com.airschool.apiairschool.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")

@Getter
@Setter
@NoArgsConstructor
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String cpf;
    private Date birthDate;
    private String photo;
    private String phoneNumber;

    @JsonManagedReference
    @OneToMany(mappedBy="person", cascade=CascadeType.ALL)
    private List<Address> address = new ArrayList<>();

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Person(Integer id, String name, String cpf, Date birthDate, String photo, String phoneNumber, User user) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.photo = photo;
        this.phoneNumber = phoneNumber;
        this.user = user;
    }
}
