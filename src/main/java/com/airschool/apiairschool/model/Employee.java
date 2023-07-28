package com.airschool.apiairschool.model;

import com.airschool.apiairschool.model.enums.EmployeeType;
import com.airschool.apiairschool.model.enums.Userperfil;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


@Entity
@JsonTypeName("employee")
@Getter
@Setter
@NoArgsConstructor
public class Employee extends Person implements Serializable {

    @NotNull
    @Column(unique = true)
    private Long functionalNumber;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }, mappedBy = "teachers")
    private Set<Activity> activities;

    @JsonIgnore
    @OneToMany( mappedBy = "coordinatingTeacher",
            cascade = CascadeType.ALL)
    private Set<Classe> coordinationRooms;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "PERFIS_EMPLOYEE")
    private Set<Integer> perfis = new HashSet<>();

    public Employee(Integer id, String name, String cpf, Date birthDate, String photo, String phoneNumber, User user, Long functionalNumber, EmployeeType perfis, byte statusActive) {
        super(id, name, cpf, birthDate, photo, phoneNumber, user, statusActive);
        this.functionalNumber = functionalNumber;
        addPerfil(perfis);
    }

    public Set<EmployeeType> getPerfis() {
        return perfis.stream().map(x -> EmployeeType.toEnum(x)).collect(Collectors.toSet());
    }

    public void addPerfil(EmployeeType employeeType) {
        perfis.add(employeeType.getId());
    }
}