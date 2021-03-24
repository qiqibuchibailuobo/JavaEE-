package edu.hhtc.jsj.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("customerDaoImpl")
public class CustomerDaoImpl implements CustomerDao {

	@Override
	public void Withdraw() {
		System.out.println("完成取款操作");
	}

	@Override
	public void deposit() {
		System.out.println("完成存款操作");
	}

	

}