import org.springframework.context.ApplicationContext;
import 
   org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.hhtc.jsj.annotation.UserController;
public class SingletonTest{
	public static void main(String[] args) {
		// ���������ļ�·��
		String xmlPath = "autowire.xml";
		// ���������ļ�
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext(xmlPath);
		// ��ȡһ��UserControllerʵ��
		UserController userController1= 
		  (UserController) applicationContext.getBean("userController");
		// ��ȡ����һ��UserControllerʵ��
		UserController userController2= 
		  (UserController) applicationContext.getBean("userController");
        //�����Ƿ���ͬһ��
       System.out.println( userController1== userController2);

	}
}  