package com.gusty.mybatis.mapper;

import com.gusty.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SQLMapper {

    /**
     * 根據用戶名模糊查詢用戶信息
     */
    List<User> getUserByLike(@Param("username") String username);

    /**
     * 批量刪除
    */
    int deleteMore(@Param("ids") String ids);

    /**
     * 查詢指定表中的數據
     */
    List<User> getUserByTableName(@Param("tableName") String tableName);

    /**
    * 添加用戶信息
    */
    void insertUser(User user);
}
