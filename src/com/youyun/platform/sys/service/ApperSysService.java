package com.youyun.platform.sys.service;



import java.util.List;



import com.youyun.platform.sys.common.utils.tag.PageModel;
import com.youyun.platform.sys.entity.DeveloperModule;
import com.youyun.platform.sys.entity.Apper;
import com.youyun.platform.sys.entity.ApperEnterpriseDatum;
import com.youyun.platform.sys.entity.ApperModule;
import com.youyun.platform.sys.entity.ApperUser;
import com.youyun.platform.sys.entity.ApperUserModule;

/**   
 * @Description: 服务层接口 
 * @author 吴进田
 * @date 2017-07-21   
 * @version V1.0   
 */
public interface ApperSysService {

	/****************   用户 服务口 **********************************/

	
	/**
	 * 根据id查询用户
	 * @param id
	 * @return User对象
	 * */
	Apper findApperById(Integer id);
	
	Apper findApperByUrlSign(String urlSign);
	
	/**
	 * 获得所有开发者用户
	 * @return DeveloperUser对象的List集合
	 * */
	//List<DeveloperUser> findDeveloperUser(DeveloperUser developerUser,PageModel pageModel);
	
	
	
	
	/****************   开发者模块 服务接口 **********************************/
	
	
	/**
	 * 根据id查询开发者模块
	 * @param id
	 * @return 开发者资料对象
	 * */
	DeveloperModule findDeveloperModuleById(Integer id);
	
	
	
	
	/****************   应用者企业认证 服务接口 **********************************/
	/**
	 * 获得所有应用者企业资料
	 * @param apperEnterpriseDatum 查询条件
	 * @param pageModel 分页对象
	 * @return DeveloperDatum对象的List集合
	 * */
	List<ApperEnterpriseDatum> findApperEnterpriseDatum(ApperEnterpriseDatum apperEnterpriseDatum,PageModel pageModel);
	
	
	
	/**
	 * 根据id查询应用者企业资料
	 * @param id
	 * @return 应用者企业资料对象
	 * */
	ApperEnterpriseDatum findApperEnterpriseDatumById(Integer id);
	
	/**
	 * 根据用户查询应用者企业资料
	 * @param user
	 * @return 应用者企业资料对象
	 * */
	ApperEnterpriseDatum findApperEnterpriseDatumByUser(Apper user);
	
	
	

	
	
	
	/*****************************应用者用户********************************************/
	/**
	 * 用户登录
	 * @param  loginName
	 * @param  loginPwd
	 * @return User对象
	 * */
	ApperUser login(Integer apperId, String userName,String userPwd);
	/**
	 * 根据id查询应用者用户
	 * @param id
	 * @return 应用者用户
	 * */
	ApperUser findApperUserById(Integer id);
	
	/**
	 * 查询应用者的用户
	 * @param apper
	 * @return 应用者用户
	 * */
	List<ApperUser> findApperUserByApper(Apper apper);
	
	/**
	 * 添加应用者用户
	 * @param apperUser 应用者用户
	 * */
	void addApperUser(ApperUser apperUser);
	
	/**
	 * 修改应用者用户
	 * @param apperUser 应用者用户
	 * */
	void modifyApperUser(ApperUser apperUser);
	
	/****************************应用者模块********************************************/
	
	/**
	 * 根据id查询应用者模块
	 * @param id
	 * @return 应用者模块
	 * */
	ApperModule findApperModuleById(Integer id);
	
	/**
	 * 查询应用者的模块
	 * @param apper
	 * @return 应用者模块开表
	 * */
	List<ApperModule> findApperModuleByApper(Apper apper);
	
	/**
	 * 添加应用者模块
	 * @param apperModule 应用者模块对象
	 * */
	void addApperModule(ApperModule apperModule);
	
	/**
	 * 修改应用者模块
	 * @param employee 应用者需求
	 * */
	void modifyApperModule(ApperModule apperModule);
	
	/**
	 * 得到应用者用户的模块
	 * @param apper
	 * @param apperUser
	 * @param status
	 * @return
	 */
	List<ApperModule>  findApperModuleByUser(Apper apper, ApperUser apperUser, Integer status);
	
	ApperUserModule  findApperModuleByApperAndUserAndModule(Apper apper, ApperUser apperUser, ApperModule apperModule);
		
	
	/**
	 * 添加应用者用户模块
	 * @param apperUserModule 应用者用户模块对象
	 * */
//	void addApperUserModule(ApperUserModule apperUserModule);
	
	/**
	 * 修改应用者用户模块
	 * @param apperUserModule 应用者用户模块
	 * */
	//void modifyApperUserModule(ApperUserModule apperUserModule);
	
	
	
}

