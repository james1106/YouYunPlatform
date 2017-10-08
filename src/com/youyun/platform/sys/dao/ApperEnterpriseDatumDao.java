package com.youyun.platform.sys.dao;

import com.youyun.platform.sys.entity.ApperEnterpriseDatum;
import static com.youyun.platform.sys.common.utils.ApperSysConstants.APPENTERPRISEDATUMTABLE;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;
import com.youyun.platform.sys.dao.provider.ApperEnterpriseDatumDynaSqlProvider;


/**   
 * @Description: ApperEnterpriseDatumr接口
 * @author 吴进田
 * @date 2017-07-25
 * @version V1.0   
 */
public interface ApperEnterpriseDatumDao {

	// 根据参数查询开发者资料总数
	@SelectProvider(type=ApperEnterpriseDatumDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);
		
	// 根据参数动态查询开发者资料
	@SelectProvider(type=ApperEnterpriseDatumDynaSqlProvider.class,method="selectWhitParam")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="company",property="company"),
		@Result(column="province",property="province"),
		@Result(column="city",property="city"),
		@Result(column="district",property="district"),
		@Result(column="zipcode",property="zipcode"),
		@Result(column="address",property="address"),
		@Result(column="phone",property="phone"),
		@Result(column="legal_person",property="legalPerson"),
		@Result(column="id_card_front",property="idCardFront"),
		@Result(column="id_card_back",property="idCardBack"),
		@Result(column="business_licence",property="businessLicence"),
		@Result(column="status",property="status"),
		@Result(column="level",property="level"),
		@Result(column="update_time",property="updateTime",javaType=java.util.Date.class),
		@Result(column="create_time",property="createTime",javaType=java.util.Date.class),
		@Result(column="user_id",property="apper",
		one=@One(select="com.youyun.platform.sys.dao.ApperDao.selectById",
			fetchType=FetchType.EAGER))
		})
	List<ApperEnterpriseDatum> selectByPage(Map<String, Object> params);
		
	// 动态插入开发者资料
	@SelectProvider(type=ApperEnterpriseDatumDynaSqlProvider.class,method="insertApperEnterpriseDatum")
	void save(ApperEnterpriseDatum apperEnterpriseDatum);

	// 根据id删除开发者资料
	@Delete(" delete from "+APPENTERPRISEDATUMTABLE+" where id = #{id} ")
	void deleteById(Integer id);
		
	// 根据id查询开发者资料
	@Select("select * from "+APPENTERPRISEDATUMTABLE+" where ID = #{id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="company",property="company"),
		@Result(column="province",property="province"),
		@Result(column="city",property="city"),
		@Result(column="district",property="district"),
		@Result(column="zipcode",property="zipcode"),
		@Result(column="address",property="address"),
		@Result(column="phone",property="phone"),
		@Result(column="legal_person",property="legalPerson"),
		@Result(column="id_card_front",property="idCardFront"),
		@Result(column="id_card_back",property="idCardBack"),
		@Result(column="business_licence",property="businessLicence"),
		@Result(column="status",property="status"),
		@Result(column="level",property="level"),
		@Result(column="update_time",property="updateTime",javaType=java.util.Date.class),
		@Result(column="create_time",property="createTime",javaType=java.util.Date.class),
		@Result(column="user_id",property="apper",
		one=@One(select="com.youyun.platform.sys.dao.ApperDao.selectById",
			fetchType=FetchType.EAGER))
		})
	ApperEnterpriseDatum selectById(Integer id);
	
	
	// 根据id查询开发者资料
	@Select("select * from "+APPENTERPRISEDATUMTABLE+" where user_id = #{userId}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="company",property="company"),
		@Result(column="province",property="province"),
		@Result(column="city",property="city"),
		@Result(column="district",property="district"),
		@Result(column="zipcode",property="zipcode"),
		@Result(column="address",property="address"),
		@Result(column="phone",property="phone"),
		@Result(column="legal_person",property="legalPerson"),
		@Result(column="id_card_front",property="idCardFront"),
		@Result(column="id_card_back",property="idCardBack"),
		@Result(column="business_licence",property="businessLicence"),
		@Result(column="status",property="status"),
		@Result(column="level",property="level"),
		@Result(column="update_time",property="updateTime",javaType=java.util.Date.class),
		@Result(column="create_time",property="createTime",javaType=java.util.Date.class),
		@Result(column="user_id",property="apper",
		one=@One(select="com.youyun.platform.sys.dao.ApperDao.selectById",
			fetchType=FetchType.EAGER))
		})
	ApperEnterpriseDatum selectByUserId(Integer userId);
		
	// 动态修改员工
	@SelectProvider(type=ApperEnterpriseDatumDynaSqlProvider.class,method="updateApperEnterpriseDatum")
	void update(ApperEnterpriseDatum apperEnterpriseDatum);
	
}

