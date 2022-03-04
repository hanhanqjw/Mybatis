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

    //if
    List<Student> selectIf(Student student);

    //where
    List<Student> selectWhere(Student student);

    //foreach-1
    List<Student> selectForeach1(List<Integer> idlist);

    //foreach-2
    List<Student> selectForeach2(List<Student> students);

    List<Student> selectallstudent();

}
