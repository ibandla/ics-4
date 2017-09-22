package com.example.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elphas Khajira on 9/20/17.
 */
@Document
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @NotNull(groups = Create.class, message = "Name cannot be null")
    private String groupName;

    @OneToMany
    @JoinColumn(name = "student_id")
    @NotNull(groups = Create.class)
    private List<Student> students=new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "joke_id")
    private List<Joke> jokes=new ArrayList<>();

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public Group() {
    }

    public void addJoke(Joke joke){
        jokes.add(joke);
    }

    public List<Joke> getJokes() {
        return jokes;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void addAllStudent(List<Student> students){
        students.addAll(students);
    }

    public String getId() {
        return id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public interface Create {
    }
}
