package edu.hhtc.jsj.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.hhtc.jsj.bean.Car;

public interface CarDao {
	// ���
		public int addCar(Car car);
		// ����
		public int updateCar(Car car);
		// ɾ��
		public int deleteCar(Integer id);
		
		// ͨ��id��ѯ
		public Car findCarById(Integer id);
		// ��ѯ�����˻�
		public List<Car> findAllCar();
}
