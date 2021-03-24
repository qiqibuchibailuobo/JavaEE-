package edu.hhtc.jsj.annotation;
import org.springframework.stereotype.Repository;
@Repository("userDao") 
public class UserDao{
   public void save(){
	  System.out.println("userdao...save...");
   }
   
}