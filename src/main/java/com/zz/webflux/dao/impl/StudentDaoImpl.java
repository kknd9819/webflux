package com.zz.webflux.dao.impl;

import com.zz.webflux.dao.StudentDao;
import com.zz.webflux.model.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class StudentDaoImpl implements StudentDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public StudentDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }


    @Override
    public List<Student> findAll() {
        String sql = "select * from Student";
        BeanPropertyRowMapper<Student> rm = BeanPropertyRowMapper.newInstance(Student.class);
        return namedParameterJdbcTemplate.query(sql,rm);
    }

    @Override
    public Student findById(Long id) {
        String sql = "select * from Student where id = :id";
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("id",id);
        BeanPropertyRowMapper<Student> rm = BeanPropertyRowMapper.newInstance(Student.class);
        List<Student> query = namedParameterJdbcTemplate.query(sql,paramMap,rm);
        return query.size() == 0 ? null : query.get(0);
    }
}
