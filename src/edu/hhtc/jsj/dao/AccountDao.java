package edu.hhtc.jsj.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.hhtc.jsj.bean.Account;
import edu.hhtc.jsj.bean.Car;

public interface AccountDao {
	// ���
		public int addCar(Account account);
		// ����
		public int updateCar(Account account);
		// ɾ��
		public int deleteCar(Integer id);
		
		// ͨ��id��ѯ
		public Account findCarById(Integer id);
		// ��ѯ�����˻�
		public List<Account> findAllCar();
		
		public void transfer(Integer oneid, Integer twoid, int money);
}
