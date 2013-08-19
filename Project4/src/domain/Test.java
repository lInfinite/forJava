package domain;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.impl.BaseImpl;
import com.entity.Role;
import com.entity.SellChance;
import com.entity.User;
import com.service.dao.SellDao;
import com.service.dao.impl.SellImpl;
import com.util.Page;
import com.util.Util;

public class Test {
	public static void main(String[] args) {
		Page page = new Page();
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		BaseImpl base = (BaseImpl)context.getBean("BaseImpl");
/*		SellImpl sell = (SellImpl)context.getBean("SellImpl");
		Util util = (Util)context.getBean("Util");
		String a ="~ @ # $ % ^ & * ( ) - + = ' : ; < > / ? \\ \" [ ] { } ";
		System.out.println(util.str(a));*/
		List<Role> role_list = base.query("Role", page.getPage(), 5);
		for(Role role:role_list){
			System.out.println("role_id:"+role.getId());
		}
		System.out.println("=====================================================");
		List<User> user_list = base.query("User", page.getPage(), 5);
		for(User user: user_list){
			System.out.println("user_name:"+user.getName());
		}
	}
}
