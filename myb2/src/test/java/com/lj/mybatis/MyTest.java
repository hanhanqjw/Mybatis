package com.lj.mybatis;

import com.lj.mybatis.domain.Student;
import com.lj.mybatis.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author luojie
 * @Description
 * @date 2022/1/28 21/25
 */
public class MyTest {
    @Test
    public void testSelectStudentById(){
        //1、获取SqlSession
        SqlSession session = MyBatisUtil.getSqlSession();
        //2、指定sqlId
        String sqlId = "com.lj.mybatis.dao.StudentDao.selectStudentById";
        //3、执行SqlSession的方法表示执行sql语句
        Student student = session.selectOne(sqlId, 1003);
        System.out.println(student);
        //4、关闭SqlSession
        session.close();
    }

    @Test
    public void testSelectStudents(){
        //1、获取SqlSession
        SqlSession session = MyBatisUtil.getSqlSession();
        //2、指定sqlId
        String sqlId = "com.lj.mybatis.dao.StudentDao.selectStudents";
        //3、执行SqlSession的方法表示执行sql语句
        List<Student> student = session.selectList(sqlId);
        System.out.println(student);
        //4、关闭SqlSession
        session.close();
    }

    @Test
    public void testinsertStudent(){
        SqlSession session = MyBatisUtil.getSqlSession();
        String sqlId = "com.lj.mybatis.dao.StudentDao.insertStudent";

        Student student = new Student();
        student.setId(null);
        student.setName("张伟");
        student.setEmail("zw@qq.com");
        student.setAge(37);

        int insert = session.insert(sqlId, student);
        System.out.println(insert);
        session.commit();
        session.close();


    }
}
