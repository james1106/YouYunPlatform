package com.youyun.platform.sys.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ApperUser implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id; // '主键',
	private Apper apper; //应用者
	private String userName; // '用户名',
	private String userPwd; // '用户密码，md5加密',
	private String realName; // '真实姓名',
	private Integer level; // '等级',
	private Integer status; // '状态',
	
	private Integer groupId; // '用户组id',
	private String remark; // '备注',
	private Date updateTime; // '更新时间',
	private Date createTime; // '建立时间',
	private List<ApperModule> modules; // 用户和模块是多对多的关系
	 
	 
	//无参数构造器
	public ApperUser() {
		super();
	}
	
	//getter、setter
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public Apper getApper() {
		return this.apper;
	}
	
	public void setApper(Apper apper) {
		this.apper = apper;
	}
	
	
	public String getUserName() {
		return this.userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserPwd() {
		return this.userPwd;
	}
	
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
	public String getRealName() {
		return this.realName;
	}
	
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	public Integer getLevel() {
		return this.level;
	}
	
	public void setLevel(Integer level) {
		this.level = level;
	}
	
	public Integer getStatus() {
		return this.status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Integer getGroupId() {
		return this.groupId;
	}
	
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	
	public String getRemark() {
		return this.remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	public Date getUpdateTime() {
		return this.updateTime;
	}
	
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	
	public Date getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
	public List<ApperModule> getModules() {
		return this.modules;
	}
	
	public void setModules(List<ApperModule> modules) {
		this.modules = modules;
	}
	 

}
