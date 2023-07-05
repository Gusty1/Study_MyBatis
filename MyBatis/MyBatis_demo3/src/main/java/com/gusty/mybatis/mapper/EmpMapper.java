package com.gusty.mybatis.mapper;

import com.gusty.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {

    /**
     * 查詢所有員工信息
     */
    List<Emp> getAllEmp();

    /**
     * 查詢員工及所對應的部門信息
     */
    Emp getEmpAndDept(@Param("eid") Integer eid);

    /**
     * 通過分步查詢查詢員工以及員工所對應的部門信息
     * 分步查詢第一步: 查詢員工信息
     */
    Emp getEmpAndDeptByStepOne(Integer eid);

    /**
     * 通過分步查詢查詢部門及部門中所有員工的信息
     * 分步查詢第二步: 根據did查詢員工信息
     */
    List<Emp> getDeptAndEmpByStepTwo(@Param("did") Integer did);
}
