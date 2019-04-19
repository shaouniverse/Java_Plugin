package com.java.api.mybatis.main;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.java.api.mybatis.mapper.RoleMapper;
import com.java.api.mybatis.mapper.RoleMapper2;
import com.java.api.mybatis.pojo.Role;
import com.java.api.mybatis.utils.SqlSessionFactoryUtils;

public class Main {

	public static void main(String[] args) {
		testRoleMapper();
		testRoleMapper2();
		
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
