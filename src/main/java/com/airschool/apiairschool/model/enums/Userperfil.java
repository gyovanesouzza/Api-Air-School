package com.airschool.apiairschool.model.enums;

import lombok.Getter;

@Getter
public enum Userperfil {

    STUDENT(1, "Student"),
    TEACHER(2, "Teacher"),
    Director(3, "Director");

    private int id;
    private String description;

    Userperfil(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public static Userperfil  toEnum(Integer id) {

        if (id == null) {
            return null;
        }

        for (Userperfil x : Userperfil.values()) {
            if (id.equals(x.getId())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + id);
    }
    public static Userperfil  toEnum(String type) {

        if (type == null) {
            return null;
        }

        for (Userperfil x : Userperfil.values()) {
            if (type.equals(x.getDescription())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Type inválido: " + type);
    }
}
