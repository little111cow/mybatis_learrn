package cn.app.dao.student;

import cn.app.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentMapperTest {
    static Logger logger = Logger.getLogger(StudentMapperTest.class);
    @Test
    public void getStudentByConditionTest(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        String name = "aaaa";
        paramMap.put("name", "%"+name+"%");
        paramMap.put("id", null);
        paramMap.put("tid", 2);
        logger.info(paramMap.toString());
        System.out.println(studentMapper.getStudentByCondition(paramMap));
        sqlSession.close();
    }
    @Test
    public void updateStudentByIdTest(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id", 1);
        paramMap.put("name", "bbbb");
        paramMap.put("tid", null);
        logger.info(paramMap.toString());
        System.out.println(studentMapper.updateStudentById(paramMap));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getStudentByIdsTest(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Integer> idList = new ArrayList<Integer>();
        idList.add(1);
        idList.add(2);
        System.out.println(studentMapper.getStudentByIds(idList));
        sqlSession.close();
    }

    @Test
    public void getStudentByChooseWhenTest(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        String name = "aa";
        paramMap.put("id",null);
        paramMap.put("likeName","%"+name+"%");
        System.out.println(studentMapper.getStudentByChooseWhen(paramMap));
        sqlSession.close();
    }
}
