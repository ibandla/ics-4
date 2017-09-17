package com.example.repository;

import com.example.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Elphas Khajira on 9/6/17.
 *
 * Used to map our student object to a table in the database
 * it extents JpaRepository which has methods defined to access and
 * manipulate data
 */
public interface StudentRepository extends JpaRepository<Student,Long>{
    List<Student> findByFirstNameContainingIgnoreCase(String firstName);
}
