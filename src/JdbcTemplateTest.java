import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.hhtc.jsj.bean.Car;
import edu.hhtc.jsj.dao.CarDao;

public class JdbcTemplateTest {
	
	@Test
	public void addCarTest() {
	    // ���������ļ�
	    ApplicationContext applicationContext = 
	            new ClassPathXmlApplicationContext("applicationContext.xml");
	    // ��ȡAccountDaoʵ��
	    CarDao carDao = 
	            (CarDao) applicationContext.getBean("carDao");
	    // ����Account���󣬲���Account�������������
	    Car car = new Car();
	    car.setColor("sss");
	    car.setNewdate(new Date());
	    // ִ��addAccount()����������ȡ���ؽ��
	    int num = carDao.addCar(car);
	    if (num > 0) {
	        System.out.println("�ɹ�������" + num + "�����ݣ�");
	    } else {
	        System.out.println("�������ִ��ʧ�ܣ�");
	    }
	}
	
	@Test
	public void updateCarTest() {
	    // ���������ļ�
	    ApplicationContext applicationContext = 
	            new ClassPathXmlApplicationContext("applicationContext.xml");
	    // ��ȡAccountDaoʵ��
	    CarDao carDao = 
	            (CarDao) applicationContext.getBean("carDao");
	    // ����Account���󣬲���Account�������������
	    Car car = new Car();
	    car.setId(8);
	    car.setColor("sss");
	    car.setNewdate(new Date());
	    // ִ��updateAccount()����������ȡ���ؽ��
	    int num = carDao.updateCar(car);
	    if (num > 0) {
	        System.out.println("�ɹ��޸���" + num + "�����ݣ�");
	    } else {
	        System.out.println("�޸Ĳ���ִ��ʧ�ܣ�");
	    }
	}
	
	@Test
	public void deleteCarTest() {
	    // ���������ļ�
	    ApplicationContext applicationContext = 
	            new ClassPathXmlApplicationContext("applicationContext.xml");
	    // ��ȡAccountDaoʵ��
	    CarDao carDao = 
	            (CarDao) applicationContext.getBean("carDao");
	    // ִ��deleteAccount()����������ȡ���ؽ��
	    int num = carDao.deleteCar(9);
	    if (num > 0) {
	        System.out.println("�ɹ�ɾ����" + num + "�����ݣ�");
	    } else {
	        System.out.println("ɾ������ִ��ʧ�ܣ�");
	    }
	}

	@Test
	public void findCarByIdTest() {
	    // ���������ļ�
	    ApplicationContext applicationContext = 
	            new ClassPathXmlApplicationContext("applicationContext.xml");
	    // ��ȡAccountDaoʵ��
	    CarDao carDao = 
	            (CarDao) applicationContext.getBean("carDao");
	    // ִ��findAccountById()����
	    Car car = carDao.findCarById(8);
	    System.out.println(car.getColor());
	}

	@Test
	public void findAllCarTest() {
	    // ���������ļ�
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
	    // ��ȡAccountDaoʵ��
	    CarDao carDao = 
	            (CarDao) applicationContext.getBean("carDao");
	    // ִ��findAllAccount()����,��ȡAccount����ļ���
	    List<Car> car = carDao.findAllCar();
	    // ѭ����������еĶ���
	    for (Car act : car) {
	        System.out.println(act);
	    }
	}
}