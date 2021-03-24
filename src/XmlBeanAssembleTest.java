import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.hhtc.jsj.bean.Car;
import edu.hhtc.jsj.bean.User;
import edu.hhtc.jsj.dao.CarDao;

public class XmlBeanAssembleTest {
	public static void main(String[] args) {
		//定义配置文件路径
		String xmlpath="applicationContext.xml";
		//加载配置文件
		ApplicationContext ac=new ClassPathXmlApplicationContext(xmlpath);
		//测试构造注入方式的bean
//		User user1=(User)ac.getBean("user1");
//		//输出成员值
//		//测试setting方式注入的Bean
//		User user2=(User)ac.getBean("user2");
//		//输出成员值
//		System.out.println(user1.getUsername());
//		System.out.println(user2.getUsername());
		 CarDao carDao = 
		            (CarDao) ac.getBean("carDao");
		    // 执行findAllAccount()方法,获取Account对象的集合
		    List<Car> car = carDao.findAllCar();
		    // 循环输出集合中的对象
		    for (Car act : car) {
		        System.out.println(act);
		    }
	}
}
