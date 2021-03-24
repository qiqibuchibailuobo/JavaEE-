package edu.hhxy.jsj.factory;

public class MyBean3Factory {
	public MyBean3Factory() {
		System.out.println("bean3ÊµÀý»¯ÖÐ");
	}
	public  Bean3 createBean() {
		return new Bean3();
	}
}
