package cn.app.dao;

import cn.app.entity.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList();

    boolean addUser(User user);

    boolean delUser(int id);

    List<User> getUserLike(Map<String, Object> map);

    boolean updateUser(Map<String, Object> map);
}
