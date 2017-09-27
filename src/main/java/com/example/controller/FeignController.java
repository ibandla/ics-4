package com.example.controller;


import com.example.StudentFeignClient;
import com.example.domain.Group;
import com.example.domain.Joke;
import com.example.repository.GroupRepository;
import com.example.repository.JokeRepository;
import com.google.gson.Gson;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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


        groupRepository.save(newGroup);
        String id = newGroup.getId();
        return  id;


    }

    @PostMapping(value = "{groupId}/jokes")
    public String createJoke(@RequestBody @Validated(Joke.Create.class) Joke joke,
                             @PathVariable String groupId) {

        Joke newJoke = studentFeignClient.createJoke(joke, groupId);
        jokeRepository.save(newJoke);
        String id = newJoke.getId();
        return  id;


    }




}
