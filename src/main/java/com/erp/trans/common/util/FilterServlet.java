package com.erp.trans.common.util;

import java.io.IOException;

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

/**
 * 全局请求过滤器
 */
public class FilterServlet implements Filter {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private String[] uriRegexExpress = {
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
		
		if(!requestURI.matches("[^\\s]+\\.(jpg|jpeg|png|bmp|gif|js|html|css|ico|svg|woff|woff2|map|rar)")){
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
			}
		}
		
		filterChain.doFilter(request, response);
	}
	
	public void init(FilterConfig filterConfig) throws ServletException {}

	public void destroy() {}	
}
