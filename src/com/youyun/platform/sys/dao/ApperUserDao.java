package com.youyun.platform.sys.dao;

import static com.youyun.platform.sys.common.utils.ApperSysConstants.APPERUSERTABLE;
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
import com.youyun.platform.sys.dao.provider.ApperUserDynaSqlProvider;
import com.youyun.platform.sys.entity.Apper;
import com.youyun.platform.sys.entity.ApperUser;

/**   
 * @Description: ApperUserMapper接口
 * @author 吴进田
 * @date 2017-10-01
 * @version V1.0   
 */
public interface ApperUserDao  {

	// 根据参数查询应用者的用户总数
	@SelectProvider(type=ApperUserDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);
		
	// 根据参数动态查询应用者的用户
	@SelectProvider(type=ApperUserDynaSqlProvider.class,method="selectWhitParam")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="user_name",property="userName"),
		@Result(column="real_name",property="realName"),
		@Result(column="user_pwd",property="userPwd"),
		@Result(column="level",property="level"),
		@Result(column="status",property="status"),
		@Result(column="group_id",property="groupId"),
		@Result(column="remark",property="remark"),
		@Result(column="update_time",property="updateTime",javaType=java.util.Date.class),
		@Result(column="create_time",property="createTime",javaType=java.util.Date.class),
		@Result(column="apper_id",property="apper",
		one=@One(select="com.youyun.platform.sys.dao.ApperDao.selectById",
			fetchType=FetchType.EAGER)),
		@Result(column="id",property="modules",
		many=@Many(select="com.youyun.platform.sys.dao.ApperModuleDao.selectByUserId",
			fetchType=FetchType.EAGER))
		})
	List<ApperUser> selectByPage(Map<String, Object> params);
	
	
	// 根据登录名和密码查询应用者用户
	@Select("select * from "+APPERUSERTABLE+" where apper_id = #{apperId} and user_name = #{userName} and user_pwd = #{userPwd}")
		@Results({
			@Result(id=true,column="id",property="id"),
			@Result(column="user_name",property="userName"),
			@Result(column="real_name",property="realName"),
			@Result(column="user_pwd",property="userPwd"),
			@Result(column="level",property="level"),
			@Result(column="status",property="status"),
			@Result(column="group_id",property="groupId"),
			@Result(column="remark",property="remark"),
			@Result(column="update_time",property="updateTime",javaType=java.util.Date.class),
			@Result(column="create_time",property="createTime",javaType=java.util.Date.class),
			@Result(column="apper_id",property="apper",
			one=@One(select="com.youyun.platform.sys.dao.ApperDao.selectById",
				fetchType=FetchType.EAGER))
			
			})
	ApperUser selectByApperIdAndUserNameAndPwd(
				@Param("apperId") Integer apperId,
				@Param("userName") String userName,
				@Param("userPwd") String passWord);
		
	// 动态插入应用者用户
	@SelectProvider(type=ApperUserDynaSqlProvider.class,method="insertApperUser")
	void save(ApperUser apperUser);

	// 根据id删除应用者用户
	@Delete(" delete from "+ APPERUSERTABLE +" where id = #{id} ")
	void deleteById(Integer id);
		
	// 根据id查询应用者用户
	@Select("select * from "+APPERUSERTABLE+" where ID = #{id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="user_name",property="userName"),
		@Result(column="real_name",property="realName"),
		@Result(column="user_pwd",property="userPwd"),
		@Result(column="level",property="level"),
		@Result(column="status",property="status"),
		@Result(column="group_id",property="groupId"),
		@Result(column="remark",property="remark"),
		@Result(column="update_time",property="updateTime",javaType=java.util.Date.class),
		@Result(column="create_time",property="createTime",javaType=java.util.Date.class),
		@Result(column="apper_id",property="apper",
		one=@One(select="com.youyun.platform.sys.dao.ApperDao.selectById",
			fetchType=FetchType.EAGER))
		})
	ApperUser selectById(Integer id);
	
	// 根据用户名查询应用者用户
	@Select("select * from "+APPERUSERTABLE+" where apper_id = #{apperId} and user_name = #{userName}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="user_name",property="userName"),
		@Result(column="real_name",property="realName"),
		@Result(column="user_pwd",property="userPwd"),
		@Result(column="level",property="level"),
		@Result(column="status",property="status"),
		@Result(column="group_id",property="groupId"),
		@Result(column="remark",property="remark"),
		@Result(column="update_time",property="updateTime",javaType=java.util.Date.class),
		@Result(column="create_time",property="createTime",javaType=java.util.Date.class),
		@Result(column="apper_id",property="apper",
		one=@One(select="com.youyun.platform.sys.dao.ApperDao.selectById",
			fetchType=FetchType.EAGER))
			})
	ApperUser selectByApperIdAndUserName(
			@Param("apperId")  Integer apperId, 
			@Param("userName") String userName);
	
	
	
	
	// 根据应用者id查询应用者用户
	@Select("select * from "+APPERUSERTABLE+" where apper_id = #{apperId}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="user_name",property="userName"),
		@Result(column="real_name",property="realName"),
		@Result(column="user_pwd",property="userPwd"),
		@Result(column="level",property="level"),
		@Result(column="status",property="status"),
		@Result(column="group_id",property="groupId"),
		@Result(column="remark",property="remark"),
		@Result(column="update_time",property="updateTime",javaType=java.util.Date.class),
		@Result(column="create_time",property="createTime",javaType=java.util.Date.class),
		@Result(column="apper_id",property="apper",
		one=@One(select="com.youyun.platform.sys.dao.ApperDao.selectById",
			fetchType=FetchType.EAGER))
		
		})
	List<ApperUser> selectByApperId(Integer apperId);
	
	// 根据状态查询应用者用户
	@Select("select * from "+APPERUSERTABLE+" where status = #{status} order by id DESC ")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="user_name",property="userName"),
		@Result(column="real_name",property="realName"),
		@Result(column="user_pwd",property="userPwd"),
		@Result(column="level",property="level"),
		@Result(column="status",property="status"),
		@Result(column="group_id",property="groupId"),
		@Result(column="remark",property="remark"),
		@Result(column="update_time",property="updateTime",javaType=java.util.Date.class),
		@Result(column="create_time",property="createTime",javaType=java.util.Date.class),
		@Result(column="apper_id",property="apper",
		one=@One(select="com.youyun.platform.sys.dao.ApperDao.selectById",
			fetchType=FetchType.EAGER))
			
			})
	List<ApperUser> selectByStatus(Integer status);
	
	
		
	// 动态修改应用者用户
	@SelectProvider(type=ApperUserDynaSqlProvider.class,method="updateApperUser")
	void update(ApperUser apperUser);
	
}



