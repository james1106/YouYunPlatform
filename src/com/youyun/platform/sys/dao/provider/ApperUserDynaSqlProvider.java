package com.youyun.platform.sys.dao.provider;

import static com.youyun.platform.sys.common.utils.ApperSysConstants.APPERUSERTABLE;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import com.youyun.platform.sys.entity.ApperUser;


/**   
 * @Description: 应用者的用户动态SQL语句提供类
 * @author 吴进田  
 * @date 2017-10-01
 * @version V1.0   
 */
public class ApperUserDynaSqlProvider {
	// 分页动态查询
	public String selectWhitParam(Map<String, Object> params){
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM(APPERUSERTABLE);
				if(params.get("apperUser") != null){
					ApperUser apperUser = (ApperUser)params.get("apperUser");
					if(apperUser.getApper() != null && apperUser.getApper().getId() != null){
						WHERE(" apper_id = #{apperUser.apper.id} ");
					}
					
					if(apperUser.getUserName() != null && !apperUser.getUserName().equals("")){
						WHERE("  user_name LIKE CONCAT ('%',#{apperUser.userName},'%') ");
					}
					
					if(apperUser.getRealName() != null && !apperUser.getRealName().equals("")){
						WHERE("  real_name LIKE CONCAT ('%',#{apperUser.realName},'%') ");
					}
					
					if(apperUser.getLevel() != null){
						WHERE(" level = #{apperUser.level} ");
					}
					
					if(apperUser.getStatus() != null){
						WHERE(" status = #{apperUser.status} ");
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
				FROM(APPERUSERTABLE);
				if(params.get("apperUser") != null){
					ApperUser apperUser = (ApperUser)params.get("apperUser");
					if(apperUser.getApper() != null && apperUser.getApper().getId() != null){
						WHERE(" apper_id = #{apperUser.apper.id} ");
					}
					
					if(apperUser.getUserName() != null && !apperUser.getUserName().equals("")){
						WHERE("  user_name LIKE CONCAT ('%',#{apperUser.userName},'%') ");
					}
					
					if(apperUser.getRealName() != null && !apperUser.getRealName().equals("")){
						WHERE("  real_name LIKE CONCAT ('%',#{apperUser.realName},'%') ");
					}
					
					if(apperUser.getLevel() != null){
						WHERE(" level = #{apperUser.level} ");
					}
					
					if(apperUser.getStatus() != null){
						WHERE(" status = #{apperUser.status} ");
					}
					
				}
			}
		}.toString();
	}	
	
	// 动态插入
	public String insertApperUser(ApperUser apperUser){
		
		return new SQL(){
			{
				INSERT_INTO(APPERUSERTABLE);
				if(apperUser.getApper()!= null){
					VALUES("apper_id", "#{apper.id}");
				}
				if(apperUser.getUserName() != null){
					VALUES("user_name", "#{userName}");
				}
				
				if(apperUser.getRealName() != null){
					VALUES("real_name", "#{realName}");
				}
				
				if(apperUser.getUserPwd()!= null){
					VALUES("user_pwd", "#{userPwd}");
				}
				
				if(apperUser.getLevel()!= null){
					VALUES("level", "#{level}");
				}
				
				if(apperUser.getStatus()!= null){
					VALUES("status", "#{status}");
				}
				
				
				
				if(apperUser.getGroupId()!= null){
					VALUES("group_id", "#{groupId}");
				}
				
				if(apperUser.getRemark()!= null){
					VALUES("remark", "#{remark}");
				}
				
				
				if(apperUser.getUpdateTime()!= null){
					VALUES("update_time", "#{updateTime}");
				}
				
				if(apperUser.getCreateTime()!= null){
					VALUES("create_time", "#{createTime}");
				}
			
			}
		}.toString();
	}
	// 动态更新
	public String updateApperUser(ApperUser apperUser){
		
		return new SQL(){
			{
				UPDATE(APPERUSERTABLE);
				
				
				if(apperUser.getApper()!= null){
					SET("apper_id = #{apper.id}");
				}
				if(apperUser.getUserName() != null){
					SET("user_name = #{userName}");
				}
				
				if(apperUser.getRealName() != null){
					SET("real_name = #{realName}");
				}
				
				if(apperUser.getUserPwd()!= null){
					SET("user_pwd = #{userPwd}");
				}
				
				if(apperUser.getLevel()!= null){
					SET("level = #{level}");
				}
				
				if(apperUser.getStatus()!= null){
					SET("status = #{status}");
				}
				
				
				
				if(apperUser.getGroupId()!= null){
					SET("group_id = #{groupId}");
				}
				
				if(apperUser.getRemark()!= null){
					SET("remark = #{remark}");
				}
				
				if(apperUser.getUpdateTime()!= null){
					SET("update_time = #{updateTime}");
				}
				
				if(apperUser.getCreateTime()!= null){
					SET("create_time = #{createTime}");
				}
				
				WHERE(" id = #{id} ");
			}
		}.toString();
	}


}



