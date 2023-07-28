package com.airschool.apiairschool.model.enums;

import lombok.Getter;

@Getter
public enum DayOfWeek {

    Monday(1, "Monday"),
    Tuesday(2, "Tuesday"),
    Wednesday(3, "Wednesday"),
    Thursday(4, "Thursday"),
    Friday(5, "Friday"),
    Saturday(6, "Saturday"),
    Sunday(7, "Sunday");

    private int id;
    private String description;

    private DayOfWeek(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public static DayOfWeek toEnum(Integer id) {

        if (id == null) {
            return null;
        }

        for (DayOfWeek x : DayOfWeek.values()) {
            if (id.equals(x.getId())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + id);
    }
}
