package com.prprv.mybatis.mapper;

import com.prprv.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 未確認の庭師
 */
public interface SpecialMapper {
    //模糊查询
    List<User> selectUserByLike(@Param("fuzzy") String fuzzy);
    //批量删除
    void deleteUserByIds(@Param("ids") String ids);
    //动态设置表名
    List<User> selectUserByTableName(@Param("tableName") String tableName);
    //添加功能获取自增的主键
    void insertUser(User user);

}
