package com.example.controller;


import com.example.StudentFeignClient;
import com.example.domain.Group;
import com.example.domain.Joke;
import com.example.models.Me;
import com.example.repository.GroupRepository;
import com.example.repository.JokeRepository;
import com.google.gson.Gson;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clive on 26/09/17.
 */

@RestController
@RequestMapping(value = "feign", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})

public class FeignController {

    private final GroupRepository groupRepository;
    private final StudentFeignClient studentFeignClient;
    private final JokeRepository jokeRepository;
    public FeignController(StudentFeignClient studentFeignClient,
                           JokeRepository jokeRepository,
                           GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
        this.jokeRepository = jokeRepository;
        this.studentFeignClient = studentFeignClient;
    }



    @PostMapping(value = "groups")
    public String createGroup(@RequestBody String payload) {

        Group group = new Gson().fromJson(payload, Group.class);

        Group newGroup =  studentFeignClient.createGroup(group);


//        groupRepository.save(newGroup);
        String id = newGroup.getId();
        return  id;


    }

    @PostMapping(value = "{groupId}/jokes")
    public String createJoke(@RequestBody @Validated(Joke.Create.class) Joke joke,
                             @PathVariable String groupId) {

        joke = new Joke();
        joke.setJoke("sdfas");

        Joke newJoke = studentFeignClient.createJoke(joke, groupId);
        jokeRepository.save(newJoke);
        String id = newJoke.getId();
        return  id;


    }

    @GetMapping(value = "register")
    public Me register() {
        Me first = new Me();
        first.setfullName("Clive Makamara");
        first.setadmissionNumber(82816);
        Me second = studentFeignClient.createMe(first);

        return  second;

    }


    @GetMapping(value = "calculate/{id}")
    public Double calculate( @PathVariable("id") String id) {
        List<Double> l = new ArrayList<>();
        l.add(121.1);
        l.add(122.4);

        Double answer = studentFeignClient.calculate(l,id,"Multiply");

        return  answer;


    }


    @GetMapping(value = "validate/{answer}/{id}")
    public Double    validate( @PathVariable("id") String id, @PathVariable("answer") Double answer) {
        List<Double> l = new ArrayList<>();
        l.add(121.1);
        l.add(122.4);
       studentFeignClient.validate(l,id,answer);

        return  answer;


    }







}
