package cn.app.dao;

import cn.app.entity.User;
import cn.app.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("all")
public class TestUserMapper {
   static Logger logger = Logger.getLogger(TestUserMapper.class);  //获取log4j日志对象
    @Test
    public void test(){
        logger.info("进入了test方法");  //提示信息
        logger.debug("debug进入了test方法");  //debug信息
        logger.error("test方法内部发生错误");  //错误提示信息
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.getuserById(1));
        sqlSession.close();
    }
}
