package com.youyun.platform.sys.entity;

import java.io.Serializable;
import java.util.Date;



/**   
 * @Description: 
 * 应用者企业认证资料--持久化实体类 
 * @author 吴进田
 * 2017-07-25
 * @version V1.0   
 */
public class ApperEnterpriseDatum implements Serializable {
	 private static final long serialVersionUID = 1L;
	 
	 private Integer id; // '主键'
	 private Apper apper; //应用者用户
	 private String company; // '公司名称'
	 private String province; // '省'
	 private String city;     // '市'
	 private String district; // '区',
	 private String zipcode;  // '邮编'
	 private String address;  // '地址'
	 private String phone;    // '电话'
	 private String legalPerson;  // '法人'
	 private String idCardFront; // '身份证正面'
	 private String idCardBack;  // '身份证反面'
	 private String businessLicence; // '营业执照正面'
	 private Integer status;           // '状态'
	 private Integer  level;        // '等级'
	 private Date createTime;  // '建立时间'
	 private Date updateTime;  // '更新时间'
	 
	//无参数构造器
	public ApperEnterpriseDatum() {
		super();
	}
	
	//geter and setter
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
	
	public String getCompany() {
		return this.company;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	
	public String getProvince() {
		return this.province;
	}
	
	public void setProvince(String province) {
		this.province = province;
	}
	
	public String getCity() {
		return this.city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getDistrict() {
		return this.district;
	}
	
	public void setDistrict(String district) {
		this.district = district;
	}
	
	public String getZipcode() {
		return this.zipcode;
	}
	
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getLegalPerson() {
		return this.legalPerson;
	}
	
	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}
	
	public String getIdCardFront() {
		return this.idCardFront;
	}
	
	public void setIdCardFront(String idCardFront) {
		this.idCardFront = idCardFront;
	}
	
	public String getIdCardBack() {
		return this.idCardBack;
	}
	
	public void setIdCardBack(String idCardBack) {
		this.idCardBack = idCardBack;
	}
	
	public String getBusinessLicence() {
		return this.businessLicence;
	}
	
	public void setBusinessLicence(String businessLicence) {
		this.businessLicence = businessLicence;
	}
	
	public Integer getStatus() {
		return this.status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Integer getLevel() {
		return this.level;
	}
	
	public void setLevel(Integer level) {
		this.level = level;
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
	
	
	
	
	 @Override
	public String toString() {
		 return "ApperEnterpriseDatum [id=" + id + ", apper=" + apper + ", company="
				+ company + ", province=" + province + ", city=" + city
				+ ", district=" + district + ", zipcode=" + zipcode + ", address=" + address
				+ ", phone=" + phone + ", legalPerson=" + legalPerson
				+ ", idCardFront=" + idCardFront + ", idCardBack=" + idCardBack
				+ ", businessLicence=" + businessLicence+ ", status=" + status + ", level=" + level
				+ ", updateTime=" + updateTime + ", createTime=" + createTime + "]";
		}
	
	

}
