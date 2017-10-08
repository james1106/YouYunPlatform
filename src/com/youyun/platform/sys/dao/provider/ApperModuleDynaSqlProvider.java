package com.youyun.platform.sys.dao.provider;

import static com.youyun.platform.sys.common.utils.ApperSysConstants.APPERMODULETABLE;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import com.youyun.platform.sys.entity.ApperModule;


/**   
 * @Description: 应用者模块动态SQL语句提供类
 * @author 吴进田  
 * @date 2017-10-01
 * @version V1.0   
 */
public class ApperModuleDynaSqlProvider {
	// 分页动态查询
	public String selectWhitParam(Map<String, Object> params){
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM(APPERMODULETABLE);
				if(params.get("apperModule") != null){
					ApperModule apperModule = (ApperModule)params.get("apperModule");
					
					if(apperModule.getApper() != null && apperModule.getApper().getId() != null){
						WHERE(" apper_id = #{apperModule.apper.id} ");
					}
					
					if(apperModule.getDeveloperModule() != null && apperModule.getDeveloperModule().getId() != null){
						WHERE(" developer_module_id = #{apperModule.developerModule.id} ");
					}
					
					
					if(apperModule.getModuleName() != null && !apperModule.getModuleName().equals("")){
						WHERE("  module_name LIKE CONCAT ('%',#{apperModule.moduleName},'%') ");
					}
					
					if(apperModule.getModuleTitle() != null && !apperModule.getModuleTitle().equals("")){
						WHERE("  module_title LIKE CONCAT ('%',#{apperModule.moduleTitle},'%') ");
					}
					
					if(apperModule.getType() != null){
						WHERE(" type = #{apperModule.type} ");
					}
					
					if(apperModule.getStatus() != null){
						WHERE(" status = #{apperModule.status} ");
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
				FROM(APPERMODULETABLE);
				if(params.get("apperModule") != null){
					ApperModule apperModule = (ApperModule)params.get("apperModule");
					
					if(apperModule.getApper() != null && apperModule.getApper().getId() != null){
						WHERE(" apper_id = #{apperModule.apper.id} ");
					}
					
					if(apperModule.getDeveloperModule() != null && apperModule.getDeveloperModule().getId() != null){
						WHERE(" developer_module_id = #{apperModule.developerModule.id} ");
					}
					
					
					
					if(apperModule.getModuleName() != null && !apperModule.getModuleName().equals("")){
						WHERE("  module_name LIKE CONCAT ('%',#{apperModule.moduleName},'%') ");
					}
					
					if(apperModule.getModuleTitle() != null && !apperModule.getModuleTitle().equals("")){
						WHERE("  module_title LIKE CONCAT ('%',#{apperModule.moduleTitle},'%') ");
					}
					
					if(apperModule.getType() != null){
						WHERE(" type = #{apperModule.type} ");
					}
					
					if(apperModule.getStatus() != null){
						WHERE(" status = #{apperModule.status} ");
					}
				}
			}
		}.toString();
	}	
	
	// 动态插入
	public String insertApperModule(ApperModule apperModule){
		
		return new SQL(){
			{
				INSERT_INTO(APPERMODULETABLE);
				if(apperModule.getDeveloperModule()!= null){
					VALUES("developer_module_id", "#{developerModule.id}");
				}
				
				if(apperModule.getApper()!= null){
					VALUES("apper_id", "#{apper.id}");
				}
				
				
				
				
				if(apperModule.getModuleLogo() != null){
					VALUES("module_logo", "#{moduleLogo}");
				}
				
				if(apperModule.getModuleName()!= null){
					VALUES("module_name", "#{moduleName}");
				}
				
				if(apperModule.getModuleTitle()!= null){
					VALUES("module_title", "#{moduleTitle}");
				}
				
				if(apperModule.getModuleVersion()!= null){
					VALUES("module_version", "#{moduleVersion}");
				}
				
				if(apperModule.getType()!= null){
					VALUES("type", "#{type}");
				}
				
				if(apperModule.getStatus()!= null){
					VALUES("status", "#{status}");
				}
				
				if(apperModule.getUpdateTime()!= null){
					VALUES("update_time", "#{updateTime}");
				}
				
				if(apperModule.getCreateTime()!= null){
					VALUES("create_time", "#{createTime}");
				}
			
			}
		}.toString();
	}
	// 动态更新
	public String updateApperModule(ApperModule apperModule){
		
		return new SQL(){
			{
				UPDATE(APPERMODULETABLE);
				
				if(apperModule.getApper()!= null){
					VALUES("apper_id", "#{apper.id}");
				}
				
				if(apperModule.getDeveloperModule()!= null){
					VALUES("developer_module_id", "#{developerModule.id}");
				}
				
				
				
				if(apperModule.getModuleLogo() != null){
					VALUES("module_logo", "#{moduleLogo}");
				}
				
				if(apperModule.getModuleName()!= null){
					VALUES("module_name", "#{moduleName}");
				}
				
				if(apperModule.getModuleTitle()!= null){
					VALUES("module_title", "#{moduleTitle}");
				}
				
				if(apperModule.getModuleVersion()!= null){
					VALUES("module_version", "#{moduleVersion}");
				}
				
				if(apperModule.getType()!= null){
					VALUES("type", "#{type}");
				}
				
				if(apperModule.getStatus()!= null){
					VALUES("status", "#{status}");
				}
				
				if(apperModule.getUpdateTime()!= null){
					VALUES("update_time", "#{updateTime}");
				}
				
				if(apperModule.getCreateTime()!= null){
					VALUES("create_time", "#{createTime}");
				}
				
				WHERE(" id = #{id} ");
			}
		}.toString();
	}


}




