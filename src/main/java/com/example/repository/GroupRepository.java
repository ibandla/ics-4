package com.example.repository;

import com.example.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by Elphas Khajira on 9/20/17.
 */
public interface GroupRepository extends JpaRepository<Group,Long> {
    Optional<Group> findById(Long id);
}
