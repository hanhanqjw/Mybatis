package com.lj.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

/**工具类：创建sqlSession对象
 * @author luojie
 * @Description
 * @date 2022/1/28 21/14
 */
public class MyBatisUtil {
    private static SqlSessionFactory factory = null;
    static {
        String config="mybatis.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(config);
            factory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //创建方法，获取SqlSession对象
    public static SqlSession getSqlSession(){
        SqlSession session = null;
        if(factory != null){
            session = factory.openSession();//openSession(true)
        }
        return session;
    }
}
