package com.airschool.apiairschool.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Activity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Date creation_date;
    private Date delivery_date;
    private float score;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "activity_student",
            joinColumns = @JoinColumn(name = "activity_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private Set<Student> students;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "activity_teacher",
            joinColumns = @JoinColumn(name = "activity_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id"))
    private Set<Employee> teachers;


}
