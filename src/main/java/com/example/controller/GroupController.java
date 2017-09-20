package com.example.controller;

import com.example.NotFoundException;
import com.example.domain.Group;
import com.example.domain.Joke;
import com.example.domain.Student;
import com.example.repository.GroupRepository;
import com.example.repository.JokeRepository;
import com.example.repository.StudentRepository;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


/**
 * Created by Elphas Khajira on 9/20/17.
 */
@RestController
@RequestMapping(value = "groups", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class GroupController {

    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;
    private final JokeRepository jokeRepository;

    public GroupController(GroupRepository groupRepository,
                           StudentRepository studentRepository,
                           JokeRepository jokeRepository) {
        this.groupRepository = groupRepository;
        this.studentRepository = studentRepository;
        this.jokeRepository = jokeRepository;
    }

    @PostMapping
    public Group createGroup(@RequestBody @Validated(Group.Create.class) Group group) {
       List<Student> students= studentRepository.save(group.getStudents());
        Group savedGroup = groupRepository.save(group);
        group.getStudents().forEach(student -> {
            student.setGroup(savedGroup);
            studentRepository.save(student);
        });

        return group;
    }

    @GetMapping(value ="{id}")
    public Group findById(@PathVariable Long id){
        Optional<Group> group= groupRepository.findById(id);
        if (group.isPresent())
            return group.get();
        else
            throw new NotFoundException("Group not found");

    }

    @PostMapping(value = "{groupId}/jokes")
    public Joke createJoke(@RequestBody @Validated(Joke.Create.class) Joke joke,
                           @PathVariable Long groupId){
        Optional<Group> group= groupRepository.findById(groupId);
        if (group.isPresent()) {
            joke.setGroup(group.get());

             Joke savedJoke=jokeRepository.save(joke);
            group.get().addJoke(savedJoke);
            groupRepository.save(group.get());
            return joke;
        }
        else
            throw new NotFoundException("Group not found");
    }




}
