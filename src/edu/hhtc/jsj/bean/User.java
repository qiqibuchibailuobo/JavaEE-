package edu.hhtc.jsj.bean;
import java.util.List;
public class User {
	private String username;
	private Integer password;
	private List<String> telslist;
	/**
	 * 1.ʹ�ù���ע�� 
	 * 1.1�ṩ�����в������вι��췽����
	 */
	public User(String username, Integer password, List<String> list) {
		super();
		this.username = username;
		this.password = password;
		this.telslist = list;
	}
	/**
	 * 2.ʹ����ֵע�� 
	 * 2.1�ṩĬ�Ͽղι��췽�� ;
	 * 2.2Ϊ���������ṩsetter������
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
   //getting����ʡ��	
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