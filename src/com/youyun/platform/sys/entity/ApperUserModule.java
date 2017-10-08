package com.youyun.platform.sys.entity;

import java.io.Serializable;
import java.util.Date;

public class ApperUserModule implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Apper apper;
	private ApperUser apperUser;
	private ApperModule apperModule;
	private Date createTime;
	private Date updateTime;
	
	//无参数构造器
	public ApperUserModule() {
		super();
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public Integer setId(Integer id) {
		return this.id = id;
	}
	
	public Apper getApper() {
		return this.apper;
	}
	
	public void setApper(Apper apper) {
		this.apper = apper;
	}
	
	public ApperUser getApperUser() {
		return this.apperUser;
	}
	
	public void setApperUser(ApperUser apperUser) {
		this.apperUser = apperUser;
	}
	
	public ApperModule getApperModule() {
		return this.apperModule;
	}
	
	public void setApperModule(ApperModule apperModule) {
		this.apperModule = apperModule;
	}
	public Date getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Date getUpdateTime() {
		return this.updateTime;
	}
	
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
