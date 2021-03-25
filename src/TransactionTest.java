import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.hhtc.jsj.dao.AccountDao;

public class TransactionTest {
	@Test
	public void xmlTest(){
		ApplicationContext applicationContext = 
		   new ClassPathXmlApplicationContext("applicationContext.xml");
		// ��ȡAccountDaoʵ��
		AccountDao accountDao = 
            (AccountDao)applicationContext.getBean("accountDao");
		// ����ʵ���е�ת�˷���
		accountDao.transfer(2, 3, 200);
	    // �����ʾ��Ϣ
	    System.out.println("ת�˳ɹ���");
	}
	
	@Test
	public void annotationTest(){
	    ApplicationContext applicationContext = 
	new ClassPathXmlApplicationContext("applicationContext.xml");
	    // ��ȡAccountDaoʵ��
	    AccountDao accountDao = 
	(AccountDao)applicationContext.getBean("accountDao");
	    // ����ʵ���е�ת�˷���
	    accountDao.transfer(2, 3, 100);
	    // �����ʾ��Ϣ
	    System.out.println("ת�˳ɹ���");
	}

}