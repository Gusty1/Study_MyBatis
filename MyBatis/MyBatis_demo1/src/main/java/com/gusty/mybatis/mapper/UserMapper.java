package com.gusty.mybatis.mapper;

import com.gusty.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {

    /**
     * Mybatis面向接口編程的2個一致
     * 1.mapper映射文件的namespace要和mapper接口的全類名保持一致
     * 2.映射文件中SQL語句的id要和mapper接口中的方法保持一致
     *
     * 表-->實體類-->mapper接口-->映射文件
     */

    /**
     * 添加用戶信息
     */
    int insertUser();

    /**
     * 修改用戶信息
     */
    void updateUser();

    /**
     * 刪除用戶信息
     */
    void deleteUser();

    /**
     * 根據id查詢用戶信息
     */
    User getUserById();

    /**
     * 查詢所有的用戶信息
     */
    List<User> getAllUser();
}
