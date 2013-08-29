package domain;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.impl.BaseImpl;
import com.entity.Product;
import com.entity.Role;
import com.entity.SellChance;
import com.entity.Stock;
import com.entity.User;
import com.service.dao.SellDao;
import com.service.dao.impl.SellImpl;
import com.util.Page;
import com.util.Util;

public class Test {
	public static void main2(String[] args) {
		Page page = new Page();
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		BaseImpl base = (BaseImpl)context.getBean("BaseImpl");
/*		SellImpl sell = (SellImpl)context.getBean("SellImpl");
		Util util = (Util)context.getBean("Util");
		String a ="~ @ # $ % ^ & * ( ) - + = ' : ; < > / ? \\ \" [ ] { } ";
		System.out.println(util.str(a));*/
		List<Role> role_list = base.query("Role", null, page.getPage(), 5);
		for(Role role:role_list){
			System.out.println("role_id:"+role.getId());
		}
		System.out.println("=====================================================");
		List<User> user_list = base.query("User", null, page.getPage(), 5);
		for(User user: user_list){
			System.out.println("user_name:"+user.getName());
		}
		
		User u = (User)base.object(User.class, 1);
		System.out.println("u.name" + u.getName());
	}
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		BaseImpl base = (BaseImpl)context.getBean("BaseImpl");
		Util util = (Util)context.getBean("Util");
	
		User user = new User();
    	Role role = new Role();
    	role.setName("客户经理");
    	try{
    	role = (Role)base.query("Role", util.getValue(role)).get(0);
    	user.setRole(role);
    	System.out.println(user.getRole().getName());
    	}catch(IndexOutOfBoundsException e){
    		e.printStackTrace();
    	}
    	List<User> user_list = base.query("User", util.getValue(user));
    	for(User u : user_list){
    		System.out.println(u.getName());
    	}
		
	}
}
