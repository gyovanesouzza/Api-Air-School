package com.airschool.apiairschool.model.enums;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum ActivityType {
    PROVA(1, "Prova"),
    ATIVIDADE(2, "Atividade"),
    ATIVIDADE_RECUPERACAO(3, "Atividade de recuperação"),
    ATIVIDADE_PRESENCIA(4, "Atividade de presencia"),
    ATIVIDADE_OPCIONAL(5, "Atividade de opcional"),
    OUTRAS(6, "Outro tipo de atividade");

    private int id;
    private String description;

    private ActivityType(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public static ActivityType toEnum(Integer id) {

        if (id == null) {
            return null;
        }

        for (ActivityType x : ActivityType.values()) {
            if (id.equals(x.getId())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + id);
    }
}

