

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.hhtc.jsj.dao.CustomerDao;
import edu.hhtc.jsj.dao.CustomerDaoImpl;
import edu.hhxy.jsj.dao.UserDao;
import edu.hhxy.jsj.service.UserService;

public class TestIoC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
//		userDao.say();
		CustomerDao customerDao = (CustomerDao)applicationContext.getBean("customerDaoImpl");
		customerDao.Withdraw();
		//customerDao.deposit();
//		UserService userService = (UserService) applicationContext.getBean("userService");
//		userService.say();
		
	}

}
