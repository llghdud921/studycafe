package com.work.spring03.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.work.spring03.dao.MainDAO;
import com.work.spring03.dao.TicketDAO;

@Service
public class MainService {

	/* spring di : setter injection */
	private MainDAO Mdao;
	
	@Autowired
	public void setMdao(MainDAO Mdao) {
		this.Mdao = Mdao;
	}
	
}
