package com.example;

import com.example.domain.Student;
import com.example.models.Me;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class TestExternalService implements CommandLineRunner{

    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private final StudentFeignClient myfeignClient;

    public TestExternalService(StudentFeignClient myfeignClient) {
        this.myfeignClient = myfeignClient;

    }

    @Override
    public void run(String... strings) throws Exception {
//        Me first = new Me();
//        first.setFullName("Clive Makamara");
//        first.setadmissionNumber(82816);
//        Me second = myfeignClient.createMe(first);
//        List<Double> l = new ArrayList<>();
//        l.add(121.1);
//        l.add(122.4);
//        Double answer = myfeignClient.calculate(l,second.getId().toString(),"Multiply");
//        myfeignClient.validate(l,second.getId().toString(),answer);
//        logger.info("Done");
    }
}
