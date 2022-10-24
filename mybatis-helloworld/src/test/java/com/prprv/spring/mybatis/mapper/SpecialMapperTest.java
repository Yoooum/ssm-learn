package com.prprv.spring.mybatis.mapper;

import com.prprv.spring.mybatis.pojo.User;
import com.prprv.spring.mybatis.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

/**
 * @author 未確認の庭師
 */
class SpecialMapperTest {

    @Test
    void selectUserByLike() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialMapper specialMapper = sqlSession.getMapper(SpecialMapper.class);
        specialMapper.selectUserByLike("a").forEach(System.out::println);
    }

    @Test
    void deleteUserByIds() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialMapper specialMapper = sqlSession.getMapper(SpecialMapper.class);
        specialMapper.deleteUserByIds("1,2,3");
    }

    @Test
    void selectUserByTableName() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialMapper specialMapper = sqlSession.getMapper(SpecialMapper.class);
        specialMapper.selectUserByTableName("t_user").forEach(System.out::println);
    }

    //添加功能获取自增的主键
    @Test
    void insertUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialMapper specialMapper = sqlSession.getMapper(SpecialMapper.class);
        User user = new User(null,"test","123456",55,"女","aa@p.p");
        specialMapper.insertUser(user);
        System.out.println(user);
    }
}