package com.prprv.spring.mybatis.mapper;

import com.prprv.spring.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 未確認の庭師
 */
public interface SelectMapper {
    User selectUserById(@Param("id") Integer id);
    List<User> selectAllUser();
    Integer selectCount();
    Map<String, Object> selectUserByIdToMap(@Param("id") Integer id);
    List<Map<String, Object>> selectAllUserToList();
    // @MapKey("id") 用于指定返回的map的key
    @MapKey("id")
    Map<String, Object> selectAllUserToMap();
}
