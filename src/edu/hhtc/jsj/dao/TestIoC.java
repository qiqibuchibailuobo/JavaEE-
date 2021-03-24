package edu.hhtc.jsj.dao;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.hhtc.jsj.dao.CustomerDao;

public class TestIoC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerDao customerDao = (CustomerDao)applicationContext.getBean("customerDaoImpl");
		customerDao.Withdraw();
		customerDao.deposit();
		System.out.println(1+2+"3");
	}

}
