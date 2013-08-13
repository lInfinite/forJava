package domain;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entity.*;

import com.util.Util;

public class DoMain {
	public static void main(String[] arge){
		DoMain domain = new DoMain();
		domain.initTable();
	}
	
	
	
	public void initTable(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Util util = (Util)context.getBean("Util");
		Session session = util.getSessionFactory().getCurrentSession();
		Transaction t = session.beginTransaction();
		try{
			CreateClinet create_clinet = new CreateClinet();
			SellChance sell_chance = new SellChance();
			Role role = new Role();
			User user = new User();
			Region region = new Region();
			ClintLevel clint_level = new ClintLevel();
			
			session.save(sell_chance);
		    session.save(create_clinet);
		    session.save(role);
		    session.save(user);
		    session.save(region);
		    session.save(clint_level);
		    t.commit();
		}catch(HibernateException he){
			t.rollback();
			he.printStackTrace();
		}
		
	}

}
