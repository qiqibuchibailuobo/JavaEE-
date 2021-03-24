package edu.hhtc.jsj.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.hhtc.jsj.bean.Car;


public class CarDaoImpl implements CarDao {
	// 声明JdbcTemplate属性及其setter方法
		private JdbcTemplate jdbcTemplate;
		public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
			this.jdbcTemplate = jdbcTemplate;
		}
		@Override
		public int addCar(Car car) {
			String sql = "insert into car(color,newDate) value(?,?)";
			// 定义数组来存放SQL语句中的参数
			Object[] obj = new Object[] { 
					car.getColor(), 
					car.getNewdate() 
	         };
			// 执行添加操作，返回的是受SQL语句影响的记录条数
			int num = this.jdbcTemplate.update(sql, obj);
			return num;
			
		}
		@Override
		public int updateCar(Car car) {
			// 定义SQL
			String sql = "update car set color=?,newDate=? where id = ?";
			// 定义数组来存放SQL语句中的参数
			Object[] params = new Object[] { 
					car.getColor(), 
					car.getNewdate(),
					car.getId() 
	          };
			// 执行添加操作，返回的是受SQL语句影响的记录条数
			int num = this.jdbcTemplate.update(sql, params);
			return num;
		}
		@Override
		public int deleteCar(Integer id) {
			// 定义SQL
			String sql = "delete  from car where id = ? ";
			// 执行添加操作，返回的是受SQL语句影响的记录条数
			int num = this.jdbcTemplate.update(sql, id);
			return num;
		}
		@Override
		public Car findCarById(Integer id) {
			String sql = "select * from car where id = ?";
		    // 创建一个新的BeanPropertyRowMapper对象
		    RowMapper<Car> rowMapper = 
		    		new BeanPropertyRowMapper<Car>(Car.class);
		    // 将id绑定到SQL语句中，并通过RowMapper返回一个Object类型的单行记录
		    return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
		}
		@Override
		public List<Car> findAllCar() {
			  // 定义SQL语句
		    String sql = "select * from car";
		    // 创建一个新的BeanPropertyRowMapper对象
		    RowMapper<Car> rowMapper = 
		new BeanPropertyRowMapper<Car>(Car.class);
		    // 执行静态的SQL查询，并通过RowMapper返回结果
		    return this.jdbcTemplate.query(sql, rowMapper);
		}
	

}
