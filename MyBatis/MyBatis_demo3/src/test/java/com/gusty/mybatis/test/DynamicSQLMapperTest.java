package com.gusty.mybatis.test;

import com.gusty.mybatis.mapper.DynamicSQLMapper;
import com.gusty.mybatis.pojo.Emp;
import com.gusty.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DynamicSQLMapperTest {

    /**
     * 動態SQL:
     * 1. if: 根據標籤中test屬性所對應的表達式決定標籤中的內容是否需要拼接到SQL中
     * 2. where:
     * 當where標籤中有內容時，會自動生成where關鍵字，並將內容前多餘的and或or去掉
     * 當where標籤中沒有內容時，此時where標籤沒有任何效果
     * 注意: where標籤不能將其中內容後面多餘的and或or去掉
     * 3. trim:
     * 若標籤中有內容時:
     * prefix | suffix: 將trim標籤中內容前面或後面添加指定內容
     * suffixOverrides | prefixOverrides: 將trim標籤中內容前面或後面去掉指定內容
     * 若標籤中沒有內容時，trim標籤也沒有任何效果
     * 4. choose、when、otherwise，相當於if...else if...else
     * when至少要有一個，otherwise最多只能有一個
     * 5. foreach
     * collection: 設置需要循環的數組或集合
     * item: 表示數組或集合中的每一個數據
     * separator: 循環體之間的分隔符
     * open: foreach標籤所循環的所有內容的開始符
     * close: foreach標籤所循環的所有內容的結束符
     * 6. sql標籤
     * 設置SQL片段: <sql id="empColumns">eid,emp_name,age,sex,email</sql>
     * 引用SQL片段: <include refid="empColumns"/>
     */

    @Test
    public void testInsertMoreByList(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp1 = new Emp(null,"F1",55,"男","333@gmail.com");
        Emp emp2 = new Emp(null,"F2",55,"男","333@gmail.com");
        Emp emp3 = new Emp(null,"F3",55,"男","333@gmail.com");
        List<Emp> emps = Arrays.asList(emp1, emp2, emp3);
        System.out.println(mapper.insertMoreByList(emps));
    }

    @Test
    public void testDeleteMoreByArray(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        int result = mapper.deleteMoreByArray(new Integer[]{6, 7, 8});
        System.out.println(result);
    }

    @Test
    public void testGetEmpByChoose(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> list = mapper.getEmpByChoose(new Emp(null,"",null,"",""));
        System.out.println(list);
    }

    @Test
    public void testGetEmpByCondition(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> list = mapper.getEmpByCondition(new Emp(null,"小明",20,"",""));
        System.out.println(list);
    }
}
