package com.airschool.apiairschool.model;

import com.airschool.apiairschool.model.enums.EmployeeType;
import com.airschool.apiairschool.model.enums.Userperfil;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


@Entity
@JsonTypeName("employee")
@Getter
@Setter
@NoArgsConstructor
public class Employee extends Person {

    @NotNull
    @Column(unique = true)
    private Long functionalNumber;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "PERFIS_EMPLOYEE")
    private Set<Integer> perfis = new HashSet<>();

    public Employee(Integer id, String name, String cpf, Date birthDate, String photo, String phoneNumber, User user, Long functionalNumber, EmployeeType perfis) {
        super(id, name, cpf, birthDate, photo, phoneNumber, user);
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