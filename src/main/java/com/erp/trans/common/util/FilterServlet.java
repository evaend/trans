package com.erp.trans.common.util;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.erp.trans.common.constant.CustomConst;
import com.erp.trans.common.constant.CustomConst.LoginUser;
import com.erp.trans.entity.UserInfo;

/**
 * 全局请求过滤器
 */
public class FilterServlet implements Filter {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private String[] uriRegexExpress = {
			"/lib/[^\\s]*",
			 "/js/login.js",
			 "/login/login" ,
			 "/",
			 "182.254.152.181",
			 "wuliu101.com",
			 "www.wuliu101.com",
			"/login/userLogin" // 用户登录
	};
	
	/**
	 * 实现过滤方法
	 */
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String requestURI = request.getRequestURI().replaceAll("[/\\\\]{2,}", "/");
		String contextPath = request.getContextPath();
//		String referer = request.getHeader("Referer");
		
//		logger.debug("RequestURI = " + request.getRequestURI());
		if(logger.isTraceEnabled()){
			logger.trace("请求参数 : " + JSONUtils.toJson(request.getParameterMap()));
		}
		
		if(!requestURI.matches("[^\\s]+\\.(jpg|jpeg|png|bmp|gif|css|html|ico|svg|woff|woff2|map|rar|ico)")){
			//放过的请求
			for (String regex: uriRegexExpress) {
				String compareRegex = contextPath + regex;
				if(requestURI.matches(compareRegex)){
					filterChain.doFilter(request, response);
					return ; 
				}
			}
			//如果是页面登录、登出请求
//			if(requestURI.equalsIgnoreCase(contextPath+"/login/userLogin")
//					|| requestURI.equalsIgnoreCase(contextPath+"/login/login")	
//					){
//				if(referer != null && referer.contains(contextPath)){//检查Referer
//					filterChain.doFilter(request, response);
//					return ; 
//				}else{
//					request.getRequestDispatcher("/login/login").forward(request, response);
//					return;
//				}
//			}
			
			HttpSession session = request.getSession(false); 
			//其他请求需判断session中用户登录是否成功
			if (session == null || session.getAttribute(CustomConst.LoginUser.SESSION_USERID) == null){
				response.setStatus(CustomConst.ResponseStatus.UNLOGIN);
				return;
			}else{
				  //财务
				  List<String> cwMenuList = Arrays.asList("tyfCharge.js","cysCharge.js","sjCharge.js",
						  "wages.js","officePlace.js","clzd.js","revenue.js","depreciation.js","insurance.js",
						  "incomeContract.js","costContract.js","trailerArchives.js","personalArchives.js");		  
				  //调度
				  List<String> ddMenuList = Arrays.asList("plan.js","waybill.js","addNoLoad.js");
				  //报表
				  List<String> bbList = Arrays.asList("dataStatistics.js");
				  UserInfo userInfo = (UserInfo)session.getAttribute(LoginUser.SESSION_USER_INFO);
				  if(userInfo.getUserType().equals("1")){//调度
					  if(cwMenuList.contains(requestURI)){
						  response.setStatus(CustomConst.ResponseStatus.PERMISSIONREFUSE);
						  return;
					  }
				  }else if(userInfo.getUserType().equals("2")){//财务
					  if(ddMenuList.contains(requestURI)){
						  response.setStatus(CustomConst.ResponseStatus.PERMISSIONREFUSE);
						  return;
					  }
				  }
//				  cwMenuList.
//				  requestURI.indexOf(str)
			}
		}
		
		filterChain.doFilter(request, response);
	}
	
	public void init(FilterConfig filterConfig) throws ServletException {}

	public void destroy() {}	
}
