package com.entity;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity //hibernate模型 对应数据库中essay
@Table(name="essay") //指定数据库中的表
public class Essay{
	
	
	@Id	// 注解主键
	@GeneratedValue // id生成策略  默认auto 相当于hibernate的native - 自增字段
	
	private int id;
	private String title;
	private String content;
	private String imag;
	private Date time;
	private Date updatetime;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String getImag() {
		return imag;
	}
	public void setImag(String imag) {
		this.imag = imag;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	
	
	
}