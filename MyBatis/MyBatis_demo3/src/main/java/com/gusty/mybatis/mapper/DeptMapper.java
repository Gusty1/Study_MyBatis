package com.gusty.mybatis.mapper;

import com.gusty.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {

    /**
     * 通過分步查詢查詢員工以及員工所對應的部門信息
     * 分步查詢第二步: 通過did查詢所有員工所對應的部門
     */
    Dept getEmpAndDeptByStepTwo(@Param("did") Integer did);

    /**
     * 部門以及部門中所有的員工信息
     */
    Dept getDeptAndEmp(@Param("did") Integer did);

    /**
     * 通過分步查詢查詢部門及部門中所有員工的信息
     * 分步查詢第一步: 查詢部門信息
     */
    Dept getDeptAndEmpStepOne(@Param("did") Integer did);
}
