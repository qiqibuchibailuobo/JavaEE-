package edu.hhtc.jsj.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("customerDaoImpl")
public class CustomerDaoImpl implements CustomerDao {

	@Override
	public void Withdraw() {
		System.out.println("���ȡ�����");
	}

	@Override
	public void deposit() {
		System.out.println("��ɴ�����");
	}

	

}