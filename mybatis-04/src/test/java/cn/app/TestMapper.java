package cn.app;

import cn.app.dao.UserMapper;
import cn.app.entity.User;
import cn.app.utils.MybatisUtil;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;


public class TestMapper {
    //两者均可
//   private static Logger logger = LogManager.getLogger(TestMapper.class);
    private static Logger logger = Logger.getLogger(TestMapper.class);
    @Test
    public void testgetUserById(){
        logger.info("测试通过id查询用户");
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.getuserById(1));
        sqlSession.close();
}
    @Test
    public void testgetUserListByLimit(){
        logger.debug("测试limit分页");
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.getUserListByLimit(2,2));
        sqlSession.close();
}
    @Test
    public void testgetUserListByRowBounds(){
        logger.info("测试rowbounds分页");
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        RowBounds rowBounds = new RowBounds(2,2);
        System.out.println(sqlSession.selectList("cn.app.dao.UserMapper.getUserListByRowBounds", null, rowBounds));
        sqlSession.close();
    }

    @Test
    public void testaddUser(){
        logger.info("测试添加用户方法");
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.addUser(new User(10,"lladl","123442")));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testdelUser(){
        logger.info("测试删除用户");
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.delUser(10));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testupdateUser(){
        logger.debug("测试更新用户方法");
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.updateUser(new User(10,"dal","123")));
        sqlSession.commit();
        sqlSession.close();
    }
}
