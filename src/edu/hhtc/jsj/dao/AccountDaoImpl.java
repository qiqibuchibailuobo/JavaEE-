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
	// ����JdbcTemplate���Լ���setter����
		private JdbcTemplate jdbcTemplate;
		public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
			this.jdbcTemplate = jdbcTemplate;
		}
		@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
		@Override
		public int addCar(Account account) {
			String sql = "insert into account(name,money) value(?,?)";
			// �������������SQL����еĲ���
			Object[] obj = new Object[] { 
					account.getName(), 
					account.getMoney() 
	         };
			// ִ����Ӳ��������ص�����SQL���Ӱ��ļ�¼����
			int num = this.jdbcTemplate.update(sql, obj);
			return num;
			
		}
		@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
		@Override
		public int updateCar(Account account) {
			// ����SQL
			String sql = "update account set name=?,money=? where id = ?";
			// �������������SQL����еĲ���
			Object[] params = new Object[] { 
					account.getName(), 
					account.getMoney(),
					account.getId() 
	          };
			// ִ����Ӳ��������ص�����SQL���Ӱ��ļ�¼����
			int num = this.jdbcTemplate.update(sql, params);
			return num;
		}
		@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
		@Override
		public int deleteCar(Integer id) {
			// ����SQL
			String sql = "delete  from account where id = ? ";
			// ִ����Ӳ��������ص�����SQL���Ӱ��ļ�¼����
			int num = this.jdbcTemplate.update(sql, id);
			return num;
		}
		@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
		@Override
		public Account findCarById(Integer id) {
			String sql = "select * from account where id = ?";
		    // ����һ���µ�BeanPropertyRowMapper����
		    RowMapper<Account> rowMapper = 
		    		new BeanPropertyRowMapper<Account>(Account.class);
		    // ��id�󶨵�SQL����У���ͨ��RowMapper����һ��Object���͵ĵ��м�¼
		    return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
		}
		@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
		@Override
		public List<Account> findAllCar() {
			  // ����SQL���
		    String sql = "select * from account";
		    // ����һ���µ�BeanPropertyRowMapper����
		    RowMapper<Account> rowMapper = 
		new BeanPropertyRowMapper<Account>(Account.class);
		    // ִ�о�̬��SQL��ѯ����ͨ��RowMapper���ؽ��
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
				throw new RuntimeException("�����˻�������");
			}

			if(a.getMoney()<money){
				throw new RuntimeException("���㣬����ִ��ת��");
			}


			// �տ�ʱ���տ��û������=�������+������
			this.jdbcTemplate.update("update account set money = money +? "
					+ "where id = ?",money, inUserID);
			// ģ��ϵͳ����ʱ��ͻ��������
//		    int i = 1/0;
			// ���ʱ������û������=�������-������
			this.jdbcTemplate.update("update account set money = money-? "
					+ "where id = ?",money, outUserID);


		}

}
