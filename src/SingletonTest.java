import org.springframework.context.ApplicationContext;
import 
   org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.hhtc.jsj.annotation.UserController;
import edu.hhtc.jsj.dao.AccountDao;
public class SingletonTest{
	public static void main(String[] args) {
		// 定义配置文件路径
		String xmlPath = "applicationContext.xml";
		// 加载配置文件
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext(xmlPath);
		// 获取一个UserController实例
//		UserController userController1= 
//		  (UserController) applicationContext.getBean("userController");
//		// 获取另外一个UserController实例
//		UserController userController2= 
//		  (UserController) applicationContext.getBean("userController");
//        //测试是否是同一个
//       System.out.println( userController1== userController2);
		AccountDao accountDao = 
	            (AccountDao)applicationContext.getBean("accountDao");
			// 调用实例中的转账方法
			accountDao.transfer(2, 3, 0);
		    // 输出提示信息
		    System.out.println("转账成功！");

	}
}  