package login.user;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import user.manager.UserDao;

public class UserLogin extends HttpServlet {
   public void doPost(HttpServletRequest request,HttpServletResponse response){
	     UserDao ud=new UserDao();
	  	 String name="";
	  	 String pass="";
	  	if(request.getParameter("userName")!=null){name=request.getParameter("userName");};
	  	if(request.getParameter("passWord")!=null){pass=request.getParameter("passWord");}
	  	 boolean login=ud.login(name, pass, request);
	  	 HttpSession session=request.getSession();
    	 if(login==true){
    		 System.out.println("µÇÂ½³É¹¦");
    		response.setHeader("refresh", "0;url='admin_index.html'");
    	 }else{
    		 System.out.println("µÇÂ½Ê§°Ü");
    		 String xx="µÇÂ½Ê§°Ü£¬ÇëÖØÐÂµÇÂ½£¡";
    		 request.setAttribute("xxx", xx);
    		 response.setHeader("refresh", "0;url='login.jsp'");
    	 }
   }
   public void doGet(HttpServletRequest request,HttpServletResponse response){
  	 HttpSession hs=request.getSession();
  	 UserDao ud=new UserDao();
  	 String exit="";
  	 if(request.getParameter("exit")!=null){ exit=request.getParameter("exit");}
  	 System.out.println(exit);  
	  	if(hs!=null&&exit.equals("exit")){
	  		System.out.println("ÓÃ»§×¢Ïú");
	  		hs.invalidate();
	  	}
	  		response.setHeader("refresh", "0;url='login.jsp'");
	  	
  	 }

}
