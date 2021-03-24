

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.hhxy.jsj.constructor.Bean1;
import edu.hhxy.jsj.dao.UserDao;
import edu.hhxy.jsj.service.UserService;

public class InstanceTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String xmlPath = "edu/hhxy/jsj/constructor/beans1.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
//		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
//		userDao.say();
		Bean1 bean = (Bean1)applicationContext.getBean("bean1");
		System.out.println(bean);
	}

}
