package com.zz.webflux.controller;

import com.zz.webflux.dao.StudentDao;
import com.zz.webflux.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class StudentController {

    private final StudentDao studentDao;

    public StudentController(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @GetMapping("/Students")
    public Flux<Student> findAll(){
        List<Student> students = studentDao.findAll();
        return Flux.fromIterable(students);
    }

    @GetMapping("/Student/{id}")
    public Mono<Student> findById(@PathVariable("id") Long id){
        Student student = studentDao.findById(id);
        return Mono.justOrEmpty(student);
    }
}
