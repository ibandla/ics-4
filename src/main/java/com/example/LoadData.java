package com.example;

import com.example.domain.Student;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by Elphas Khajira on 9/6/17.
 */
@Component
public class LoadData implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... strings) throws Exception {
        studentRepository.save(Arrays.asList(
                new Student("Elphas","Khajira"),
                new Student("John","Kamau"),
                new Student("Kimokoti","Chebukati")
        ));
    }
}
