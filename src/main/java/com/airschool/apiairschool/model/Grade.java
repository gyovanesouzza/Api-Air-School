package com.airschool.apiairschool.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "DAYOFWEEK")
    private Set<Integer> dayOfWeek = new HashSet<>();

    @JoinColumn(name = "Teacher_id", unique = true)
    @OneToOne(cascade = CascadeType.ALL)
    private Employee Teacher;

    @ManyToOne(fetch = FetchType.LAZY)
    private Classe classe;


}
