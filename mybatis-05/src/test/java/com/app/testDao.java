package com.app;

import cn.app.dao.student.StudentMapper;
import cn.app.dao.teacher.TeacherMapper;
import cn.app.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class testDao {
    @Test
    public void testStudentMapper(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        System.out.println(studentMapper.getStudentById(1));
        sqlSession.close();
 }

    @Test
    public void testTeacherMapper(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        System.out.println(teacherMapper.getTeacherById(1));
        sqlSession.close();
}



}
