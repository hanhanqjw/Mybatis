package com.lj.mybatis.dao.Impl;

import com.lj.mybatis.dao.StudentDao;
import com.lj.mybatis.domain.Student;
import com.lj.mybatis.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author luojie
 * @Description
 * @date 2022/1/28 21/59
 */

/**
 * dao代理技术 由mybatis创建StudentDao接口的实现类Proxy(StudentDaoImpl)
 * 使用框架创建的StudentDaoInpl代替 你自己手工实现的StudentDaoImpl类的功能，不用开发人员写dao接口的实现类
 */
public class StudentDaoImpl implements StudentDao {
    @Override
    public Student selectStudentById(Integer id) {
        SqlSession session = MyBatisUtil.getSqlSession();
        String sqlId = "com.lj.mybatis.dao.StudentDao.selectStudentById";
        Student student = session.selectOne(sqlId, id);
        session.close();
        return student;
    }

    @Override
    public List<Student> selectStudents() {
        //1、获取SqlSession
        SqlSession session = MyBatisUtil.getSqlSession();
        //2、指定sqlId
        String sqlId = "com.lj.mybatis.dao.StudentDao.selectStudents";
        //3、执行SqlSession的方法表示执行sql语句
        List<Student> student = session.selectList(sqlId);
        //4、关闭SqlSession
        session.close();
        return student;
    }

    @Override
    public int insertStudent(Student student) {
        SqlSession session = MyBatisUtil.getSqlSession();
        String sqlId = "com.lj.mybatis.dao.StudentDao.insertStudent";
        int insert = session.insert(sqlId, student);
        session.commit();
        session.close();
        return insert;
    }
}
