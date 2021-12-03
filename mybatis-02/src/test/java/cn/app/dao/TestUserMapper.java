package cn.app.dao;

import cn.app.entity.User;
import cn.app.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("all")
public class TestUserMapper {
    @Test
    public void testgetUserList(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        try {
            List<User> userList = userMapper.getUserList();
            System.out.println(userList);
            sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    //增删改一定要提交事务，否则不能持久化
    public void testaddUser(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        try {
            System.out.println(userMapper.addUser(new User(6, "网球", "111")));
            sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testdelUser(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        try {
            System.out.println(userMapper.delUser(6));
            sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testgetUserLike(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("name","%李%");
        List<User> list;
        try {
           list  = userMapper.getUserLike(map);
            sqlSession.commit();
            for (User user : list) {
                System.out.println(user);
            }
        }catch (Exception e){
            sqlSession.rollback();
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testupdateUser(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
       UserMapper userMapper =  sqlSession.getMapper(UserMapper.class);
       Map<String,Object> map = new HashMap<String, Object>();
       map.put("name","王六");
       map.put("id",6);
       map.put("pwd","1234");

       userMapper.updateUser(map);
       sqlSession.commit();
       System.out.println("更新成功！");

       sqlSession.close();

    }
}
