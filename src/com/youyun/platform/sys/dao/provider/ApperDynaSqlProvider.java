package com.youyun.platform.sys.dao.provider; 


import static com.youyun.platform.sys.common.utils.ApperSysConstants.APPERTABLE;

import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import com.youyun.platform.sys.entity.Apper;

/**   
 * @Description: 应用用户动态SQL语句提供类
 * @author 吴进田  
 * @date 2017-07-21
 * @version V1.0   
 */
public class ApperDynaSqlProvider {
	// 分页动态查询
	public String selectWhitParam(Map<String, Object> params){
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM(APPERTABLE);
				if(params.get("apper") != null){
					Apper user = (Apper)params.get("apper");
					if(user.getLoginName() != null && !user.getLoginName().equals("")){
						WHERE("  login_name LIKE CONCAT ('%',#{user.loginName},'%') ");
					}
					if(user.getStatus() != null){
						WHERE(" status = #{user.status} ");
					}
					if(user.getUrlSign() != null){
						WHERE(" url_sign = #{user.urlSign} ");
					}
					if(user.getUserType() != null ){
						WHERE(" user_type = #{user.userType}");
					}
				}
			}
		}.toString();
		/*
		if(params.get("pageModel") != null){
			sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}  ";
		}
		*/
		return sql;
	}	
	
	// 动态查询总数量
	public String count(Map<String, Object> params){
		return new SQL(){
			{
				SELECT("count(*)");
				FROM(APPERTABLE);
				if(params.get("apper") != null){
					Apper user = (Apper)params.get("apper");
					if(user.getLoginName() != null && !user.getLoginName().equals("")){
						WHERE(" login_name LIKE CONCAT ('%',#{user.loginName},'%') ");
					}
					if(user.getStatus() != null){
						WHERE(" status = #{user.status} ");
					}
					if(user.getUrlSign() != null){
						WHERE(" url_sign = #{user.urlSign} ");
					}
					if(user.getUserType() != null ){
						WHERE(" user_type = #{user.userType}");
					}
				}
			}
		}.toString();
	}	
	
	// 动态插入
	public String insertUser(Apper apper){
		return new SQL(){
			{
				INSERT_INTO(APPERTABLE);
				if(apper.getLoginName() != null && !apper.getLoginName().equals("")){
					VALUES("login_name", "#{loginName}");
				}
				if(apper.getStatus() != null){
					VALUES("status", "#{status}");
				}
				if(apper.getUrlSign() != null){
					VALUES("url_sign", "#{urlSign}");
				}
				if(apper.getUserType() != null){
					VALUES("user_type", "#{userType}");
				}
				if(apper.getEmail() != null && !apper.getEmail().equals("")){
					VALUES("email", "#{email}");
				}
				if(apper.getLoginPwd() != null && !apper.getLoginPwd().equals("")){
					VALUES("login_pwd", "#{loginPwd}");
				}
			}
		}.toString();
	}
	
	// 动态更新
	public String updateUser(Apper apper){
			
		return new SQL(){
				{
					UPDATE(APPERTABLE);
					
					if(apper.getLoginName() != null){
						SET(" login_name = #{loginName} ");
					}
					if(apper.getLoginPwd()!= null){
						SET(" login_pwd = #{loginPwd} ");
					}
					if(apper.getStatus()!= null){
						SET(" status = #{status} ");
					}
					if(apper.getUrlSign()!= null){
						SET(" url_sign = #{urlSign} ");
					}
					if(apper.getUserType()!= null){
						SET(" user_type = #{userType} ");
					}
					if(apper.getCreateTime()!= null){
						SET(" create_time = #{createTime} ");
					}
					WHERE(" id = #{id} ");
				}
			}.toString();
		}
}

