package com.gusty.mybatis.test;

import com.gusty.mybatis.mapper.SelectMapper;
import com.gusty.mybatis.pojo.User;
import com.gusty.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class SelectMapperTest {

    /**
     * MyBatis的各種查詢功能
     * 1.若查詢出的數據只有一條
     * a: 可以通過實體類或集合接收對象
     * b: 可以通過list集合接收
     * c: 可以通過map集合接收
     * 結果範例: {password=123456, sex=男, id=3, age=20, email=123@gmail.com, username=爸爸}
     *
     * 2.若查詢出的數據有多條，
     * a: 可以通過list集合接收
     * b: 可以通過map集合接收
     * c: 可以在mapper的接口方法上添加@MapKey註解，此時就可以將每條數據轉換的map集合作為值，以某個字段的值作為鍵，放在同一個map集合中
     * *: 一定不能通過實體類接收對象，此時會報錯TooManyResultException
     *
     * MyBatis設置了默認的類型別名
     * java.lang.Integer-->int，integer
     * int-->_int,_integer
     * Map-->map
     * String-->string
     */

    @Test
    public void testGetAllUserToMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getAllUserToMap());
    }

    @Test
    public void testGetUserByIdToMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getUserByIdToMap(3));
    }

    @Test
    public void testGetCount(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getCount());
    }

    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getAllUser());
    }

    @Test
    public void testGetUserById(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User user = mapper.getUserById(3);
        System.out.println(user);
    }
}
