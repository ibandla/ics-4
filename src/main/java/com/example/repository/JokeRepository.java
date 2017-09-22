package com.example.repository;

import com.example.domain.Joke;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Elphas Khajira on 9/20/17.
 */
public interface JokeRepository extends MongoRepository<Joke,Long> {
}
