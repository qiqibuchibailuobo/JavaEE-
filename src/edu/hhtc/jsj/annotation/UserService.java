package edu.hhtc.jsj.annotation;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
@Service("userService") 
public class UserService{
	@Resource(name="userDao") 
	private UserDao userDao;
	public void save() {
         //����userDao�е�save����
		this.userDao.save();
		System.out.println("userservice....save...");
	}
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}