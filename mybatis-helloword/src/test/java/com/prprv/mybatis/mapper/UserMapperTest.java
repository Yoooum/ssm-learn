package com.prprv.mybatis.mapper;

import com.prprv.mybatis.pojo.User;
import com.prprv.mybatis.util.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;


/**
 * @author 未確認の庭師
 */
class UserMapperTest {

    @Test
    void insertUser() throws IOException {
        //获取配置文件输入流
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        //创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        //创建SqlSession对象
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        //自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //System.out.println(sqlSession.insert("com.prprv.mybatis.mapper.UserMapper.insertUser"));
        //获取UserMapper接口的代理实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用方法
        User user = new User(null, "test", "123456", 24, "男", "abc@t.t");
        int result = userMapper.insertUser(user);
        System.out.println(result);


        //手动提交事务
        //sqlSession.commit();
        //关闭资源
        sqlSession.close();
    }

    @Test
    void updateUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int result = userMapper.updateUser();
        System.out.println(result);
        sqlSession.close();
    }

    @Test
    void deleteUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int result = userMapper.deleteUser();
        System.out.println(result);
        sqlSession.close();
    }

    @Test
    void selectUserById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectUserById();
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    void selectAllUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.selectAllUser());
        sqlSession.close();
    }

    @Test
    void selectUserByName() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.selectUserByName("admin"));
        sqlSession.close();
    }

    @Test
    void checkLogin() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.checkLogin("admin","123456"));
        sqlSession.close();
    }

    @Test
    void checkLoginByMap() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("username","admin");
        map.put("password","123456");
        System.out.println(userMapper.checkLoginByMap(map));
        sqlSession.close();
    }

    @Test
    void checkLoginByParam() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.checkLoginByParam("admin","123456"));
        sqlSession.close();
    }
}