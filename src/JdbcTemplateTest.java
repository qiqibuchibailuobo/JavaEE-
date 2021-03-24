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
	    // 加载配置文件
	    ApplicationContext applicationContext = 
	            new ClassPathXmlApplicationContext("applicationContext.xml");
	    // 获取AccountDao实例
	    CarDao carDao = 
	            (CarDao) applicationContext.getBean("carDao");
	    // 创建Account对象，并向Account对象中添加数据
	    Car car = new Car();
	    car.setColor("sss");
	    car.setNewdate(new Date());
	    // 执行addAccount()方法，并获取返回结果
	    int num = carDao.addCar(car);
	    if (num > 0) {
	        System.out.println("成功插入了" + num + "条数据！");
	    } else {
	        System.out.println("插入操作执行失败！");
	    }
	}
	
	@Test
	public void updateCarTest() {
	    // 加载配置文件
	    ApplicationContext applicationContext = 
	            new ClassPathXmlApplicationContext("applicationContext.xml");
	    // 获取AccountDao实例
	    CarDao carDao = 
	            (CarDao) applicationContext.getBean("carDao");
	    // 创建Account对象，并向Account对象中添加数据
	    Car car = new Car();
	    car.setId(8);
	    car.setColor("sss");
	    car.setNewdate(new Date());
	    // 执行updateAccount()方法，并获取返回结果
	    int num = carDao.updateCar(car);
	    if (num > 0) {
	        System.out.println("成功修改了" + num + "条数据！");
	    } else {
	        System.out.println("修改操作执行失败！");
	    }
	}
	
	@Test
	public void deleteCarTest() {
	    // 加载配置文件
	    ApplicationContext applicationContext = 
	            new ClassPathXmlApplicationContext("applicationContext.xml");
	    // 获取AccountDao实例
	    CarDao carDao = 
	            (CarDao) applicationContext.getBean("carDao");
	    // 执行deleteAccount()方法，并获取返回结果
	    int num = carDao.deleteCar(9);
	    if (num > 0) {
	        System.out.println("成功删除了" + num + "条数据！");
	    } else {
	        System.out.println("删除操作执行失败！");
	    }
	}

	@Test
	public void findCarByIdTest() {
	    // 加载配置文件
	    ApplicationContext applicationContext = 
	            new ClassPathXmlApplicationContext("applicationContext.xml");
	    // 获取AccountDao实例
	    CarDao carDao = 
	            (CarDao) applicationContext.getBean("carDao");
	    // 执行findAccountById()方法
	    Car car = carDao.findCarById(8);
	    System.out.println(car.getColor());
	}

	@Test
	public void findAllCarTest() {
	    // 加载配置文件
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
	    // 获取AccountDao实例
	    CarDao carDao = 
	            (CarDao) applicationContext.getBean("carDao");
	    // 执行findAllAccount()方法,获取Account对象的集合
	    List<Car> car = carDao.findAllCar();
	    // 循环输出集合中的对象
	    for (Car act : car) {
	        System.out.println(act);
	    }
	}
}