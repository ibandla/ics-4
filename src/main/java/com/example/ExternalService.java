package com.example;

import com.example.domain.Student;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Elphas Khajira on 9/13/17.
 */
@FeignClient(url = "https://swuzhtvqps.localtunnel.me", name = "getStudents")
public interface ExternalService {
    @RequestMapping(value = "/students",method = RequestMethod.GET)
    List<Student> findAllStudentsFromExternalService();
}
