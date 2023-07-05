package com.gusty.mybatis.test;

import com.gusty.mybatis.mapper.DeptMapper;
import com.gusty.mybatis.mapper.EmpMapper;
import com.gusty.mybatis.pojo.Dept;
import com.gusty.mybatis.pojo.Emp;
import com.gusty.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class ResultMapTest {

    /**
     * 解決字段名和屬性名不一致的情況
     * a. 為字段起別名，保持和屬性名的一致
     * b. 設置全局配置，將_自動映射為駝峰
     * <setting name="mapUnderscoreToCamelCase" value="true"/>
     * c. 通過resultMap設置自訂義的映射關係
     * <resultMap id="empResultMap" type="Emp">
     *   <id property="eid" column="eid"></id>
     *   <result property="empName" column="emp_name"></result>
     *   <result property="age" column="age"></result>
     *   <result property="sex" column="sex"></result>
     *   <result property="email" column="email"></result>
     * </resultMap>
     *
     * 處理多對一的映射關係:
     * a. 級聯屬性賦值
     * b. association
     * c. 分步查詢
     *
     * 處理一對多的映射關係
     * a. collection
     * b. 分步查詢
     */

    @Test
    public void testGetAllEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> list = mapper.getAllEmp();
        list.forEach(emp -> System.out.println(emp));
    }

    @Test
    public void testGetEmpAndDept(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDept(1);
        System.out.println(emp);
    }

    @Test
    public void testGetEmpAndDeptByStep(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptByStepOne(1);
        System.out.println(emp.getEmpName());
        System.out.println("==================================");
        System.out.println(emp.getDept());
    }

    @Test
    public void testGetDeptAndEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmp(1);
        System.out.println(dept);
    }

    @Test
    public void testGetDeptAndEmpByStep(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmpStepOne(1);
//        System.out.println(dept);
        System.out.println(dept.getDeptName());
    }
}
