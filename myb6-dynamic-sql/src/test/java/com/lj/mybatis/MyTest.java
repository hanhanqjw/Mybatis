package com.lj.mybatis;

import com.github.pagehelper.PageHelper;
import com.lj.mybatis.dao.StudentDao;
import com.lj.mybatis.domain.Student;
import com.lj.mybatis.utils.MyBatisUtil;
import com.lj.mybatis.vo.CustomeObject;
import com.lj.mybatis.vo.Province;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luojie
 * @Description
 * @date 2022/1/28 21/25
 */
public class MyTest {
    @Test
    public void testselectIf(){
        SqlSession session = MyBatisUtil.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);
        Student student = new Student();
//        student.setName("罗霁");
//        student.setAge(37);
        student.setAge(30);
        List<Student> students = dao.selectIf(student);
        students.forEach(stu-> System.out.println(stu));
        session.close();
    }

    @Test
    public void testselectWhere(){
        SqlSession session = MyBatisUtil.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("罗霁");
//        student.setAge(37);
        student.setAge(37);
        List<Student> students = dao.selectWhere(student);
        students.forEach(stu-> System.out.println(stu));
        session.close();
    }
    @Test
    public void testselectForeach1(){
        SqlSession session = MyBatisUtil.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);
        List<Integer> idlist = new ArrayList<>();
        idlist.add(1001);
        idlist.add(1002);
        idlist.add(1003);
        idlist.add(1004);



        List<Student> students = dao.selectForeach1(idlist);
        students.forEach(student -> System.out.println(student));
        session.close();
    }

    @Test
    public void testselectForeach2(){
        SqlSession session = MyBatisUtil.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);
        List<Student> stulist = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            Student stu = new Student();
            stu.setId(1003+i);
            stulist.add(stu);
        }


        List<Student> students = dao.selectForeach2(stulist);
        students.forEach(student -> System.out.println(student));
        session.close();
    }

    @Test
    public void testpage(){

        SqlSession session = MyBatisUtil.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);

        //获取第一页，每页3条内容
        PageHelper.startPage(3,3);
        List<Student> students = dao.selectallstudent();
        students.forEach(stu-> System.out.println(stu));
        session.close();
    }
}
