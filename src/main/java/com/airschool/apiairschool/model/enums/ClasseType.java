package com.airschool.apiairschool.model.enums;

public enum ClasseType {
    ELEMENTARY(1, "Elementary School"),
    HIGH(2, "High School");
    private int id;
    private String description;

    private ClasseType(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public static ClasseType toEnum(Integer id) {

        if (id == null) {
            return null;
        }

        for (ClasseType x : ClasseType.values()) {
            if (id.equals(x.getId())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + id);
    }

    public int getId() {
        return id;
    }
}
