import org.springframework.context.ApplicationContext;
import 
   org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.hhtc.jsj.annotation.UserController;
public class SingletonTest{
	public static void main(String[] args) {
		// 定义配置文件路径
		String xmlPath = "autowire.xml";
		// 加载配置文件
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext(xmlPath);
		// 获取一个UserController实例
		UserController userController1= 
		  (UserController) applicationContext.getBean("userController");
		// 获取另外一个UserController实例
		UserController userController2= 
		  (UserController) applicationContext.getBean("userController");
        //测试是否是同一个
       System.out.println( userController1== userController2);

	}
}  