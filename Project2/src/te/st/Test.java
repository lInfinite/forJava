package te.st;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.*;

import user.manager.ModifyDao;

public class Test extends HttpServlet {
    public void doGet(HttpServletRequest request,HttpServletResponse response){
    	String productname="%"+request.getParameter("productname")+"%";
    	String paystatus=request.getParameter("paystatus");
    	try {
			productname=productname.getBytes("gbk").toString();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    	System.out.println("��Ʒ����:"+productname+"  �������:"+paystatus);
    	ModifyDao md=new ModifyDao();
    	md.selectLike(1, 5,productname , paystatus);
    }
}
