package com.example.repository;

import com.example.domain.Group;
import com.example.domain.Joke;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Elphas Khajira on 9/20/17.
 */
public interface JokeRepository extends MongoRepository<Joke,Long> {

    Optional<List<Joke>> findAllByGroup(Group group);

}
