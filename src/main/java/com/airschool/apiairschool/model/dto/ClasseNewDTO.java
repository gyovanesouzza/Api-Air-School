package com.airschool.apiairschool.model.dto;

import com.airschool.apiairschool.model.enums.ClasseType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


public class ClasseNewDTO {

    private char letter;
    private Integer yearClasse;
    private String year;

    private Integer type;

    public ClasseNewDTO() {
    }

    public ClasseNewDTO(char letter, Integer yearClasse, String year, Integer type) {
        this.letter = letter;
        this.yearClasse = yearClasse;
        this.year = year;
        this.type = type;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public Integer getYearClasse() {
        return yearClasse;
    }

    public void setYearClasse(Integer yearClasse) {
        this.yearClasse = yearClasse;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
