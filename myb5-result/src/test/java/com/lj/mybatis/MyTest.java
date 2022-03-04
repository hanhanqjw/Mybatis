package com.lj.mybatis;

import com.lj.mybatis.dao.ProvinceDao;
import com.lj.mybatis.dao.StudentDao;
import com.lj.mybatis.domain.Student;
import com.lj.mybatis.utils.MyBatisUtil;
import com.lj.mybatis.vo.CustomeObject;
import com.lj.mybatis.vo.Province;
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
    public void testcountStudent(){
        SqlSession session = MyBatisUtil.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);
        Long aLong = dao.countStudent();
        System.out.println(aLong);
        session.close();
    }

    @Test
    public void testselectById(){
        SqlSession session = MyBatisUtil.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);
        CustomeObject customeObject = dao.selectById(1001);
        System.out.println(customeObject);
    }

    @Test
    public void testselectProvinceList(){
        SqlSession session = MyBatisUtil.getSqlSession();
        ProvinceDao dao = session.getMapper(ProvinceDao.class);
        List<Province> provinces = dao.selectProvinceList(2);
        provinces.forEach(province -> System.out.println(province));
        session.close();
    }

    @Test
    public void testLikeOne(){
        SqlSession session = MyBatisUtil.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);
        String name = "%张%";
        List<Student> students = dao.selectLikeOne(name);
        students.forEach(student -> System.out.println(student));
        session.close();
    }

    @Test
    public void testLikeTwo(){
        SqlSession session = MyBatisUtil.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);
        String name = "%张%";
        List<Student> students = dao.selectLikeTwo("罗");
        students.forEach(student -> System.out.println(student));
        session.close();
    }
}
