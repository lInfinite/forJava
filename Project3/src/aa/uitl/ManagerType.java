package aa.uitl;

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

import aa.entity.Users;

public class ManagerType implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hsrq=(HttpServletRequest) request;
		HttpServletResponse hsrp=(HttpServletResponse) response;
		HttpSession session = hsrq.getSession();
		if(session.getAttribute("user")!=null){
		    
		}else{
			hsrp.setHeader("refresh", "0;url='logon.jsp'");
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
    
}
