package com.java.api.mybatis.main;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.java.api.mybatis.mapper.RoleMapper;
import com.java.api.mybatis.mapper.RoleMapper2;
import com.java.api.mybatis.pojo.Role;
import com.java.api.mybatis.utils.SqlSessionFactoryUtils;

public class Main {

	public static void main(String[] args) {
		//testRoleMapper();//xml对应的写法
		//testRoleMapper2();//接口写法
		testRoleMapper1();//测试insert、delete、select、update返回的东西  加入东西被回滚
	}
	
	private static void testRoleMapper1() {
		Logger log = Logger.getLogger(Main.class);
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			
			Role role = new Role();
			role.setRoleName("roleName1");
			role.setNote("note1");
			int insertRole = roleMapper.insertRole(role);
			
			System.out.println(insertRole);
			log.info(role.getRoleName());
			sqlSession.commit();//更改需要对sqlSession进行提交
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	private static void testRoleMapper() {
		Logger log = Logger.getLogger(Main.class);
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			Role role = roleMapper.getRole(1L);
			log.info(role.getRoleName());
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	//注解SQL测试
	private static void testRoleMapper2() {
		Logger log = Logger.getLogger(Main.class);
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			RoleMapper2 roleMapper2 = sqlSession.getMapper(RoleMapper2.class);
			Role role = roleMapper2.getRole(1L);
			log.info(role.getRoleName());
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
}
