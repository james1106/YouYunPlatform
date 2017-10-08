package com.youyun.platform.sys.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.youyun.platform.sys.service.ApperSysService;

public class BaseController {
	@Autowired
	@Qualifier("apperSysService")
	protected ApperSysService apperSysService;
	

	
	@Autowired
	protected HttpServletResponse response;

}
