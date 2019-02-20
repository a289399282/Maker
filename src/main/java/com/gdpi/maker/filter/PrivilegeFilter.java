package com.gdpi.maker.filter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gdpi.maker.pojo.Developer;


public class PrivilegeFilter implements Filter {
	private List<String> admin_list = new ArrayList<String>();
	private List<String> developer_list = new ArrayList<String>();
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String uri = req.getRequestURI().substring(6);
		
		if(developer_list.contains(uri)){
			Developer developer=(Developer) req.getSession().getAttribute("developer");
			if (req.getSession(false)==null || developer==null) {
				//response.getWriter().write(req.getContextPath()+"/login.jsp");
				resp.sendRedirect(req.getContextPath()+"/login");
				return;
			}
			/*if(admin_list.contains(uri) && "admin".equals(user.getRole())){
				chain.doFilter(request, response);
			}else */
			if(developer_list.contains(uri)){
				chain.doFilter(request, response);
			}else{
				throw new RuntimeException("您不具有对应的权限!!!");
			}
		}else{
			//不需要权限
			chain.doFilter(request, response);
		}
		
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		ServletContext context = filterConfig.getServletContext();
		try {
			String line = null;
			/*BufferedReader adminReader = new BufferedReader(new FileReader(context.getRealPath("WEB-INF/admin.txt")));
			while((line=adminReader.readLine())!=null){
				admin_list.add(line);
			}*/
			
			BufferedReader userReader = new BufferedReader(new FileReader(context.getRealPath("WEB-INF/developer.txt")));
			line = null;
			while((line=userReader.readLine())!=null){
				developer_list.add(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
