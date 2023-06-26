package com.gusty.mybatis.test;

import com.gusty.mybatis.mapper.ParameterMapper;
import com.gusty.mybatis.pojo.User;
import com.gusty.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.DriverManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ParameterTest {

    /**
     * MyBatis獲取參數值的2種方式"${}和#{}
     * ${}本質是字符串拼接
     * #{}本質是佔位賦值
     */

    //MyBatis獲取參數值的各種情況:
    @Test
    public void testGetUserByUsername() {
        /**
         * *1.mapper接口方法的參數為單個的字面量類型
         *可以通過${}和#{}以任意的字符串獲取參數值，但是需要注意${}的單引號問題
         */
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.getUserByUsername("爸爸");
        System.out.println(user);
    }

    @Test
    public void testCheckLogin() {
        /**
         * 2.mapper接口方法的參數為多個時
         *此時MyBatis會將這些參數放在一個map集合中，以2種方式進行存儲
         * a: arg0、arg1...為鍵，以參數為值
         * b: param1、param2...為鍵，以參數為值
         * 因此只需要通過#{}和${}以鍵的方式訪問值即可，但是需要注意${}的單引號問題
         */
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLogin("爸爸", "123456");
        System.out.println(user);
    }

    @Test
    public void testCheckLoginByMap() {
        /**
         * 3.若mapper接口方法的參數有多個時，可以手動將這些參數放在一個map中存儲
         *只需要通過#{}和${}以鍵的方式訪問值即可，但是需要注意${}的單引號問題
         *此時的鍵是自己設定的，跟2不一樣，不是arg0、arg1...
         */
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("username", "爸爸");
        map.put("password", "123456");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }

    @Test
    public void testInsertUser() {
        /**
         * 4.mapper接口方法的參數是實體類類型的參數
         * 只需要通過#{}和${}以屬性的方式訪問屬性值即可，但是需要注意${}的單引號問題
         */
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        int result = mapper.insertUser(new User(null,"小王","456",5,"女","456@gmail.com"));
        System.out.println(result);
    }

    @Test
    public void testCheckLoginByParam() {
        /**
         * 5.使用@Param命名參數
         *此時MyBatis會將這些參數放在一個map集合中，以2種方式進行存儲
         * a: 以@Param註解的值為鍵，以參數為值
         * b: param1、param2...為鍵，以參數為值
         * 只需要通過#{}和${}以鍵的方式訪問值即可，但是需要注意${}的單引號問題
         */
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLoginByParam("爸爸", "123456");
        System.out.println(user);
    }

    @Test
    public void testGetAllUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> list = mapper.getAllUser();
        list.forEach(user -> System.out.println(user));
    }

}
