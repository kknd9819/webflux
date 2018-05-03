package com.zz.webflux.dao;

import com.zz.webflux.model.Student;

import java.util.List;

public interface StudentDao {
    List<Student> findAll();

    Student findById(Long id);
}
