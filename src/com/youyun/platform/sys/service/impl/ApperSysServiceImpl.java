package com.youyun.platform.sys.service.impl;



import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.youyun.platform.sys.common.utils.tag.PageModel;
import com.youyun.platform.sys.entity.DeveloperModule;
import com.youyun.platform.sys.entity.Apper;
import com.youyun.platform.sys.dao.ApperDao;
import com.youyun.platform.sys.dao.DeveloperModuleDao;
import com.youyun.platform.sys.entity.ApperEnterpriseDatum;
import com.youyun.platform.sys.entity.ApperModule;
import com.youyun.platform.sys.entity.ApperUser;
import com.youyun.platform.sys.entity.ApperUserModule;
import com.youyun.platform.sys.dao.ApperEnterpriseDatumDao;
import com.youyun.platform.sys.dao.ApperModuleDao;
import com.youyun.platform.sys.dao.ApperUserDao;
import com.youyun.platform.sys.dao.ApperUserModuleDao;


import com.youyun.platform.sys.service.ApperSysService;
//import org.fkit.hrm.util.tag.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**   
 * @Description: 服务层接口实现类
 * @author 吴进田
 * @date 2017-07-21 
 * @version V1.0   
 */
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("apperSysService")
public class ApperSysServiceImpl implements ApperSysService{

	/**
	 * 自动注入持久层Dao对象
	 * */
	@Autowired
	private ApperDao apperDao;
	@Autowired
	private DeveloperModuleDao developerModuleDao;
	@Autowired
	private ApperEnterpriseDatumDao apperEnterpriseDatumDao;
	@Autowired
	private ApperModuleDao apperModuleDao;
	@Autowired
	private ApperUserDao apperUserDao;
	@Autowired
	private ApperUserModuleDao apperUserModuleDao;
	
	
	/*
	@Autowired
	private DeptDao deptDao;
	*/
	
	
	/*****************用户服务接口实现*************************************/
	

	
	/**
	 * AppMarketServiceImpl接口findUserById方法实现
	 * @see { AppMarketService }
	 * */
	@Transactional(readOnly=true)
	@Override
	public Apper findApperById(Integer id) {
		return apperDao.selectById(id);
	}
	
	@Transactional(readOnly=true)
	@Override
	public Apper findApperByUrlSign(String urlSign) {
		return apperDao.selectByUrlSign(urlSign);
	}
	
	
	

	
	/*****************开发者模块服务接口实现*************************************/

	
	/**
	 * DeveloperModuleService接口findDeveloperModuleById方法实现
	 * @see { DeveloperModuleService }
	 * */
	@Transactional(readOnly=true)
	@Override
	public DeveloperModule findDeveloperModuleById(Integer id) {
		
		return developerModuleDao.selectById(id);
	}
	
	
	
	
	/*****************应用者企业认证 服务接口实现*************************************/
	/**
	 *AppMarketService接口findApperEnterpriseDatum方法实现
	 * @see { HeverloperService }
	 * */
	@Transactional(readOnly=true)
	@Override
	public List<ApperEnterpriseDatum> findApperEnterpriseDatum(ApperEnterpriseDatum apperEnterpriseDatum,PageModel pageModel) {
		/** 当前需要分页的总数据条数  */
		Map<String,Object> params = new HashMap<>();
		params.put("apperEnterpriseDatum", apperEnterpriseDatum);
		
		int recordCount = apperEnterpriseDatumDao.count(params);
	    pageModel.setRecordCount(recordCount);
	    
	    if(recordCount > 0){
	        /** 开始分页查询数据：查询第几页的数据 */
		    params.put("pageModel", pageModel);
	    }
	    List<ApperEnterpriseDatum> apperEnterpriseDatums = apperEnterpriseDatumDao.selectByPage(params);
	    return apperEnterpriseDatums;
	}
	
	
	
	/**
	 * AppMarketService接口findApperEnterpriseDatumById方法实现
	 * @see { AppMarketService }
	 * */
	@Transactional(readOnly=true)
	@Override
	public ApperEnterpriseDatum findApperEnterpriseDatumById(Integer id) {
		
		return apperEnterpriseDatumDao.selectById(id);
	}
	
	
	/**
	 * 根据开发者用户查询开发者资料
	 * @param dedeloperUser
	 * @return 开发者资料对象
	 * */
	@Transactional(readOnly=true)
	@Override
	public ApperEnterpriseDatum findApperEnterpriseDatumByUser(Apper user) {
		return apperEnterpriseDatumDao.selectByUserId(user.getId());
	}
	
	

	
	
	/*****************************应用者用户********************************************/
	/*****************用户服务接口实现*************************************/
	/**
	 * AppMarketServiceImpl接口login方法实现
	 *  @see { AppMarketService }
	 * */
	@Transactional(readOnly=true)
	@Override
	public ApperUser login(Integer apperId, String userName, String userPwd) {
//		System.out.println("HrmServiceImpl login -- >>");
		return apperUserDao.selectByApperIdAndUserNameAndPwd(apperId, userName, userPwd);
	}
	/**
	 * 根据id查询应用者用户
	 * @param id
	 * @return 应用者用户
	 * */
	@Transactional(readOnly=true)
	@Override
	public ApperUser findApperUserById(Integer id) {
		return apperUserDao.selectById(id);
	}
	
	
	/**
	 * 查询应用者的用户
	 * @param apper
	 * @return 应用者用户
	 * */
	@Transactional(readOnly=true)
	@Override
	public List<ApperUser> findApperUserByApper(Apper apper) {
		return apperUserDao.selectByApperId(apper.getId());
	}
	
	/**
	 * 添加应用者用户
	 * @param apperUser 应用者用户
	 * */
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Override
	public void addApperUser(ApperUser apperUser) {
		Apper apper = apperUser.getApper();
		
		String userName = apperUser.getUserName();
		List<ApperModule> modules = apperUser.getModules();
		apperUserDao.save(apperUser);
		
		if (modules != null) {
			ApperUser apperUser1 = apperUserDao.selectByApperIdAndUserName(apper.getId(), userName);
		
			for (int i = 0; i < modules.size(); i++) {
				ApperModule module = modules.get(i);
				ApperUserModule userModule = new ApperUserModule();
				userModule.setApper(apper);
				userModule.setApperModule(module);
				userModule.setApperUser(apperUser1);
				userModule.setCreateTime(new Date());
				userModule.setUpdateTime(new Date());
			
				apperUserModuleDao.save(userModule);
			
			
			//module.set
			}
		}
		
	}
	
	
	
	/**
	 * 修改应用者用户
	 * @param apperUser 应用者用户
	 * */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Override
	public void modifyApperUser(ApperUser apperUser) {
		apperUserDao.update(apperUser);
		
	}
	
	/****************************应用者模块********************************************/
	
	/**
	 * 根据id查询应用者模块
	 * @param id
	 * @return 应用者模块
	 * */
	@Transactional(readOnly = true)
	@Override
	public ApperModule findApperModuleById(Integer id) {
		return apperModuleDao.selectById(id);
	}
	
	/**
	 * 查询应用者的模块
	 * @param apper
	 * @return 应用者模块开表
	 * */
	@Transactional(readOnly = true)
	@Override
	public List<ApperModule> findApperModuleByApper(Apper apper) {
		return apperModuleDao.selectByApperId(apper.getId());
	}
	
	/**
	 * 添加应用者模块
	 * @param apperModule 应用者模块对象
	 * */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Override
	public void addApperModule(ApperModule apperModule) {
		apperModuleDao.save(apperModule);
	}
	
	/**
	 * 修改应用者模块
	 * @param employee 应用者需求
	 * */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Override
	public void modifyApperModule(ApperModule apperModule) {
		apperModuleDao.update(apperModule);
	}
	
	
	/**
	 * 得到应用者用户的模块
	 * @param apper
	 * @param apperUser
	 * @param status
	 * @return
	 */
	@Transactional(readOnly = true)
	@Override
	public List<ApperModule>  findApperModuleByUser(Apper apper, ApperUser apperUser, Integer status) {
		return apperModuleDao.selectByUserId(apper.getId(), apperUser.getId(), status);
	}
	
	
	@Transactional(readOnly = true)
	@Override
	public ApperUserModule  findApperModuleByApperAndUserAndModule(Apper apper, ApperUser apperUser, ApperModule apperModule) {
		return apperUserModuleDao.selectByApperIdAndUserIdAndModuleId(apper.getId(), apperUser.getId(), apperModule.getId());
	}
	
	
	
	
	
	/**
	 * 添加应用者用户模块
	 * @param apperUserModule 应用者用户模块对象
	 * */
	//void addApperUserModule(ApperUserModule apperUserModule);
	
	/**
	 * 修改应用者用户模块
	 * @param apperUserModule 应用者用户模块
	 * */
//	void modifyApperUserModule(ApperUserModule apperUserModule);
	
	

	

	
	/*****************公告接口实现*************************************/
	

	/*****************文件接口实现*************************************/


	
	
	
}

