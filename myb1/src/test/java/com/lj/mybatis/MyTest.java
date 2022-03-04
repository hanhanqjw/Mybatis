package com.lj.mybatis;

import com.lj.mybatis.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author luojie
 * @Description
 * @date 2022/1/22 16/02
 */
public class MyTest {
    @Test
    public void testSelectStudentById() throws IOException {
        //调用mybatis某个对象的方法 ，执行mapper文件中的sql语句
        //mybatis 核心类；SqlSessionFactory

        //1、定义mybatis主配置文件的位置,从类路径开始的相对路径

        String resource = "mybatis.xml";

        //2、读取主配置文件，使用mybatis框架中的Resources类

        InputStream inputStream = Resources.getResourceAsStream(resource);

        //3、创建SqlSessionFactory对象,使用SqlSessionFactoryBuilder类
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //4、获取SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();
        //5、指定要执行的sql语句的id
        //sql的id = namespace+"."+select|updata|insert标签的属性值
        String sqlId = "com.lj.mybatis.dao.StudentDao"+"."+"selectStudentById";
        //6、通过SqlSession的方法执行sql语句

        Student student = session.selectOne(sqlId);
        System.out.println(student);

        //关闭SqlSession对象
        session.close();

    }

    @Test
    public void testSelectStudentById2() throws IOException {
        //调用mybatis某个对象的方法 ，执行mapper文件中的sql语句
        //mybatis 核心类；SqlSessionFactory

        //1、定义mybatis主配置文件的位置,从类路径开始的相对路径

        String resource = "mybatis.xml";

        //2、读取主配置文件，使用mybatis框架中的Resources类

        InputStream inputStream = Resources.getResourceAsStream(resource);

        //3、创建SqlSessionFactory对象,使用SqlSessionFactoryBuilder类
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //4、获取SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();
        //5、指定要执行的sql语句的id
        //sql的id = namespace+"."+select|updata|insert标签的属性值
        String sqlId = "com.lj.mybatis.dao.StudentDao"+"."+"selectStudentById";
        //6、通过SqlSession的方法执行sql语句

        Student student = session.selectOne(sqlId,1003);
        System.out.println(student);

        //关闭SqlSession对象
        session.close();

    }

    @Test
    public void testInsertStudent() throws IOException {

        String resource = "mybatis.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        String sqlId = "com.lj.mybatis.dao.StudentDao"+"."+"insertStudent";

        Student student = new Student(null, "李四", "ls@qq.com", 37);
        int insert = session.insert(sqlId,student);
        session.commit();
        System.out.println(insert);
        session.close();

    }

    @Test
    public void testdeleteStudent() throws IOException {

        String resource = "mybatis.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        String sqlId = "com.lj.mybatis.dao.StudentDao"+"."+"deleteStudent";


        int delete = session.delete(sqlId, 1001);


        session.commit();
        System.out.println(delete);
        session.close();

    }

    @Test
    public void testselectList() throws IOException {

        String resource = "mybatis.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        String sqlId = "com.lj.mybatis.dao.StudentDao"+"."+"selectList";

        List<Student> list = session.selectList(sqlId);
        session.commit();
        System.out.println(list);
        session.close();

    }

}
