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

        Student student = dao.selectStudentById(1002);
        System.out.println(student);

        //com.sun.proxy.$Proxy2
        System.out.println(dao.getClass().getName());

        //4、关闭SqlSession
        session.close();
    }

    @Test
    public void testSelectListStudent(){
        SqlSession session = MyBatisUtil.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);
        List<Student> students = dao.selectStudents();
        students.forEach(student -> System.out.println(student));
        session.close();
    }

    @Test
    public void testinsert(){
        SqlSession session = MyBatisUtil.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);
        Student stu = new Student();
        stu.setAge(21);
        stu.setEmail("zhy@qq.com");
        stu.setName("章鱼");
        int i = dao.insertStudent(stu);
        System.out.println(i);
        session.commit();
        session.close();
    }


}
