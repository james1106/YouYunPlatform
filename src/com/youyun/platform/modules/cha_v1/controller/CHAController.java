package com.youyun.platform.modules.cha_v1.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baomidou.kisso.SSOHelper;
import com.baomidou.kisso.SSOToken;
import com.youyun.platform.sys.controller.BaseController;
import com.youyun.platform.sys.entity.Apper;
import com.youyun.platform.sys.entity.ApperEnterpriseDatum;
import com.youyun.platform.sys.entity.ApperModule;
import com.youyun.platform.sys.entity.ApperUser;

@Controller
@RequestMapping("/cha_v1")
public class CHAController extends BaseController{
	
	@RequestMapping(value="/index")
	 public String doIndex(
			 HttpServletRequest request,
			 HttpServletResponse response,
			 HttpSession session,
			 Model model
			 ){
		// 设置客户端跳转到模块设计界面
	
		
		SSOToken st = SSOHelper.getToken(request);
		
		Integer apperUserId = st.getId().intValue();
		
		
		ApperUser apperUser = apperSysService.findApperUserById(apperUserId);
		Apper apper = apperUser.getApper();
		ApperEnterpriseDatum apperDatum = apperSysService.findApperEnterpriseDatumByUser(apper);
		
		model.addAttribute("apper", apper);
		model.addAttribute("compnay", apperDatum.getCompany());
		model.addAttribute("apperUserName", apperUser.getUserName());
		model.addAttribute("apperRealName", apperUser.getRealName());
		
		//System.out.println("end");
		
		
	
		  
		return "/modules/cha_v1/index";
	}

}
