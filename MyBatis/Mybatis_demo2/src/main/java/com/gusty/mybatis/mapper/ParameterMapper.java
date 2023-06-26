package com.gusty.mybatis.mapper;

import com.gusty.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Objects;


public interface ParameterMapper {

    /**
     * 驗證登錄(使用@Param)
     */
    User checkLoginByParam(@Param(value = "username") String username, @Param(value = "password") String password);

    /**
     * 添加用戶信息
     */
    int insertUser(User user);

    /**
     * 驗證登錄(參數為map)
     */
    User checkLoginByMap(Map<String, Object> map);

    /**
     * 驗證登錄
     */
    User checkLogin(String username, String password);

    /**
     * 根據用戶名查詢用戶信息
     */
    User getUserByUsername(String username);

    /**
     * 查詢所有員工信息
     */
    List<User> getAllUser();
}
