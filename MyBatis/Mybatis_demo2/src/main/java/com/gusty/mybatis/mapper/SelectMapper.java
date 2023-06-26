package com.gusty.mybatis.mapper;

import com.gusty.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {

    /**
     * 根據id查詢用戶信息
     */
    User getUserById(@Param("id") Integer id);

    /**
     * 查詢所有的用戶信息
     */
    List<User> getAllUser();

    /**
     * 查詢用戶信息的總記錄數
     */
    Integer getCount();

    /**
     * 根據id查詢用戶信息唯一個map集合
     */
    Map<String, Object> getUserByIdToMap(@Param("id") Integer id);

    /**
     * 查詢所有用戶信息為map集合
     */
    //List<Map<String, Object>> getAllUserToMap();
    @MapKey("id")
    Map<String, Object> getAllUserToMap();
}
