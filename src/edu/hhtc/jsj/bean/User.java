package edu.hhtc.jsj.bean;
import java.util.List;
public class User {
	private String username;
	private Integer password;
	private List<String> telslist;
	/**
	 * 1.使用构造注入 
	 * 1.1提供带所有参数的有参构造方法。
	 */
	public User(String username, Integer password, List<String> list) {
		super();
		this.username = username;
		this.password = password;
		this.telslist = list;
	}
	/**
	 * 2.使用设值注入 
	 * 2.1提供默认空参构造方法 ;
	 * 2.2为所有属性提供setter方法。
	 */
	public User() {
		super();
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(Integer password) {
		this.password = password;
	}
	public void setTelslist(List<String> list) {
		this.telslist = telslist;
	}
   //getting方法省略	
	public String getUsername() {
		return username;
	}
	public Integer getPassword() {
		return password;
	}
	public List<String> getTelslist() {
		return telslist;
	}
}