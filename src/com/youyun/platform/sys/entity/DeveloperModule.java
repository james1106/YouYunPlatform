package com.youyun.platform.sys.entity;

import java.io.Serializable;
import java.util.Date;


public class DeveloperModule implements Serializable {
	 private static final long serialVersionUID = 1L;
	
	private Integer id; //主键
	private String moduleName;   //'标识名',
	private String title; //'名称',
	private Integer status;     //状态
	private String logo; //'LOGO',
	private String preview; // '封面'
	private String category;// '模块种类',
	private String ability;  //'功能简述',
	private String designDescription; //'介绍',
	private String url;     // '发布页url',
	private Integer isProtect; // '正版保护',
	private Integer accountType; //'适用客户类型',
	private String description; // '使用说明',
	private Double price; //价格
	private Date updateTime;      //更新时间
    private Date createTime;       //建立时间
	 
     
   //无参数构造器
 	public DeveloperModule() {
 		super();
 	}
 	
 	//getter 和 setter方法
 	
 	public Integer getId() {
 		return this.id;
 	}
 	
 	public void setId(Integer id) {
 		this.id = id;
 	}
 	
 
	public String getModuleName() {
		return this.moduleName;
	}
	
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Integer getStatus() {
		return this.status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public String getLogo() {
		return this.logo;
	}
	
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	public String getPreview() {
		return this.preview;
	}
	
	public void setPreview(String preview) {
		this.preview = preview;
	}
	
	public String getCategory() {
		return this.category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getAbility() {
		return this.ability;
	}
	
	public void setAbility(String ability) {
		this.ability = ability;
	}
	
	public String getDesignDescription() {
		return this.designDescription;
	}
	
	public void setDesignDescription(String designDescription) {
		this.designDescription = designDescription;
	}
	
	public String getUrl() {
		return this.url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public Integer getIsProtect() {
		return this.isProtect;
	}
	
	public void setIsProtect(Integer isProtect) {
		this.isProtect = isProtect;
	}
	
	public Integer getAccountType() {
		return this.accountType;
	}
	
	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Double getPrice() {
		return this.price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
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
