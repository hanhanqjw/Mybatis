package com.lj.mybatis.dao;

import com.lj.mybatis.domain.Student;
import com.lj.mybatis.vo.CustomeObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author luojie
 * @Description
 * @date 2022/1/28 20/52
 */
public interface StudentDao {
    Student selectStudentById(Integer id);

    CustomeObject selectById(Integer id);
    Long countStudent();

    //like第一种方式
    List<Student> selectLikeOne(String name);

    //like第二种方式
    List<Student> selectLikeTwo(String name);
}
