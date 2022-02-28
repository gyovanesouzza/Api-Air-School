package com.airschool.apiairschool.model.enums;

import lombok.Getter;

@Getter
public enum EmployeeType {

    TEACHER(1, "Teacher"),
    Director(2, "Director");

    private int id;
    private String description;

    private EmployeeType(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public static EmployeeType toEnum(Integer id) {

        if (id == null) {
            return null;
        }

        for (EmployeeType x : EmployeeType.values()) {
            if (id.equals(x.getId())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + id);
    }
}
