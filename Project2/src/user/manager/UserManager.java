package user.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserManager extends HttpServlet {
  public void doPost(HttpServletRequest request,HttpServletResponse response){
     String submit=request.getParameter("submit");
     UserDao ud=new UserDao();
     System.out.println(submit);
     if(submit.equals("数据提交")){
    	 System.out.println("添加");
         User u=new User();
         String NAME=request.getParameter("username");
         String PASS=request.getParameter("password");
         String SEX=request.getParameter("sex");
         String AGE=request.getParameter("age");
         int age=Integer.parseInt(AGE);
         String MOBILE=request.getParameter("mobile");
         String ADDRESS=request.getParameter("address");
         String AUTH=request.getParameter("auth");
         u.setName(NAME);
         u.setPassword(PASS);
         u.setSex(SEX);
         u.setAge(age);
         u.setPhone(MOBILE);
         u.setAddress(ADDRESS);
         u.setType(AUTH);
    	 ud.add(u); 
    	 try {
  			request.getRequestDispatcher("userAdmin.jsp").forward(request, response);
  		} catch (ServletException e) {
  			e.printStackTrace();
  		} catch (IOException e) {
  			e.printStackTrace();
  		}
     }else if(submit.equals("修改")){
     	 int id=Integer.parseInt(request.getParameter("it_num"));
         update(request,ud,id);	
         try {
			request.getRequestDispatcher("userAdmin.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
     }else if(submit.equals("删除")){
    	 System.out.println("删除用户信息");
    	 int id=Integer.parseInt(request.getParameter("it_num"));
    	 ud.delete(id);
    	 try {
 			request.getRequestDispatcher("userAdmin.jsp").forward(request, response);
 		} catch (ServletException e) {
 			e.printStackTrace();
 		} catch (IOException e) {
 			e.printStackTrace();
 		}
     }else if(submit.equals("修改密码")){
    	 System.out.println("提交当前用户信息并跳转到修改密码页面");
     	 int id=Integer.parseInt(request.getParameter("it_num"));
         update(request,ud,id);
         request.setAttribute("it_num", id);
		 try {
			request.getRequestDispatcher("user_1.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
     }else if(submit.equals("修改密码二")){
   	     User u=new User();
   	     int id=Integer.parseInt(request.getParameter("it_num"));
   	     String pass1=request.getParameter("user_pass");
   	     String oldpass=ud.getPass(id);
   	     if(pass1.equals(oldpass)){
   	     String pass2=request.getParameter("user_newpass");
   	     u.setId(id);
   	     u.setPassword(pass2);
    	 System.out.println("修改密码");
    	 try {
			request.getRequestDispatcher("userAdmin.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	 ud.uppass(u);
   	     }else{
   	    	 request.setAttribute("it_num", id);
   	    	 request.setAttribute("oldpass", "被修改的用户密码不正确!!!");
   	    	 try {
   	    		request.getRequestDispatcher("user_1.jsp").forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
   	    }
     }
  }	 
  public void update(HttpServletRequest request,UserDao ud,int id){
	  User u=new User();
 	 System.out.println("修改用户信息");
 	 String NAME=request.getParameter("username");
 	 String SEX=request.getParameter("sex");
 	 String PHONE=request.getParameter("mobile");
 	 String ADDRESS=request.getParameter("address");
 	 String AGE=request.getParameter("age");
      u.setId(id);
 	 if(NAME!="") {u.setName(NAME);}
 	 if(SEX!="") {u.setSex(SEX);}
 	 if(AGE!=""){ 
 		int age=Integer.parseInt(AGE);
 		u.setAge(age);}
 	 if(PHONE!="") {u.setPhone(PHONE);}
 	 if(ADDRESS!=""){ u.setAddress(ADDRESS);}
 	 ud.update(u);
  }
}
