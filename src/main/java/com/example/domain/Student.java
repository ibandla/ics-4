package com.example.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Elphas Khajira on 9/6/17.
 * Represents a real life object being modelled
 */
@Entity   //specify that this is to be mapped to a database table
@Table(name = "students")
@XmlRootElement(name = "student")
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    private Long regNumber;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "group_id")
    private Group group;

    public Student(String firstName, String lastName, Long regNumber, Group group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.regNumber = regNumber;
        this.group = group;
    }

    public Student(String firstName, String lastName, Long regNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.regNumber = regNumber;
        this.group = group;
    }

    public Student() {
    }

    public Long getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(Long regNumber) {
        this.regNumber = regNumber;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
