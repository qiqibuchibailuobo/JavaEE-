package edu.hhtc.jsj.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.hhtc.jsj.bean.Account;
import edu.hhtc.jsj.bean.Car;

public interface AccountDao {
	// 添加
		public int addCar(Account account);
		// 更新
		public int updateCar(Account account);
		// 删除
		public int deleteCar(Integer id);
		
		// 通过id查询
		public Account findCarById(Integer id);
		// 查询所有账户
		public List<Account> findAllCar();
		
		public void transfer(Integer oneid, Integer twoid, int money);
}
