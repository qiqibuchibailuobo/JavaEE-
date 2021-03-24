import org.springframework.context.ApplicationContext;
import 
   org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.hhtc.jsj.annotation.UserController;
public class AutowireTest {
	public static void main(String[] args) {
		// ���������ļ�·��
		String xmlPath = "autowire.xml";
		// ���������ļ�
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext(xmlPath);
		// ��ȡUserControllerʵ��
		UserController userController = 
		  (UserController) applicationContext.getBean("userController");
		// ����UserController�е�save()����
		userController.save();
	}
}