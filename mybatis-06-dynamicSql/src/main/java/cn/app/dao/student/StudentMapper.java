package cn.app.dao.student;

import cn.app.entity.Student;
import java.util.List;
import java.util.Map;

public interface StudentMapper {

    /**
     * 功能描述：根据条件动态查询学生
     * @param  paramMap 封装查询条件
     * @return List<Student>学生列表
     * */
    List<Student> getStudentByCondition(Map<String, Object> paramMap);

    /**
     * 功能描述：根据id更新学生信息
     * @param paramMap 封装id和修改的信息
     * @return boolean 返回是否更新成功
     * */
    Boolean updateStudentById(Map<String, Object> paramMap);

    /**
     * 功能描述：通过id列表查询用户
     * @param idList 用户id列表
     * @return List<Student> 学生列表
     * */
    List<Student> getStudentByIds(List<Integer> idList);

    /**
     * 功能描述：通过choosewhen动态语句查询学生
     * @param paramMap 条件
     * @return List<Student> 学生列表
     * */
    List<Student> getStudentByChooseWhen(Map<String, Object> paramMap);
}
