package user.manager;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProviderManager extends HttpServlet {
 public void doPost(HttpServletRequest request,HttpServletResponse response){
	 System.out.println("进入供货商管理");
	 ProviderDao providerD=new ProviderDao();
	 Provider provider=new Provider();
	 String submit=request.getParameter("button");
	 if(submit.equals("提交")){
		 provider.setNum(Integer.parseInt(request.getParameter("proId")));
		 provider.setName(request.getParameter("proName"));
		 provider.setDescribe(request.getParameter("proDesc"));
		 provider.setPreson(request.getParameter("contact"));
		 provider.setPhone(request.getParameter("phone"));
		 provider.setFax(Integer.parseInt(request.getParameter("fax")));
		 provider.setAddress(request.getParameter("address"));
		 providerD.add(provider);
		 try {
			request.getRequestDispatcher("providerAdamin.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	 }else if(submit.equals("修改")){

		 //T num=?,name=?,describe=?,preson=?,phone=?,fax=?,address=?where id=?
		 String NUM=request.getParameter("proId");
		 String PRONAME=request.getParameter("proName");
		 String PRODESC=request.getParameter("proDesc");
		 String CONTACT=request.getParameter("contact");
		 String PHONE=request.getParameter("phone");
		 String FAX=request.getParameter("fax");
		 String ADDRESS=request.getParameter("address");
		 if(NUM !=""){provider.setNum(Integer.parseInt(NUM));}
		 if(PRONAME !=""){ provider.setName(PRONAME);}
		 if(PRODESC !=""){ provider.setDescribe(PRODESC);}
		 if(CONTACT !=""){provider.setPreson(CONTACT);}
		 if(PHONE !=""){provider.setPhone(PHONE);}
		 if(FAX !=""){provider.setFax(Integer.parseInt(FAX));}
		 if(ADDRESS !=""){ provider.setAddress(ADDRESS);}
		 provider.setId(Integer.parseInt(request.getParameter("it_number")));
		 providerD.update(provider);
		 try {
			request.getRequestDispatcher("providerAdamin.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	 }else if(submit.equals("删除")){
		 providerD.delete(Integer.parseInt(request.getParameter("it_number")));
		 try {
			request.getRequestDispatcher("providerAdamin.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	 }
 }
}
