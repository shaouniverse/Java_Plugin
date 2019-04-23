package com.java.api.mybatis.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import com.java.api.mybatis.mapper.RoleMapper;
import com.java.api.mybatis.mapper.RoleMapper2;
import com.java.api.mybatis.pojo.Role;


public class SqlSessionFactoryUtils {

	private final static Class<SqlSessionFactoryUtils> LOCK = SqlSessionFactoryUtils.class;

	private static SqlSessionFactory sqlSessionFactory = null;

	private SqlSessionFactoryUtils() {
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		synchronized (LOCK) {
			if (sqlSessionFactory != null) {
				return sqlSessionFactory;
			}
			//String resource = "mybatis-config.xml";
			//String resource = "mybatis-config-xml.xml";
			String resource = "mybatis-config-properties.xml";
			
			InputStream inputStream;
			try {
				inputStream = Resources.getResourceAsStream(resource);
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
			return sqlSessionFactory;
		}
	}
	
	
	//代码生成SqlSessionFactory
	public static SqlSessionFactory getSqlSessionFactory2() {
		synchronized (LOCK) {
			//数据库连接池信息
			PooledDataSource dataSource = new PooledDataSource();
			//com.mysql.cj.jdbc.Driver不使用这个会警告，但是不影响使用
			dataSource.setDriver("com.mysql.jdbc.Driver");
			dataSource.setUsername("root");
			dataSource.setPassword("root");
			//?serverTimezone=GMT%2B8   时间错误
			//&amp;   与符号还有;
			//useSSL=false  SSL报错
			dataSource.setUrl("jdbc:mysql://localhost:3306/world?serverTimezone=GMT%2B8&amp;useSSL=false");
			dataSource.setDefaultAutoCommit(false);
			//采用MyBatis的JDBC事务方式
			TransactionFactory transactionFactory = new JdbcTransactionFactory();
			Environment environment = new Environment("development", transactionFactory, dataSource);
			//创建Configuration对象
			Configuration configuration = new Configuration(environment);
			//注册一个MyBatis上下文别名
			configuration.getTypeAliasRegistry().registerAlias("role", Role.class);
			//加入一个映射器
			configuration.addMapper(RoleMapper.class);
			configuration.addMapper(RoleMapper2.class);
			//使用SqlSessionFactoryBuilder构建SqlSessionFactory
			sqlSessionFactory = 
			    new SqlSessionFactoryBuilder().build(configuration);
			return sqlSessionFactory; 	
		}
	}

	public static SqlSession openSqlSession() {
		if (sqlSessionFactory == null) {
			getSqlSessionFactory();
		}
		return sqlSessionFactory.openSession();
	}
}