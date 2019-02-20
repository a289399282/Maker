package com.gdpi.maker.filter;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.gdpi.maker.pojo.Developer;
import com.gdpi.maker.service.DeveloperService;
import com.gdpi.maker.utilsmy.StringUtils;

public class AutologinFilter implements Filter {
	@Autowired
	private DeveloperService developerService;
	
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		//1.只有未登录的用户才自动登录
		if(req.getSession(false)==null || req.getSession().getAttribute("user")==null){
			//2.只有带了自动登陆cookie的用户才自动登陆
			Cookie [] cs = req.getCookies();
			Cookie findC = null;
			if(cs!=null){
				for(Cookie c : cs){
					if("autologin".equals(c.getName())){
						findC = c;
						break;
					}
				}
			}
			if(findC!=null){
				//3.只有自动登录cookie中的用户名密码都正确才做自动登陆
				String v = URLDecoder.decode(findC.getValue(),"utf-8");
				String username = v.split(":")[0];
				String password = v.split(":")[1];
				Developer developer=new Developer();
				//账号登录
				if("Dev".equals(username.substring(0, 3))){
					developer.setDevId(username);
				}else 
				//电话登录
				if(StringUtils.isNum(username)){
					developer.setDevPhone(username);
				}
				developer.setDevPasswordmd5(password);
				Developer developer2 = developerService.selectOneDeveloper(developer);
				
				if(developer2!=null){
					req.getSession().setAttribute("developer", developer2);
				}
			}
		}
		
		
		//4.无论是否自动登陆都要放行
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
