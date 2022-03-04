package com.lj.mybatis;

import com.lj.mybatis.dao.Impl.StudentDaoImpl;
import com.lj.mybatis.dao.StudentDao;
import com.lj.mybatis.domain.Student;
import org.junit.Test;

import java.util.List;

/**
 * @author luojie
 * @Description
 * @date 2022/1/28 22/05
 */
public class MyTest2 {
    StudentDao studentDao = new StudentDaoImpl();
    @Test
    public void testselectStudentById(){

        Student student = studentDao.selectStudentById(1001);
        System.out.println(student);
    }

    @Test
    public void testselectStudents(){
        List<Student> students = studentDao.selectStudents();
        System.out.println(students);
    }

    @Test
    public void testinsertStudent(){
        Student student = new Student();
        student.setId(null);
        student.setName("妲己");
        student.setEmail("dj@qq.com");
        student.setAge(16);
        int i = studentDao.insertStudent(student);
        System.out.println(i);
    }
}
