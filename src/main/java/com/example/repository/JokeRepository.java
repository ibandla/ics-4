package com.example.repository;

import com.example.domain.Joke;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Elphas Khajira on 9/20/17.
 */
public interface JokeRepository extends JpaRepository<Joke,Long> {
}
