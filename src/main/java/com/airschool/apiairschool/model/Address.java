package com.airschool.apiairschool.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String zipCode;
    private String number;
    private String complement;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="person_id")
    private Person person;


    public Address(Integer id, String zipCode, String number, String complement, Person person) {
        this.id = id;
        this.zipCode = zipCode;
        this.number = number;
        this.complement = complement;
        this.person = person;
    }
}
