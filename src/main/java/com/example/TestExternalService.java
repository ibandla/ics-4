package com.example;

import com.example.domain.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Elphas Khajira on 9/13/17.
 */
//@Component
public class TestExternalService implements CommandLineRunner{

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final ExternalService externalService;

    public TestExternalService(ExternalService externalService) {
        this.externalService = externalService;
    }

    @Override
    public void run(String... strings) throws Exception {
        List<Student> students=externalService.findAllStudentsFromExternalService();
        students.forEach(student -> {
            logger.info("Student name is "+student.getFirstName());
        });
    }
}
