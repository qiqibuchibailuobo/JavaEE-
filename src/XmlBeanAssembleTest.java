import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.hhtc.jsj.bean.Car;
import edu.hhtc.jsj.bean.User;
import edu.hhtc.jsj.dao.CarDao;

public class XmlBeanAssembleTest {
	public static void main(String[] args) {
		//���������ļ�·��
		String xmlpath="applicationContext.xml";
		//���������ļ�
		ApplicationContext ac=new ClassPathXmlApplicationContext(xmlpath);
		//���Թ���ע�뷽ʽ��bean
//		User user1=(User)ac.getBean("user1");
//		//�����Աֵ
//		//����setting��ʽע���Bean
//		User user2=(User)ac.getBean("user2");
//		//�����Աֵ
//		System.out.println(user1.getUsername());
//		System.out.println(user2.getUsername());
		 CarDao carDao = 
		            (CarDao) ac.getBean("carDao");
		    // ִ��findAllAccount()����,��ȡAccount����ļ���
		    List<Car> car = carDao.findAllCar();
		    // ѭ����������еĶ���
		    for (Car act : car) {
		        System.out.println(act);
		    }
	}
}
