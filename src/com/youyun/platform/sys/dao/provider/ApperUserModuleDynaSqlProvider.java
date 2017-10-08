package com.youyun.platform.sys.dao.provider;


import static com.youyun.platform.sys.common.utils.ApperSysConstants.APPERUSERMODULETABLE;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import com.youyun.platform.sys.entity.ApperUserModule;


/**   
 * @Description: 应用者的用户模块动态SQL语句提供类
 * @author 吴进田  
 * @date 2017-10-01
 * @version V1.0   
 */
public class ApperUserModuleDynaSqlProvider {
	// 分页动态查询
	public String selectWhitParam(Map<String, Object> params){
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM(APPERUSERMODULETABLE);
				if(params.get("apperUserModule") != null){
					ApperUserModule apperUserModule = (ApperUserModule)params.get("apperUserModule");
					
					if(apperUserModule.getApper() != null && apperUserModule.getApper().getId() != null){
						WHERE(" apper_id = #{apperUserModule.apper.id} ");
					}
					if(apperUserModule.getApperUser() != null && apperUserModule.getApperUser().getId() != null){
						WHERE(" apper_user_id = #{apperUserModule.apperUser.id} ");
					}
					
					if(apperUserModule.getApperModule() != null && apperUserModule.getApperModule().getId() != null){
						WHERE(" apper_module_id = #{apperUserModule.apperMoudle.id} ");
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
				FROM(APPERUSERMODULETABLE);
				if(params.get("apperUserModule") != null){
					ApperUserModule apperUserModule = (ApperUserModule)params.get("apperUserModule");
					if(apperUserModule.getApper() != null && apperUserModule.getApper().getId() != null){
						WHERE(" apper_id = #{apperUserModule.apper.id} ");
					}
					
					if(apperUserModule.getApperUser() != null && apperUserModule.getApperUser().getId() != null){
						WHERE(" apper_user_id = #{apperUserModule.apperUser.id} ");
					}
					
					if(apperUserModule.getApperModule() != null && apperUserModule.getApperModule().getId() != null){
						WHERE(" apper_module_id = #{apperUserModule.apperMoudle.id} ");
					}
					
				}
			}
		}.toString();
	}	
	
	// 动态插入
	public String insertApperUserModule(ApperUserModule apperUserModule){
		
		return new SQL(){
			{
				INSERT_INTO(APPERUSERMODULETABLE);
				if(apperUserModule.getApper()!= null){
					VALUES("apper_id", "#{apper.id}");
				}
				if(apperUserModule.getApperUser()!= null){
					VALUES("apper_user_id", "#{apperUser.id}");
				}
				
				if(apperUserModule.getApperModule()!= null){
					VALUES("apper_module_id", "#{apperModule.id}");
				}
				
				
				if(apperUserModule.getUpdateTime()!= null){
					VALUES("update_time", "#{updateTime}");
				}
				
				if(apperUserModule.getCreateTime()!= null){
					VALUES("create_time", "#{createTime}");
				}
			
			}
		}.toString();
	}
	// 动态更新
	public String updateApperUserModule(ApperUserModule apperUserModule){
		
		return new SQL(){
			{
				UPDATE(APPERUSERMODULETABLE);
				
				if(apperUserModule.getApper()!= null){
					SET("apper_id = #{apper.id}");
				}
				
				if(apperUserModule.getApperUser()!= null){
					SET("apper_user_id = #{apperUser.id}");
				}
				
				if(apperUserModule.getApperModule()!= null){
					SET("apper_module_id = #{apperModule.id}");
				}
				
				
				if(apperUserModule.getUpdateTime()!= null){
					SET("update_time = #{updateTime}");
				}
				
				if(apperUserModule.getCreateTime()!= null){
					SET("create_time = #{createTime}");
				}
				
				WHERE(" id = #{id} ");
			}
		}.toString();
	}


}




