package com.youyun.platform.sys.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ApperModule implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id; // '主键',
	private Apper apper; //应用者
	private DeveloperModule developerModule; // '开发者模块',
	private String moduleLogo; // '模块logo',
	private String moduleName; // '模块名称',
	private String moduleTitle; // '模块标题',
	private String moduleVersion; // '模块版本',
	private Integer type; // '类型',
	private Integer status; // '状态',
	private Date createTime; // '建立时间',
	private Date updateTime; // '更新时间'
	private List<ApperUser> apperUsers; // 用户和模块是多对多的关系
	
	//无参数构造器
	public ApperModule() {
		super();
	}
	
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
	
	public DeveloperModule getDeveloperModule() {
		return this.developerModule;
	}
	
	public void setDeveloperModule(DeveloperModule developerModule) {
		this.developerModule = developerModule;
	}
	
	
	public String getModuleLogo() {
		return this.moduleLogo;
	}
	
	public void setModuleLogo(String moduleLogo) {
		this.moduleLogo = moduleLogo;
	}
	
	public String getModuleName() {
		return this.moduleName;
	}
	
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	
	public String getModuleTitle() {
		return this.moduleTitle;
	}
	
	public void setModuleTitle(String moduleTitle) {
		this.moduleTitle = moduleTitle;
	}
	
	public String getModuleVersion() {
		return this.moduleVersion;
	}
	
	public void setModuleVersion(String moduleVersion) {
		this.moduleVersion = moduleVersion;
	}
	
	public Integer getType() {
		return this.type;
	}
	
	public void setType(Integer type) {
		this.type = type;
	}
	
	public Integer getStatus() {
		return this.status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
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
	
	public List<ApperUser> getApperUsers() {
		return this.apperUsers;
	}
	
	public void setApperUsers(List<ApperUser> apperUsers) {
		this.apperUsers = apperUsers;
	}
	
}
