package com.youyun.platform.sys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http. HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.baomidou.kisso.SSOConfig;
import com.baomidou.kisso.SSOHelper;
import com.baomidou.kisso.SSOToken;
import com.baomidou.kisso.annotation.Action;
import com.baomidou.kisso.annotation.Login;
import com.baomidou.kisso.annotation.Permission;
import com.baomidou.kisso.common.encrypt.SaltEncoder;
import com.baomidou.kisso.common.util.RandomUtil;
import com.baomidou.kisso.web.waf.request.WafRequestWrapper;
import com.youyun.platform.sys.common.utils.ApperSysConstants;
import com.youyun.platform.sys.entity.Apper;
import com.youyun.platform.sys.entity.ApperEnterpriseDatum;
import com.youyun.platform.sys.entity.ApperModule;
//import com.baomidou.springwind.common.MyCaptcha;
//import com.baomidou.springwind.entity.User;
//import com.jsyouyun.appmarket.common.utils.AppMarketConstants;
//import com.jsyouyun.appmarket.entity.SysUser;
import com.youyun.platform.sys.entity.ApperUser;
import com.youyun.platform.sys.entity.ApperUserModule;

@Controller
public class IndexController extends BaseController {
	
	@Login(action = Action.Skip)
	@RequestMapping(value="/index")
	 public String index(
			 HttpServletRequest request,
			 HttpSession session,
			 Model model
			 ){
		// 设置客户端跳转到模块设计界面
		
		
		String urlSign = request.getParameter("u");
		SSOToken st = SSOHelper.getToken(request);
		
		if ((urlSign == null || urlSign.equals("")) && 
				st == null && 
				session.getAttribute(ApperSysConstants.APPERSYS_SESSION) == null) {
			return "/sys/illAccess";
			
		} else if ((urlSign == null || urlSign.equals("")) && st != null) {
			//st.setData(urlSign);
			urlSign = st.getData();
		} else if ((urlSign == null || urlSign.equals("")) && 
				st == null &&
				session.getAttribute(ApperSysConstants.APPERSYS_SESSION)  != null) {
			Apper apper = (Apper)session.getAttribute(ApperSysConstants.APPERSYS_SESSION);
			urlSign = apper.getUrlSign();
			//session.
		}
		Apper apper = apperSysService.findApperByUrlSign(urlSign);
		if (apper == null) {
			return "/sys/illAccess";
		}
			
		//session.
		
		session.setAttribute(ApperSysConstants.APPERSYS_SESSION, apper);
		return "redirect:/doIndex";
		
	}
	
	
	@RequestMapping(value="/doIndex")
	 public String doIndex(
			 HttpServletRequest request,
			 HttpSession session,
			 Model model
			 ){
		// 设置客户端跳转到模块设计界面
		
		
		SSOToken st = SSOHelper.getToken(request);
		Integer apperUserId = st.getId().intValue();
		//System.out.println("apperUserId :" + apperUserId );
	//	System.out.println("userName :" + st.getData() );
		String urlSign = st.getData();
		ApperUser apperUser = apperSysService.findApperUserById(apperUserId);
		Apper apper = apperSysService.findApperByUrlSign(urlSign);
		ApperEnterpriseDatum apperDatum = apperSysService.findApperEnterpriseDatumByUser(apper);
		//System.out.println("apper:" + apper);
		List<ApperModule> apperModules = apperSysService.findApperModuleByUser(apper, apperUser, 1);
		//System.out.println("apperModule:" + apperModules);
		model.addAttribute("apperUser", apperUser);
		model.addAttribute("apper", apper);
		model.addAttribute("company", apperDatum.getCompany());
		model.addAttribute("companyAddress", apperDatum.getAddress());
		model.addAttribute("apperModules", apperModules);
	//	System.out.println("end");
		  
		return "/sys/main";
	}
	
	
	
	@Login(action = Action.Skip)
	@RequestMapping(value="/login")
	 public String login(
			 HttpServletRequest request,
			 HttpSession session,
			 Model model
			 ){
		// 设置客户端跳转到模块设计界面
		SSOToken st = SSOHelper.getToken(request);
		Apper apper = null;
		if (st == null) {
			if (session.getAttribute(ApperSysConstants.APPERSYS_SESSION) == null) {
				System.out.println("444");
				return "/sys/illAccess";
			} else {
				apper = (Apper)session.getAttribute(ApperSysConstants.APPERSYS_SESSION);
			}
		} else {
			String urlSign = st.getData();
			apper = apperSysService.findApperByUrlSign(urlSign);
		}
		
		
		ApperEnterpriseDatum apperDatum = apperSysService.findApperEnterpriseDatumByUser(apper);
		model.addAttribute("urlSign", apper.getUrlSign());
		model.addAttribute("company", apperDatum.getCompany());
		model.addAttribute("companyAddress", apperDatum.getAddress());
		String errorMsg = request.getParameter("errorMsg");
		if (errorMsg!= null && !errorMsg.equals("") ) {
			model.addAttribute("errorMsg", errorMsg);
		}
			
		
		return "/sys/login";
	}
	
	@Login(action = Action.Skip)
	@RequestMapping(value="/doLogin")
	 public String doLogin(
			 HttpServletRequest request,
			 HttpSession session,
			 Model model
			 ){
		// 设置客户端跳转到模块设计
		String errorMsg = "用户名或密码错误";
			/**
			 * 过滤 XSS SQL 注入
			 */
		WafRequestWrapper wr = new WafRequestWrapper(request);
		//String ctoken = wr.getParameter("ctoken");
			//String captcha = wr.getParameter("captcha");
		//if (StringUtils.isNotBlank(ctoken)) {
				//	&& StringUtils.isNotBlank(captcha)
					//&& MyCaptcha.getInstance().verification(wr, ctoken, captcha)) {
		String userName = wr.getParameter("userName"); 
		String userPwd = wr.getParameter("userPwd");
		String urlSign = wr.getParameter("urlSign");
	//	System.out.println("userName:" + userName + ", userPwd:" + userPwd);
	//	System.out.println("login00");
		Apper apper = apperSysService.findApperByUrlSign(urlSign);
		//System.out.println("111apper:" + apper);
		ApperUser apperUser = apperSysService.login(apper.getId(), userName, userPwd);
		
		//System.out.println("login11");
		//System.out.println("apperUser:" + apperUser);
		if (apperUser != null ) {
			SSOToken st = new SSOToken(request);
			st.setId(new Long(apperUser.getId()));
			st.setData(urlSign);
		//	st.setObject(apper);
			
			
			
			
			
					
					// 记住密码，设置 cookie 时长 1 周 = 604800 秒
			String rememberMe = wr.getParameter("rememberMe");
			if ("on".equals(rememberMe)) {
				request.setAttribute(SSOConfig.SSO_COOKIE_MAXAGE, 604800);
			}
			
		
			SSOHelper.setSSOCookie(request, response, st, true);
			//session.setAttribute(ApperSysConstants.APPERSYS_SESSION, apper);
		//	return "/sys/main";
			return "redirect:/doIndex";
			
		} else {
			//errorMsg = "验证码错误";
			errorMsg = "用户名或密码错误";
			model.addAttribute("errorMsg", errorMsg);
			return "redirect:/login";
		}
	}
	
	@RequestMapping(value="/goModule")
	 public String goModule(
			 HttpServletRequest request,
			 HttpSession session,
			 Model model
			 ){
		// 设置客户端跳转到模块设计界面
		
		SSOToken st = SSOHelper.getToken(request);
		Integer apperUserId = st.getId().intValue();
		String urlSign = st.getData();
		
		ApperUser apperUser = apperSysService.findApperUserById(apperUserId);
		Apper apper = apperSysService.findApperByUrlSign(urlSign);
		
		Integer moduleId = Integer.parseInt(request.getParameter("m"));
		ApperModule apperModule = apperSysService.findApperModuleById(moduleId);
		
		ApperUserModule apperUserModule = apperSysService.findApperModuleByApperAndUserAndModule(apper, apperUser, apperModule);
		
		if (apperUserModule != null) {
			apperModule = apperUserModule.getApperModule();
		
			if (apperModule != null) {
				if (apperModule.getStatus() == 1) {
					String moduleName= apperModule.getModuleName();
					return "redirect:/" + moduleName + "/index";
				}
			}
			
		}
		return "redirect:/index";
			
	}
	
	/**
	 * 退出
	 */
	@Login(action = Action.Skip)
	@RequestMapping("/logout")
	public String logout( 
			HttpServletRequest request,
			 HttpSession session,
			 Model model) {
		SSOToken st = SSOHelper.getToken(request);
		String urlSign = st.getData();
		Apper apper = apperSysService.findApperByUrlSign(urlSign);
		session.setAttribute(ApperSysConstants.APPERSYS_SESSION, apper);
		//session.
		//SSOHelper.getLoginCount(request);
		//try {
	//		SSOHelper.logout(request, response);
	//	} catch (Exception ex) {
			
	//	}
		SSOHelper.clearLogin(request, response);
		return "redirect:/login";
	}

	
	
}
