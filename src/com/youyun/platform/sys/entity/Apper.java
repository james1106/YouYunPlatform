package com.youyun.platform.sys.entity;


import java.io.Serializable;
import java.util.Date;


/**   
 * @Description: 
 * 应用者--持久化实体类 
 * @author 吴进田
 * 2017-07-21
 * @version V1.0   
 */
public class Apper implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id; //id
	private String loginName; // 登录名
	private String loginPwd; //登录密码,md5加密
	private String nickname;  // 昵称
	private String headImg;   //头像
	private String email;      //邮箱，可用于登录
	private String mobile;     // 手机号，可用于登录
	private Integer userType; //用户类型， 1表示开发者 2表示应用者
	private Integer status;     //状态
	private String urlSign;     //url标志
	private int loginCount;    //登录次数
	private Date lastLoginTime;  //最后登时间
	private Date updateTime;      //更新时间
	private Date createTime;       //建立时间
	
	//无参数构造器
	public Apper() {
		super();
	}
	
	//getter 和 setter方法
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getLoginName() {
		return this.loginName;
	}
	
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	public String getLoginPwd() {
		return this.loginPwd;
	}
	
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	
	
	public String getNickname() {
		return this.nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
	public String getHeadImg() {
		return this.headImg;
	}
	
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMobile() {
		return this.mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public Integer getUserType() {
		return this.userType;
	}
	
	public void  setUserType(Integer userType) {
		this.userType = userType;
	}
	
	public Integer getStatus() {
		return this.status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public String getUrlSign() {
		return this.urlSign;
	}
	
	public void setUrlSign(String urlSign) {
		this.urlSign = urlSign;
	}
	
	public int getLoginCount() {
		return this.loginCount;
	}
	
	public void setLoginCount(int loginCount) {
		this.loginCount = loginCount;
	}
	
	
	public Date getLastLoginTime() {
		return this.lastLoginTime;
	}
	
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;	
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
	
	@Override
	public String toString() {
		return "User [id=" + id + ", loginName=" + loginName + ", loginPwd="
				+ loginPwd + ", nickname=" + nickname + ", headImg=" + headImg
				+ ", email=" + email + ", mobile=" + mobile + ", status=" + status + ", userType=" + userType
				+ ", loginCount=" + loginCount + ", lastLoginTime=" + lastLoginTime
				+ ", updateTime=" + updateTime + ", createTime=" + createTime + "]";
	}
	
}

