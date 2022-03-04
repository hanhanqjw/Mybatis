package com.lj.mybatis.dao;

import com.lj.mybatis.domain.Student;

import java.util.List;

/**
 * @author luojie
 * @Description
 * @date 2022/1/19 22/32
 */
public interface StudentDao {
    //查询一个学生
    Student selectStudentById(Integer id);

    /**
     * 添加学生
     * @param student
     * @return  返回影响行数
     */
    int insertStudent(Student student);

    /**
     * 删除学生
     * @param id
     * @return 返回影响行数
     */
    int deleteStudent(Integer id);

    /**
     * 查询所有
     * @return 返回所以数据
     */
    List<Student> selectList();

}
