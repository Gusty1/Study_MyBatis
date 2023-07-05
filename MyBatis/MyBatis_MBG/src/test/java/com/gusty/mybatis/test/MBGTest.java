package com.gusty.mybatis.test;

import com.gusty.mybatis.mapper.EmpMapper;
import com.gusty.mybatis.pojo.Emp;
import com.gusty.mybatis.pojo.EmpExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MBGTest {

    @Test
    public void testMBG(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory  = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

            //查詢所有數據
            /*List<Emp> list = mapper.selectByExample(null);
            System.out.println(list);*/

            //根據條件查詢
            /*EmpExample example = new EmpExample();
            example.createCriteria().andEmpNameEqualTo("小明").andAgeGreaterThan(10);
            List<Emp> list = mapper.selectByExample(example);
            System.out.println(list);*/

            //修改分成直接修改和選擇性修改，差別是選擇性修改若是null則不會寫到SQL中
            mapper.updateByPrimaryKeySelective(new Emp(9,"eee",40,null,"222@gmail.com",null));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
