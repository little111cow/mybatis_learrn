package cn.app.dao.teacher;

import cn.app.entity.Student;
import cn.app.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {

    Teacher getTeacherById(@Param("tid") int id);
}
