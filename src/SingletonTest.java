import org.springframework.context.ApplicationContext;
import 
   org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.hhtc.jsj.annotation.UserController;
import edu.hhtc.jsj.dao.AccountDao;
public class SingletonTest{
	public static void main(String[] args) {
		// ���������ļ�·��
		String xmlPath = "applicationContext.xml";
		// ���������ļ�
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext(xmlPath);
		// ��ȡһ��UserControllerʵ��
//		UserController userController1= 
//		  (UserController) applicationContext.getBean("userController");
//		// ��ȡ����һ��UserControllerʵ��
//		UserController userController2= 
//		  (UserController) applicationContext.getBean("userController");
//        //�����Ƿ���ͬһ��
//       System.out.println( userController1== userController2);
		AccountDao accountDao = 
	            (AccountDao)applicationContext.getBean("accountDao");
			// ����ʵ���е�ת�˷���
			accountDao.transfer(2, 3, 0);
		    // �����ʾ��Ϣ
		    System.out.println("ת�˳ɹ���");

	}
}  