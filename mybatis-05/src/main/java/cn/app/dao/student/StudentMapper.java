package cn.app.dao.student;

import cn.app.entity.Student;
import cn.app.entity.Teacher;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper {

    Student getStudentById(@Param("sid") int id);

}
