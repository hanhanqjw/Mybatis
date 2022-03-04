package com.lj.mybatis;

import com.lj.mybatis.dao.StudentDao;
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
        //2、获取dao代理
        StudentDao dao = session.getMapper(StudentDao.class);

        Student student = dao.selectStudentById(1003);
        System.out.println(student);

        //com.sun.proxy.$Proxy2
//        System.out.println(dao.getClass().getName());

        //4、关闭SqlSession
        session.close();
    }
    @Test
    public void testSelectByName(){
        SqlSession session = MyBatisUtil.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);
        Student student = dao.selectByName("妲己");
        System.out.println(student);
        session.close();
    }
    @Test
    public void testselectByNameOrAge(){
        SqlSession session = MyBatisUtil.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);
        List<Student> students = dao.selectByNameOrAge("张三",37);
        students.forEach(student -> System.out.println(student));
        session.close();
    }

    @Test
    public void testselectByObject(){
        SqlSession session = MyBatisUtil.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);
        Student stu = new Student();
        stu.setName("张三");
        stu.setAge(37);

        List<Student> students = dao.selectByObject(stu);
        students.forEach(student -> System.out.println(student));
        session.close();
    }

    @Test
    public void testselectByPosition(){
        SqlSession session = MyBatisUtil.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);

        List<Student> students = dao.selectByPosition("罗霁",37);
        students.forEach(student -> System.out.println(student));
        session.close();
    }


    @Test
    public void testupdateStudent(){
        SqlSession session = MyBatisUtil.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);
        Student student = new Student();
        student.setId(1003);
        student.setName("白小青");
        student.setEmail("bxq@qq.com");
        int i = dao.updateStudent(student);
        System.out.println(i);
        session.commit();
        session.close();
    }


    @Test
    public void testqueryStdudentOrderById(){
        SqlSession session = MyBatisUtil.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);

        List<Student> students = dao.queryStdudentOrderById();
        students.forEach(student -> System.out.println(student));
        session.close();
    }


    @Test
    public void testqueryStdudentOrderByColName(){
        SqlSession session = MyBatisUtil.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);

        List<Student> students = dao.queryStdudentOrderByColName(16,"name");
        students.forEach(student -> System.out.println(student));
        session.close();
    }



}
