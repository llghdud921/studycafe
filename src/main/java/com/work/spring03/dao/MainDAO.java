package com.work.spring03.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MainDAO {

	/* spring di : setter injection */
	private FactoryDAODataSource factory;
	@Autowired
	public void setFactory(FactoryDAODataSource factory) {
		this.factory = factory;
	}
	
	private static MainDAO instance = new MainDAO();
	
	public static MainDAO getInstance() {
		return instance;
	}
}
