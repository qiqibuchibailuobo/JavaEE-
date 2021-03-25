package edu.hhtc.jsj.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.hhtc.jsj.bean.Account;
import edu.hhtc.jsj.bean.Car;


public class AccountDaoImpl implements AccountDao {
	// 声明JdbcTemplate属性及其setter方法
		private JdbcTemplate jdbcTemplate;
		public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
			this.jdbcTemplate = jdbcTemplate;
		}
		@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
		@Override
		public int addCar(Account account) {
			String sql = "insert into account(name,money) value(?,?)";
			// 定义数组来存放SQL语句中的参数
			Object[] obj = new Object[] { 
					account.getName(), 
					account.getMoney() 
	         };
			// 执行添加操作，返回的是受SQL语句影响的记录条数
			int num = this.jdbcTemplate.update(sql, obj);
			return num;
			
		}
		@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
		@Override
		public int updateCar(Account account) {
			// 定义SQL
			String sql = "update account set name=?,money=? where id = ?";
			// 定义数组来存放SQL语句中的参数
			Object[] params = new Object[] { 
					account.getName(), 
					account.getMoney(),
					account.getId() 
	          };
			// 执行添加操作，返回的是受SQL语句影响的记录条数
			int num = this.jdbcTemplate.update(sql, params);
			return num;
		}
		@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
		@Override
		public int deleteCar(Integer id) {
			// 定义SQL
			String sql = "delete  from account where id = ? ";
			// 执行添加操作，返回的是受SQL语句影响的记录条数
			int num = this.jdbcTemplate.update(sql, id);
			return num;
		}
		@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
		@Override
		public Account findCarById(Integer id) {
			String sql = "select * from account where id = ?";
		    // 创建一个新的BeanPropertyRowMapper对象
		    RowMapper<Account> rowMapper = 
		    		new BeanPropertyRowMapper<Account>(Account.class);
		    // 将id绑定到SQL语句中，并通过RowMapper返回一个Object类型的单行记录
		    return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
		}
		@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
		@Override
		public List<Account> findAllCar() {
			  // 定义SQL语句
		    String sql = "select * from account";
		    // 创建一个新的BeanPropertyRowMapper对象
		    RowMapper<Account> rowMapper = 
		new BeanPropertyRowMapper<Account>(Account.class);
		    // 执行静态的SQL查询，并通过RowMapper返回结果
		    return this.jdbcTemplate.query(sql, rowMapper);
		}
	
		
		@Transactional(propagation = Propagation.REQUIRED,
				isolation = Isolation.DEFAULT, readOnly = false)
		@Override
		public void transfer(Integer outUserID, Integer inUserID, int money) {
			String sql = "select * from account where name = ?";

			Account a;
			Account b;
			try {
				a = this.findCarById(outUserID);
				b = this.findCarById(inUserID);
			}catch (Exception e){
				throw new RuntimeException("操作账户不存在");
			}

			if(a.getMoney()<money){
				throw new RuntimeException("余额不足，不能执行转账");
			}


			// 收款时，收款用户的余额=现有余额+所汇金额
			this.jdbcTemplate.update("update account set money = money +? "
					+ "where id = ?",money, inUserID);
			// 模拟系统运行时的突发性问题
//		    int i = 1/0;
			// 汇款时，汇款用户的余额=现有余额-所汇金额
			this.jdbcTemplate.update("update account set money = money-? "
					+ "where id = ?",money, outUserID);


		}

}
