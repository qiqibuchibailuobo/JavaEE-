import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.hhtc.jsj.dao.AccountDao;

public class TransactionTest {
	@Test
	public void xmlTest(){
		ApplicationContext applicationContext = 
		   new ClassPathXmlApplicationContext("applicationContext.xml");
		// 获取AccountDao实例
		AccountDao accountDao = 
            (AccountDao)applicationContext.getBean("accountDao");
		// 调用实例中的转账方法
		accountDao.transfer(2, 3, 200);
	    // 输出提示信息
	    System.out.println("转账成功！");
	}
	
	@Test
	public void annotationTest(){
	    ApplicationContext applicationContext = 
	new ClassPathXmlApplicationContext("applicationContext.xml");
	    // 获取AccountDao实例
	    AccountDao accountDao = 
	(AccountDao)applicationContext.getBean("accountDao");
	    // 调用实例中的转账方法
	    accountDao.transfer(2, 3, 100);
	    // 输出提示信息
	    System.out.println("转账成功！");
	}

}