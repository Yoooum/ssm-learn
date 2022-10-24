package com.prprv.spring.mybatis.mapper;

import com.prprv.spring.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 未確認の庭師
 */
public interface UserMapper {
    int insertUser(User user);
    int updateUser();
    int deleteUser();
    User selectUserById();
    User selectUserByName(String username);
    User checkLogin(String username, String password);
    User checkLoginByMap(Map<String, Object> map);
    User checkLoginByParam(@Param("username") String username, @Param("password") String password);

    List<User> selectAllUser();

}
