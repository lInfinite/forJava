package aa.bb;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ManagerTypeB implements Filter {


    public ManagerTypeB() {
    }

	public void destroy() {
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest hsrq=(HttpServletRequest) request;
        HttpServletResponse hsrp=(HttpServletResponse) response;
        String userType="";
        if((hsrq.getSession().getAttribute("user_type"))!=null) {
        	userType=(hsrq.getSession().getAttribute("user_type")).toString();
        	}
        if(userType.equals("管理")||userType.equals("用户")){
        	
        }else{
        	System.out.println("用户权限是"+userType);
        hsrp.setHeader("refresh", "0;url='login.jsp'");
        }
        chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {
	
	}

}
