package edu.hhtc.jsj.bean;

import java.util.Date;

public class Car {
	 private Integer id;

	    private String color;

	    private Date newdate;

	    private static final long serialVersionUID = 1L;

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public String getColor() {
	        return color;
	    }

	    public void setColor(String color) {
	        this.color = color;
	    }

	    public Date getNewdate() {
	        return newdate;
	    }

	    public void setNewdate(Date newdate) {
	        this.newdate = newdate;
	    }
}
