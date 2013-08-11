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


public class ManagerType implements Filter {


    public ManagerType() {
    }

	public void destroy() {
	}

	/*it_num=<%=u.getId() %>*/
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest hsrq=(HttpServletRequest) request;
        String id=hsrq.getSession().getAttribute("user_id").toString();
        String typeid=hsrq.getParameter("it_num");
        int ID=Integer.parseInt(id);
        int typeID=Integer.parseInt(typeid);
        String userType=(hsrq.getSession().getAttribute("user_type")).toString();
        if(userType.equals("管理")||ID==typeID){
        	
        }else{
        	System.out.println("用户权限是"+userType);
        	hsrq.getRequestDispatcher("back.jsp").forward(request, response);
        }
        chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {
	
	}

}
