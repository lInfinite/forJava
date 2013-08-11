package user.manager;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModifyManager extends HttpServlet{
     public void doPost(HttpServletRequest request,HttpServletResponse response){
    	 System.out.println("进入账单管理");
    	 ModifyDao modifyD=new ModifyDao();
    	 Modify m=new Modify();
    	 String submit=request.getParameter("submit");
    	 System.out.println(submit);
    	 if(submit.equals("确认")){
    		 System.out.println("开始插入......");
    		 int sum=Integer.parseInt(request.getParameter("sum"));
    		 int quantity=Integer.parseInt(request.getParameter("quantity"));
    		 String type=request.getParameter("type");
    		 String name=request.getParameter("username");
    		 String describe=request.getParameter("describe");
    		 String provider=request.getParameter("provider");
    		 String payment=request.getParameter("payment");
    		 m.setSum(sum);
    		 m.setQuantity(quantity);
    		 m.setType(type);
    		 m.setName(name);
    		 m.setDescribe(describe);
    		 m.setProvider(provider);
    		 m.setPayment(payment);
    		 modifyD.add(m);
    		 try {
				request.getRequestDispatcher("admin_bill_list.jsp").forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	 }else if(submit.equals("修改")){
    		 //sum=?,quantity=?,type=?,name=?,describe=?,payment=?,provider=? where id=?"
    		 System.out.println("开始修改.......");
    		String SUM=request.getParameter("sum");
    		String  QUANTITY=request.getParameter("quantity");
    		String  TYPE=request.getParameter("type");
    		String  USERNAME=request.getParameter("username");
    		String  DESCRIBE=request.getParameter("describe");
    		String  PROVIDER=request.getParameter("provider");
    		String  PAYMENT=request.getParameter("payment");
    		 System.out.println("sum="+SUM);
    		if(SUM!=""){ m.setSum(Integer.parseInt(SUM) );}
    		if(QUANTITY!=""){ m.setQuantity(Integer.parseInt(QUANTITY));}
    		if(TYPE!=""){ m.setType(TYPE);}
    		if(USERNAME!=""){ m.setName(USERNAME);}
    		if(DESCRIBE!=""){ m.setDescribe(DESCRIBE);}
    		if(PROVIDER!=""){ m.setProvider(PROVIDER);}
    		if(PAYMENT!=""){ m.setPayment(PAYMENT);}
    		m.setId(Integer.parseInt(request.getParameter("it_number")));
    		 modifyD.update(m);
    		 try {
 				request.getRequestDispatcher("admin_bill_list.jsp").forward(request, response);
 			} catch (ServletException e) {
 				e.printStackTrace();
 			} catch (IOException e) {
 				e.printStackTrace();
 			}
    	 }else if(submit.equals("删除")){
    		 System.out.println("开始删除.......");
    		 int deleteID=Integer.parseInt(request.getParameter("it_number"));
    		 modifyD.delete(deleteID);
    		 try {
				request.getRequestDispatcher("admin_bill_list.jsp").forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	 }
     }
     public void doGet(HttpServletRequest request,HttpServletResponse response){
    	String productname="%"+request.getParameter("productname")+"%";
    	String paystatus=request.getParameter("paystatus");
    	System.out.println("商品名称:"+productname+"  付款情况:"+paystatus);
    	ModifyDao md=new ModifyDao();
    	md.selectLike(1, 5,productname , paystatus);
     }
}
