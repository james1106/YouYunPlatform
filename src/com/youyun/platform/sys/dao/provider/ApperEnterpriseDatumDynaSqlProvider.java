package com.youyun.platform.sys.dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import com.youyun.platform.sys.entity.ApperEnterpriseDatum;
import static com.youyun.platform.sys.common.utils.ApperSysConstants.APPENTERPRISEDATUMTABLE;


/**   
 * @Description: 开发者资料动态SQL语句提供类
 * @author 吴进田  
 * @date 2017-07-25
 * @version V1.0   
 */
public class ApperEnterpriseDatumDynaSqlProvider {
	// 分页动态查询
	public String selectWhitParam(Map<String, Object> params){
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM(APPENTERPRISEDATUMTABLE);
				if(params.get("apperEnterpriseDatum") != null){
					ApperEnterpriseDatum apperEnterpriseDatum = (ApperEnterpriseDatum)params.get("apperEnterpriseDatum");
					if(apperEnterpriseDatum.getApper() != null && apperEnterpriseDatum.getApper().getId() != null){
						WHERE(" user_id = #{apperEnterpriseDatum.apper.id} ");
					}
					
					if(apperEnterpriseDatum.getCompany() != null && !apperEnterpriseDatum.getCompany().equals("")){
						WHERE("  company LIKE CONCAT ('%',#{apperEnterpriseDatum.company},'%') ");
					}
					if(apperEnterpriseDatum.getPhone() != null && !apperEnterpriseDatum.getPhone().equals("")){
						WHERE(" phone LIKE CONCAT ('%',#{apperEnterpriseDatum.phone},'%') ");
					}
					
					if(apperEnterpriseDatum.getLegalPerson() != null && !apperEnterpriseDatum.getLegalPerson().equals("")){
						WHERE("  legalPerson LIKE CONCAT ('%',#{apperEnterpriseDatum.legalPerson},'%') ");
					}
					
					if(apperEnterpriseDatum.getStatus() != null){
						WHERE(" status = #{apperEnterpriseDatum.status} ");
					}
					if(apperEnterpriseDatum.getLevel() != null){
						WHERE(" level = #{apperEnterpriseDatum.level} ");
					}
					
				}
			}
		}.toString();
		
		if(params.get("pageModel") != null){
			sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}  ";
		}
		
		return sql;
	}	
	
	// 动态查询总数量
	public String count(Map<String, Object> params){
		return new SQL(){
			{
				SELECT("count(*)");
				FROM(APPENTERPRISEDATUMTABLE);
				if(params.get("apperEnterpriseDatum") != null){
					ApperEnterpriseDatum apperEnterpriseDatum = (ApperEnterpriseDatum)params.get("apperEnterpriseDatum");
					if(apperEnterpriseDatum.getApper() != null && apperEnterpriseDatum.getApper().getId() != null){
						WHERE(" user_id = #{apperEnterpriseDatum.apper.id} ");
					}
					
					if(apperEnterpriseDatum.getCompany() != null && !apperEnterpriseDatum.getCompany().equals("")){
						WHERE("  company LIKE CONCAT ('%',#{apperEnterpriseDatum.company},'%') ");
					}
					if(apperEnterpriseDatum.getPhone() != null && !apperEnterpriseDatum.getPhone().equals("")){
						WHERE(" phone LIKE CONCAT ('%',#{apperEnterpriseDatum.phone},'%') ");
					}
					
					if(apperEnterpriseDatum.getLegalPerson() != null && !apperEnterpriseDatum.getLegalPerson().equals("")){
						WHERE("  legalPerson LIKE CONCAT ('%',#{apperEnterpriseDatum.legalPerson},'%') ");
					}
					
					if(apperEnterpriseDatum.getStatus() != null){
						WHERE(" status = #{apperEnterpriseDatum.status} ");
					}
					if(apperEnterpriseDatum.getLevel() != null){
						WHERE(" level = #{apperEnterpriseDatum.level} ");
					}
					
				}
			}
		}.toString();
	}	
	
	// 动态插入
	public String insertApperEnterpriseDatum(ApperEnterpriseDatum apperEnterpriseDatum){
		
		return new SQL(){
			{
				INSERT_INTO(APPENTERPRISEDATUMTABLE);
				if(apperEnterpriseDatum.getApper()!= null){
					VALUES("user_id", "#{apper.id}");
				}
				if(apperEnterpriseDatum.getCompany() != null){
					VALUES("company", "#{company}");
				}
				if(apperEnterpriseDatum.getProvince()!= null){
					VALUES("province", "#{province}");
				}
				
				if(apperEnterpriseDatum.getCity()!= null){
					VALUES("city", "#{city}");
				}
				
				if(apperEnterpriseDatum.getDistrict()!= null){
					VALUES("district", "#{district}");
				}
				
				if(apperEnterpriseDatum.getZipcode()!= null){
					VALUES("zipcode", "#{zipcode}");
				}
				
				if(apperEnterpriseDatum.getAddress()!= null){
					VALUES("address", "#{address}");
				}
				
				if(apperEnterpriseDatum.getPhone()!= null){
					VALUES("phone", "#{phone}");
				}
				
				
				if(apperEnterpriseDatum.getLegalPerson()!= null){
					VALUES("legal_person", "#{legalPerson}");
				}
				
				if(apperEnterpriseDatum.getIdCardFront()!= null){
					VALUES("id_card_front", "#{idCardFront}");
				}
				
				if(apperEnterpriseDatum.getIdCardBack()!= null){
					VALUES("id_card_back", "#{idCardBack}");
				}
				
				if(apperEnterpriseDatum.getBusinessLicence()!= null){
					VALUES("business_licence", "#{businessLicence}");
				}
				
				if(apperEnterpriseDatum.getStatus()!= null){
					VALUES("status", "#{status}");
				}
				
				if(apperEnterpriseDatum.getLevel()!= null){
					VALUES("level", "#{level}");
				}
				
				if(apperEnterpriseDatum.getUpdateTime()!= null){
					VALUES("update_time", "#{updateTime}");
				}
				
				if(apperEnterpriseDatum.getCreateTime()!= null){
					VALUES("create_time", "#{createTime}");
				}
			
			}
		}.toString();
	}
	// 动态更新
	public String updateApperEnterpriseDatum(ApperEnterpriseDatum apperEnterpriseDatum){
		
		return new SQL(){
			{
				UPDATE(APPENTERPRISEDATUMTABLE);
				
				if(apperEnterpriseDatum.getApper()!= null){
					SET("user_id = #{apper.id}");
				}
				if(apperEnterpriseDatum.getCompany() != null){
					SET("company = #{company}");
				}
				if(apperEnterpriseDatum.getProvince()!= null){
					SET("province = #{province}");
				}
				
				if(apperEnterpriseDatum.getCity()!= null){
					SET("city = #{city}");
				}
				
				if(apperEnterpriseDatum.getDistrict()!= null){
					SET("district = #{district}");
				}
				
				if(apperEnterpriseDatum.getZipcode()!= null){
					SET("zipcode = #{zipcode}");
				}
				
				if(apperEnterpriseDatum.getAddress()!= null){
					SET("address = #{address}");
				}
				
				if(apperEnterpriseDatum.getPhone()!= null){
					SET("phone = #{phone}");
				}
				
				
				if(apperEnterpriseDatum.getLegalPerson()!= null){
					SET("legal_person = #{legalPerson}");
				}
				
				if(apperEnterpriseDatum.getIdCardFront()!= null){
					SET("id_card_front = #{idCardFront}");
				}
				
				if(apperEnterpriseDatum.getIdCardBack()!= null){
					SET("id_card_back = #{idCardBack}");
				}
				
				if(apperEnterpriseDatum.getBusinessLicence()!= null){
					SET("business_licence = #{businessLicence}");
				}
				
				if(apperEnterpriseDatum.getStatus()!= null){
					SET("status = #{status}");
				}
				
				if(apperEnterpriseDatum.getLevel()!= null){
					SET("level = #{level}");
				}
				
				if(apperEnterpriseDatum.getUpdateTime()!= null){
					SET("update_time = #{updateTime}");
				}
				
				if(apperEnterpriseDatum.getCreateTime()!= null){
					SET("create_time = #{createTime}");
				}
			
				
				WHERE(" id = #{id} ");
			}
		}.toString();
	}


}


