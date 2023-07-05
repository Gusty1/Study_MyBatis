package com.gusty.mybatis.mapper;

import com.gusty.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicSQLMapper {

    /**
     * 多條件查詢
     */
    List<Emp> getEmpByCondition(Emp emp);

    /**
     * 測試choose、when、otherwise
     */
    List<Emp> getEmpByChoose(Emp emp);

    /**
     * 通過數組實現批量刪除
     */
    int deleteMoreByArray(@Param("eids") Integer[] eids);

    /**
     * 通過list集合實現批量添加
     */
    int insertMoreByList(@Param("emps") List<Emp> emps);
}
