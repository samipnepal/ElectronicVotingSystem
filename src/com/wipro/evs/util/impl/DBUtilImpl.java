package com.wipro.evs.util.impl;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.wipro.evs.util.DBUtil;

public class DBUtilImpl implements DBUtil {
	
	@SuppressWarnings("deprecation")
	@Override
	public SessionFactory getDBConnection() {
		SessionFactory sessionFactory;
		sessionFactory	=new Configuration()
		.setProperty("hibernate.dialect", "org.hibernate.dialect.OracleDialect")
		.setProperty("hibernate.connection.driver_class", "oracle.jdbc.driver.OracleDriver")
		.setProperty("hibernate.connection.url", "jdbc:oracle:thin:@localhost:1521:orcl")
		.setProperty("hibernate.connection.username", "hr")
		.setProperty("hibernate.connection.password", "hr")
		.configure()
		.buildSessionFactory();
		return sessionFactory;
	}

}
