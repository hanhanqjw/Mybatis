package com.lj.mybatis.dao;

import com.lj.mybatis.domain.Student;

import java.util.List;

/**
 * @author luojie
 * @Description
 * @date 2022/1/28 20/52
 */
public interface StudentDao {
    Student selectStudentById(Integer id);

    List<Student> selectStudents();

    int insertStudent(Student student);
}
