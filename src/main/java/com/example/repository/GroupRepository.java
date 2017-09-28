package com.example.repository;

import com.example.domain.Group;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * Created by Elphas Khajira on 9/20/17.
 */
public interface GroupRepository extends MongoRepository<Group,String> {
    Optional<Group> findById(String id);

}
