package aa.test.main;

import java.util.List;

import aa.base.dao.BaseDao;
import aa.base.dao.impl.BaseImpl;
import aa.entity.*;
import aa.service.dao.UserServiceDao;
import aa.service.dao.impl.MailSericeImpl;
import aa.service.dao.impl.UserServiceImpl;
import aa.uitl.StaticHibernate;
import aa.web.action.MailAction;

import org.hibernate.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.ContextLoaderListener;

public class Test {
    private StaticHibernate sh = new StaticHibernate();
	public static void main(String[] args) {
          MailAction ma = new MailAction();
          MailSericeImpl msi = new MailSericeImpl();
          List<Users> list = msi.selectUsers();
         for(int i=0; i<list.size(); i++){
        	 Users user = list.get(i);
        	 System.out.println(user.getName());
        	 
         }
         
	}
	public void testSave(){
		SessionFactory sf = sh.getSessionFactory();
		Session session = sf.openSession();
		Users user = new Users();
        user.setAge(22);
        user.setAddress("ßíÖª");
        user.setName("admin");
        user.setPassword("admin");
        user.setNames("¸ÖÌúÏÀ");
        user.setPhone("12345678910");
        user.setSex("ÄÐ");
       
		session.save(user);
		Transaction t = session.beginTransaction();
		t.commit();
		session.close();
	}
	
	public void testSelectAll(){
		BaseDao bd = new BaseImpl();
		List<Users> list = bd.selectAll("Users");
		
		for(int i=0;i<list.size();i++){
		    Users user = list.get(i);
		    System.out.println("²âÊÔÃû:"+user.getName());
		}	
	}
	
	public void testSelectOne(){
		BaseDao bd = new BaseImpl();
		String[] valueName={"name"};
		Object[] value={"admin"};
		List<Users> list = bd.selectCriteria("Users",valueName,value);
		for(int i=0;i<list.size();i++){
			Users user = list.get(i);
			System.out.println("²âÊÔÃû:"+user.getName());
		}	
	}
	
    public List<Users> pageSelect(){
    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    	UserServiceDao user_dao = (UserServiceDao)context.getBean("UserServiceImpl");
    	return user_dao.userList(1);
    }

	public void testSelectNameAndPassword(){
		BaseDao bd = new BaseImpl();
		String[] valueName={"name","password"};
		Object[] value={"admin","haha"};
		List<Users> list = bd.selectCriteria("Users",valueName,value);
		for(int i=0;i<list.size();i++){
			Users user = list.get(i);
			System.out.println("²âÊÔÃû:"+user.getName());
		}	
	}
}
