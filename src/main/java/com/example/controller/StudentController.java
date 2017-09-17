package com.example.controller;

import com.example.domain.Student;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Elphas Khajira on 9/6/17.
 */
@RestController
@RequestMapping(value = "students",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
public class StudentController {

//    @Autowired
//    private StudentRepository studentRepository;

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

//    @PostMapping
//    @RequestMapping(value = "students", method = RequestMethod.POST)
//    public Student createStudent(@RequestBody Student student){
//        return studentRepository.save(student);
//    }
//
//    @RequestMapping(value = "students", method = RequestMethod.GET)
//    public List<Student> findAll(){
//        return studentRepository.findAll();
//    }

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @GetMapping
    public List<Student> findAll(){
        return studentRepository.findAll();
    }


    @GetMapping(value = "search",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public List<Student> search(@RequestParam String firstName){
        return studentRepository.findByFirstNameContainingIgnoreCase(firstName);
    }


    @GetMapping(value = "{id}", produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public Student findById(@PathVariable Long id, @RequestParam(required = false)String format){

        return studentRepository.findOne(id);
    }

    @DeleteMapping
    public void deleteStudent(@PathVariable Long id){
        studentRepository.delete(id);
    }

    @PatchMapping(value = "{id}")
    public Student updateStudent(@PathVariable Long id){
      return null;
    }
}
