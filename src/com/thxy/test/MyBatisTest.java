package com.thxy.test;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.thxy.dao.user.UserMapper;
import com.thxy.datasource.DataConnection;
import com.thxy.pojo.User;

public class MyBatisTest {
	
	public DataConnection dataConn=new DataConnection();
	
	@Test
	public void Select() throws IOException {
		SqlSession sqlSession=dataConn.getSqlSession();
		
	//下面这句话是当有xml文件时开启，其中"user.findUserById"的user对应UserMapper.xml的mapper的namespace属性，findUserId对应UserMapper.xml中方法的id值
	//	User user=sqlSession.selectOne("user.findUserById",4);
		User user = sqlSession.getMapper(UserMapper.class).findUserById(3);
		System.out.println("id:"+user.getId());
		System.out.println("姓名:"+user.getName());
		
		sqlSession.close();
	}
}
