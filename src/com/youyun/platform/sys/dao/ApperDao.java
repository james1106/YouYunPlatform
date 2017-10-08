package com.youyun.platform.sys.dao;


import static com.youyun.platform.sys.common.utils.ApperSysConstants.APPERTABLE;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;

import com.youyun.platform.sys.dao.provider.ApperDynaSqlProvider;
import com.youyun.platform.sys.entity.Apper;

/**   
 * @Description: UserMapper接口
 * @author 吴进田
 * @date 2017-07-21
 * @version V1.0   
 */
public interface ApperDao {

	
	
	// 根据id查询开发者用户
	@Select("select * from "+APPERTABLE+" where id = #{id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="login_name",property="loginName"),
		@Result(column="login_pwd",property="loginPwd"),
		@Result(column="nickname",property="nickname"),
		@Result(column="head_img",property="headImg"),
		@Result(column="email",property="email"),
		@Result(column="mobile",property="mobile"),
		@Result(column="user_type",property="userType"),
		@Result(column="status",property="status"),
		@Result(column="url_sign",property="urlSign"),
		@Result(column="login_count",property="loginCount"),
		@Result(column="last_login_time",property="lastLoginTime",javaType=java.util.Date.class),
		@Result(column="update_time",property="updateTime",javaType=java.util.Date.class),
		@Result(column="create_time",property="createTime",javaType=java.util.Date.class)
		})
	Apper selectById(Integer id);
	

	// 根据urlSign查询开发者用户
	@Select("select * from "+APPERTABLE+" where url_sign = #{urlSign}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="login_name",property="loginName"),
		@Result(column="login_pwd",property="loginPwd"),
		@Result(column="nickname",property="nickname"),
		@Result(column="head_img",property="headImg"),
		@Result(column="email",property="email"),
		@Result(column="mobile",property="mobile"),
		@Result(column="user_type",property="userType"),
		@Result(column="status",property="status"),
		@Result(column="url_sign",property="urlSign"),
		@Result(column="login_count",property="loginCount"),
		@Result(column="last_login_time",property="lastLoginTime",javaType=java.util.Date.class),
		@Result(column="update_time",property="updateTime",javaType=java.util.Date.class),
		@Result(column="create_time",property="createTime",javaType=java.util.Date.class)
		})
	Apper selectByUrlSign(String urlSign);
	
	// 根据id删除开发者用户
	@Delete(" delete from "+APPERTABLE+" where id = #{id} ")
	void deleteById(Integer id);
		
	// 动态修改开发者用户
	@SelectProvider(type=ApperDynaSqlProvider.class,method="updateUser")
	void update(Apper user);
		
	// 动态查询
	@SelectProvider(type=ApperDynaSqlProvider.class,method="selectWhitParam")
	List<Apper> selectByPage(Map<String, Object> params);
	
	// 根据参数查询用户总数
	@SelectProvider(type=ApperDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);
	
	// 动态插入用户
	@SelectProvider(type=ApperDynaSqlProvider.class,method="insertUser")
	void save(Apper user);
	
}