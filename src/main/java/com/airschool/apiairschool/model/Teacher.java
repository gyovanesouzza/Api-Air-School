package com.airschool.apiairschool.model;


import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@JsonTypeName("teacher")
@Getter
@Setter
@NoArgsConstructor
public class Teacher extends Person {

    @NotNull
    @Column(unique=true)
    private Long functionalNumber;

}
