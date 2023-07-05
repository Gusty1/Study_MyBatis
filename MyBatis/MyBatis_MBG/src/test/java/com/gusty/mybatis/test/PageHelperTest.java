package com.gusty.mybatis.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gusty.mybatis.mapper.EmpMapper;
import com.gusty.mybatis.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PageHelperTest {

    /**
     * limit index,pageSize
     * index: 當前頁的起始索引
     * pageSize: 每頁顯示的條數
     * pageNum: 當前頁的頁碼
     * index = (pageNum - 1) * pageSize
     *
     * 使用MyBatis的分頁插件實現分頁功能:
     * 1.需要在查詢功能之前開啟分頁
     * pageHelper.startPage(int pageNum, int pageSize);
     * 2.在查詢功能之後獲取分頁相關信息
     * PageInfo<Emp> page = new PageInfo<>(list,3);
     * list表示分頁數據
     * 3表示當前導航分頁的數量
     */
    @Test
    public void testPageHelper() {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

            //Page<Object> page = PageHelper.startPage(2, 4);
            PageHelper.startPage(2, 4);

            List<Emp> list = mapper.selectByExample(null);
            //list.forEach(emp -> System.out.println(emp));

            PageInfo<Emp> page = new PageInfo<>(list,3);
            System.out.println(page);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
