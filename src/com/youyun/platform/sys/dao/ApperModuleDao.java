package com.youyun.platform.sys.dao;

import static com.youyun.platform.sys.common.utils.ApperSysConstants.APPERMODULETABLE;
import static com.youyun.platform.sys.common.utils.ApperSysConstants.APPERUSERMODULETABLE;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;
import com.youyun.platform.sys.dao.provider.ApperModuleDynaSqlProvider;
import com.youyun.platform.sys.entity.ApperModule;

/**   
 * @Description: ApperModuleMapper接口
 * @author 吴进田
 * @date 2017-10-01
 * @version V1.0   
 */
public interface ApperModuleDao  {

	// 根据参数查询应用者模块总数
	@SelectProvider(type=ApperModuleDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);
		
	// 根据参数动态查询应用者模块
	@SelectProvider(type=ApperModuleDynaSqlProvider.class,method="selectWhitParam")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="module_logo",property="moduleLogo"),
		@Result(column="module_name",property="moduleName"),
		@Result(column="module_title",property="moduleTitle"),
		@Result(column="module_version",property="moduleVersion"),
		@Result(column="type",property="type"),
		@Result(column="status",property="status"),
		
		@Result(column="update_time",property="updateTime",javaType=java.util.Date.class),
		@Result(column="create_time",property="createTime",javaType=java.util.Date.class),
		@Result(column="apper_id",property="apper",
		one=@One(select="com.youyun.platform.sys.dao.ApperDao.selectById",
			fetchType=FetchType.EAGER)),
		@Result(column="developer_module_id",property="developerModule",
		one=@One(select="com.youyun.platform.sys.dao.DeveloperModuleDao.selectById",
			fetchType=FetchType.EAGER))
		
		})
	List<ApperModule> selectByPage(Map<String, Object> params);
		
	// 动态插入应用者用户
	@SelectProvider(type=ApperModuleDynaSqlProvider.class,method="insertApperModule")
	void save(ApperModule apperModule);

	// 根据id删除应用者用户
	@Delete(" delete from "+ APPERMODULETABLE +" where id = #{id} ")
	void deleteById(Integer id);
		
	// 根据id查询应用者用户
	@Select("select * from "+APPERMODULETABLE+" where ID = #{id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="module_logo",property="moduleLogo"),
		@Result(column="module_name",property="moduleName"),
		@Result(column="module_title",property="moduleTitle"),
		@Result(column="module_version",property="moduleVersion"),
		@Result(column="type",property="type"),
		@Result(column="status",property="status"),
		
		@Result(column="update_time",property="updateTime",javaType=java.util.Date.class),
		@Result(column="create_time",property="createTime",javaType=java.util.Date.class),
		@Result(column="apper_id",property="apper",
		one=@One(select="com.youyun.platform.sys.dao.ApperDao.selectById",
			fetchType=FetchType.EAGER)),
		@Result(column="developer_module_id",property="developerModule",
		one=@One(select="com.youyun.platform.sys.dao.DeveloperModuleDao.selectById",
			fetchType=FetchType.EAGER))
		})
	ApperModule selectById(Integer id);
	
	
	// 根据应用者id查询应用者用户
	@Select("select * from "+APPERMODULETABLE+" where apper_id = #{apperId}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="module_logo",property="moduleLogo"),
		@Result(column="module_name",property="moduleName"),
		@Result(column="module_title",property="moduleTitle"),
		@Result(column="module_version",property="moduleVersion"),
		@Result(column="type",property="type"),
		@Result(column="status",property="status"),
		
		@Result(column="update_time",property="updateTime",javaType=java.util.Date.class),
		@Result(column="create_time",property="createTime",javaType=java.util.Date.class),
		@Result(column="apper_id",property="apper",
		one=@One(select="com.youyun.platform.sys.dao.ApperDao.selectById",
			fetchType=FetchType.EAGER)),
		@Result(column="developer_module_id",property="developerModule",
		one=@One(select="com.youyun.platform.sys.dao.DeveloperModuleDao.selectById",
			fetchType=FetchType.EAGER))
		
		})
	List<ApperModule> selectByApperId(Integer userId);
	
	// 根据应用者id查询应用者用户
		@Select("SELECT * FROM "  + APPERMODULETABLE + " WHERE id IN (SELECT apper_module_id FROM " + APPERUSERMODULETABLE + 
				" WHERE apper_id = ${apperId} and apper_user_id = #{userId}  ) and status = ${status} ")
		@Results({
			@Result(id=true,column="id",property="id"),
			@Result(column="module_logo",property="moduleLogo"),
			@Result(column="module_name",property="moduleName"),
			@Result(column="module_title",property="moduleTitle"),
			@Result(column="module_version",property="moduleVersion"),
			@Result(column="type",property="type"),
			@Result(column="status",property="status"),
			
			@Result(column="update_time",property="updateTime",javaType=java.util.Date.class),
			@Result(column="create_time",property="createTime",javaType=java.util.Date.class),
			@Result(column="apper_id",property="apper",
			one=@One(select="com.youyun.platform.sys.dao.ApperDao.selectById",
				fetchType=FetchType.EAGER)),
			@Result(column="developer_module_id",property="developerModule",
			one=@One(select="com.youyun.platform.sys.dao.DeveloperModuleDao.selectById",
				fetchType=FetchType.EAGER))
			
			})
		List<ApperModule> selectByUserId(
				@Param("apperId") Integer apperId,
				@Param("userId") Integer userId,
				@Param("status") Integer status
				);
				
				
			
	
	// 根据状态查询应用者用户
	@Select("select * from "+APPERMODULETABLE+" where status = #{status} order by id DESC ")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="module_logo",property="moduleLogo"),
		@Result(column="module_name",property="moduleName"),
		@Result(column="module_title",property="moduleTitle"),
		@Result(column="module_version",property="moduleVersion"),
		@Result(column="type",property="type"),
		@Result(column="status",property="status"),
		
		@Result(column="update_time",property="updateTime",javaType=java.util.Date.class),
		@Result(column="create_time",property="createTime",javaType=java.util.Date.class),
		@Result(column="apper_id",property="apper",
		one=@One(select="com.youyun.platform.sys.dao.ApperDao.selectById",
			fetchType=FetchType.EAGER)),
		@Result(column="developer_module_id",property="developerModule",
		one=@One(select="com.youyun.platform.sys.dao.DeveloperModuleDao.selectById",
			fetchType=FetchType.EAGER))
			
			})
	List<ApperModule> selectByStatus(Integer status);
	
	
		
	// 动态修改应用者用户
	@SelectProvider(type=ApperModuleDynaSqlProvider.class,method="updateApperModule")
	void update(ApperModule apperModule);
	
}


