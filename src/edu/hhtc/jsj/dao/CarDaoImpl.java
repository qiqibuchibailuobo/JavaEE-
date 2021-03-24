package edu.hhtc.jsj.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.hhtc.jsj.bean.Car;


public class CarDaoImpl implements CarDao {
	// ����JdbcTemplate���Լ���setter����
		private JdbcTemplate jdbcTemplate;
		public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
			this.jdbcTemplate = jdbcTemplate;
		}
		@Override
		public int addCar(Car car) {
			String sql = "insert into car(color,newDate) value(?,?)";
			// �������������SQL����еĲ���
			Object[] obj = new Object[] { 
					car.getColor(), 
					car.getNewdate() 
	         };
			// ִ����Ӳ��������ص�����SQL���Ӱ��ļ�¼����
			int num = this.jdbcTemplate.update(sql, obj);
			return num;
			
		}
		@Override
		public int updateCar(Car car) {
			// ����SQL
			String sql = "update car set color=?,newDate=? where id = ?";
			// �������������SQL����еĲ���
			Object[] params = new Object[] { 
					car.getColor(), 
					car.getNewdate(),
					car.getId() 
	          };
			// ִ����Ӳ��������ص�����SQL���Ӱ��ļ�¼����
			int num = this.jdbcTemplate.update(sql, params);
			return num;
		}
		@Override
		public int deleteCar(Integer id) {
			// ����SQL
			String sql = "delete  from car where id = ? ";
			// ִ����Ӳ��������ص�����SQL���Ӱ��ļ�¼����
			int num = this.jdbcTemplate.update(sql, id);
			return num;
		}
		@Override
		public Car findCarById(Integer id) {
			String sql = "select * from car where id = ?";
		    // ����һ���µ�BeanPropertyRowMapper����
		    RowMapper<Car> rowMapper = 
		    		new BeanPropertyRowMapper<Car>(Car.class);
		    // ��id�󶨵�SQL����У���ͨ��RowMapper����һ��Object���͵ĵ��м�¼
		    return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
		}
		@Override
		public List<Car> findAllCar() {
			  // ����SQL���
		    String sql = "select * from car";
		    // ����һ���µ�BeanPropertyRowMapper����
		    RowMapper<Car> rowMapper = 
		new BeanPropertyRowMapper<Car>(Car.class);
		    // ִ�о�̬��SQL��ѯ����ͨ��RowMapper���ؽ��
		    return this.jdbcTemplate.query(sql, rowMapper);
		}
	

}
