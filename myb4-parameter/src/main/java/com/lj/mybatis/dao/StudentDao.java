package com.lj.mybatis.dao;

import com.lj.mybatis.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author luojie
 * @Description
 * @date 2022/1/28 20/52
 */
public interface StudentDao {
    Student selectStudentById(Integer id);

    Student selectByName(String name);

    /*
    多个简单类型的参数
     */

    List<Student> selectByNameOrAge(@Param(value = "name") String name, @Param("age") Integer age);

    /*
    一个java对象作为参数（对象有属性，每个属性有get set方法）
     */
    List<Student> selectByObject(Student stu);

    /*
    使用位置，获取参数
     */
    List<Student> selectByPosition(String name,Integer age);

    /*
    更新
     */
    int updateStudent(Student student);

    /*
    排序
     */
    List<Student> queryStdudentOrderById();
    List<Student> queryStdudentOrderByColName(@Param("age") Integer age,@Param("name") String name);

}
