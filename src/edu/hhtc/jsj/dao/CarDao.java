package edu.hhtc.jsj.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.hhtc.jsj.bean.Car;

public interface CarDao {
	// 添加
		public int addCar(Car car);
		// 更新
		public int updateCar(Car car);
		// 删除
		public int deleteCar(Integer id);
		
		// 通过id查询
		public Car findCarById(Integer id);
		// 查询所有账户
		public List<Car> findAllCar();
}
