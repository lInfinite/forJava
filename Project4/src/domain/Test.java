package domain;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.impl.BaseImpl;
import com.entity.SellChance;
import com.service.dao.SellDao;
import com.service.dao.impl.SellImpl;
import com.util.Util;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//BaseImpl base = (BaseImpl)context.getBean("BaseImpl");
		SellImpl sell = (SellImpl)context.getBean("SellImpl");
		Util util = (Util)context.getBean("Util");
		String a ="~ @ # $ % ^ & * ( ) - + = ' : ; < > / ? \\ \" [ ] { } ";
				  
		
		System.out.println(util.str(a));
	}
}
