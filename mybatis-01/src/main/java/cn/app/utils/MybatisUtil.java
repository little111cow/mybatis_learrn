package cn.app.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MybatisUtil {
    //sqlsession工厂
    private static SqlSessionFactory sqlSessionFactory;
    //类加载时就初始化
    static {
        try {
            String resource = "mybatis-config.xml";  //核心配置文件
            InputStream inputStream = Resources.getResourceAsStream(resource);  //读取配置文件作为流
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);  //建立sqlsession工厂
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //得到一个sqlsession对象，类似于jdbc中的connection对象
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
}
