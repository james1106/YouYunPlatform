package com.youyun.platform.sys.dao;

import static com.youyun.platform.sys.common.utils.ApperSysConstants.APPERUSERMODULETABLE;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;

import com.youyun.platform.sys.dao.provider.ApperUserModuleDynaSqlProvider;
import com.youyun.platform.sys.entity.ApperUserModule;

/**   
 * @Description: ApperUserModuleMapper接口
 * @author 吴进田
 * @date 2017-10-01
 * @version V1.0   
 */
public interface ApperUserModuleDao  {

	// 根据参数查询应用者的用户模块总数
	@SelectProvider(type=ApperUserModuleDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);
		
	// 根据参数动态查询应用者的用户模块
	@SelectProvider(type=ApperUserModuleDynaSqlProvider.class,method="selectWhitParam")
	@Results({
		@Result(id=true,column="id",property="id"),
	
		@Result(column="update_time",property="updateTime",javaType=java.util.Date.class),
		@Result(column="create_time",property="createTime",javaType=java.util.Date.class),
		@Result(column="apper_id",property="apper",
		one=@One(select="com.youyun.platform.sys.dao.ApperDao.selectById",
			fetchType=FetchType.EAGER)),
		@Result(column="apper_user_id",property="apperUser",
		one=@One(select="com.youyun.platform.sys.dao.ApperUserDao.selectById",
			fetchType=FetchType.EAGER)),
		@Result(column="apper_module_id",property="apperModule",
		one=@One(select="com.youyun.platform.sys.dao.ApperModuleDao.selectById",
			fetchType=FetchType.EAGER))
		})
	List<ApperUserModule> selectByPage(Map<String, Object> params);
		
	// 动态插入应用者用户
	@SelectProvider(type=ApperUserModuleDynaSqlProvider.class,method="insertApperUserModule")
	void save(ApperUserModule apperUserModule);

	// 根据id删除应用者用户
	@Delete(" delete from "+ APPERUSERMODULETABLE +" where id = #{id} ")
	void deleteById(Integer id);
		
	// 根据id查询应用者用户
	@Select("select * from "+APPERUSERMODULETABLE+" where ID = #{id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		
		@Result(column="update_time",property="updateTime",javaType=java.util.Date.class),
		@Result(column="create_time",property="createTime",javaType=java.util.Date.class),
		@Result(column="apper_id",property="apper",
		one=@One(select="com.youyun.platform.sys.dao.ApperDao.selectById",
			fetchType=FetchType.EAGER)),
		@Result(column="apper_user_id",property="apperUser",
		one=@One(select="com.youyun.platform.sys.dao.ApperUserDao.selectById",
			fetchType=FetchType.EAGER)),
		@Result(column="apper_module_id",property="apperModule",
		one=@One(select="com.youyun.platform.sys.dao.ApperModuleDao.selectById",
			fetchType=FetchType.EAGER))
		})
	ApperUserModule selectById(Integer id);
	
	
	// 根据应用者id查询应用者用户
	@Select("select * from "+APPERUSERMODULETABLE+" where apper_id = #{apperId}")
	@Results({
		@Result(id=true,column="id",property="id"),
		
		@Result(column="update_time",property="updateTime",javaType=java.util.Date.class),
		@Result(column="create_time",property="createTime",javaType=java.util.Date.class),
		@Result(column="apper_id",property="apper",
		one=@One(select="com.youyun.platform.sys.dao.ApperDao.selectById",
			fetchType=FetchType.EAGER)),
		@Result(column="apper_user_id",property="apperUser",
		one=@One(select="com.youyun.platform.sys.dao.ApperUserDao.selectById",
			fetchType=FetchType.EAGER)),
		@Result(column="apper_module_id",property="apperModule",
		one=@One(select="com.youyun.platform.sys.dao.ApperModuleDao.selectById",
			fetchType=FetchType.EAGER))
		
		})
	List<ApperUserModule> selectByApperId(Integer userId);
	
	// 根据应用者用户查询应用者用户模块
	@Select("select * from "+APPERUSERMODULETABLE+" where apper_user_id = #{apperUserId}")
	@Results({
		@Result(id=true,column="id",property="id"),
		
		@Result(column="update_time",property="updateTime",javaType=java.util.Date.class),
		@Result(column="create_time",property="createTime",javaType=java.util.Date.class),
		@Result(column="apper_id",property="apper",
		one=@One(select="com.youyun.platform.sys.dao.ApperDao.selectById",
			fetchType=FetchType.EAGER)),
		@Result(column="apper_user_id",property="apperUser",
		one=@One(select="com.youyun.platform.sys.dao.ApperUserDao.selectById",
			fetchType=FetchType.EAGER)),
		@Result(column="apper_module_id",property="apperModule",
		one=@One(select="com.youyun.platform.sys.dao.ApperModuleDao.selectById",
			fetchType=FetchType.EAGER))
			
	})
	List<ApperUserModule> selectByApperUserId(Integer apperUserId);
	
	// 根据应用者模块查询应用者用户模块
	@Select("select * from "+APPERUSERMODULETABLE+" where apper_module_id = #{apperModuleId}")
	@Results({
		@Result(id=true,column="id",property="id"),
		
		@Result(column="update_time",property="updateTime",javaType=java.util.Date.class),
		@Result(column="create_time",property="createTime",javaType=java.util.Date.class),
		@Result(column="apper_id",property="apper",
		one=@One(select="com.youyun.platform.sys.dao.ApperDao.selectById",
			fetchType=FetchType.EAGER)),
		@Result(column="apper_user_id",property="apperUser",
		one=@One(select="com.youyun.platform.sys.dao.ApperUserDao.selectById",
			fetchType=FetchType.EAGER)),
		@Result(column="apper_module_id",property="apperModule",
		one=@One(select="com.youyun.platform.sys.dao.ApperModuleDao.selectById",
			fetchType=FetchType.EAGER))
				
	})
	List<ApperUserModule> selectByApperModuleId(Integer apperModuleId);
	
	// 根据应用者模块查询应用者用户模块
		@Select("select * from "+APPERUSERMODULETABLE+
				" where apper_id = #{apperId} and apper_user_id = #{apperUserId} and apper_module_id = #{apperModuleId}")
		@Results({
			@Result(id=true,column="id",property="id"),
			
			@Result(column="update_time",property="updateTime",javaType=java.util.Date.class),
			@Result(column="create_time",property="createTime",javaType=java.util.Date.class),
			@Result(column="apper_id",property="apper",
			one=@One(select="com.youyun.platform.sys.dao.ApperDao.selectById",
				fetchType=FetchType.EAGER)),
			@Result(column="apper_user_id",property="apperUser",
			one=@One(select="com.youyun.platform.sys.dao.ApperUserDao.selectById",
				fetchType=FetchType.EAGER)),
			@Result(column="apper_module_id",property="apperModule",
			one=@One(select="com.youyun.platform.sys.dao.ApperModuleDao.selectById",
				fetchType=FetchType.EAGER))
					
		})
		ApperUserModule selectByApperIdAndUserIdAndModuleId(
				@Param("apperId")  Integer apperId, 
				@Param("apperUserId") Integer apperUserId,
				@Param("apperModuleId") Integer apperModuleId
				
				);
	
	
		
	// 动态修改应用者用户
	@SelectProvider(type=ApperUserModuleDynaSqlProvider.class,method="updateApperUserModule")
	void update(ApperUserModule apperUser);
	
}




