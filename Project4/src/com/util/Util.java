package com.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Util {
	
    //hibernate
	public SessionFactory getSessionFactory(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		return (SessionFactory)context.getBean("SessionFactory");
	}
	
	//md5
    public String eccrypt(String str){
        MessageDigest md5=null;
			try {
				md5 = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}  
        byte[] srcBytes = str.getBytes();
        md5.update(srcBytes);  
        byte[] resultBytes = md5.digest();  
        return new String(resultBytes);
    }  
    
	//系统时间
    public String systemTime(){
    	Date date=new Date();
    	String dt = new String(new SimpleDateFormat("yyyy-MM-dd").format(date));
    	String now = new SimpleDateFormat("yyyy-MM-dd").format(date);
    	return now;
    }
    

    
    
    
	//特殊字符过滤
	public String str(String str){
		str = str.replaceAll("\\~", "&#126;");
		str = str.replaceAll("\\}", "&#125;");
		str = str.replaceAll("\\|", "&#124;");
		str = str.replaceAll("\\{", "&#123;");
		str = str.replaceAll("\\_", "&#95;");
		str = str.replaceAll("\\^", "&#94;");
		str = str.replaceAll("\\]", "&#93;");
		str = str.replaceAll("\\\\", "&#92;");
		str = str.replaceAll("\\[", "&#91;");
		str = str.replaceAll("\\?", "&#63;");
		str = str.replaceAll("\\?", "&#63;");
		str = str.replaceAll("\\>", "&#62;");
		str = str.replaceAll("\\=", "&#61;");
    	str = str.replaceAll("\\<", "&#60;");
    	str = str.replaceAll("\\:", "&#59;");
    	str = str.replaceAll("\\/", "&#47;");
    	str = str.replaceAll("\\.", "&#46;");
    	str = str.replaceAll("\\-", "&#45;");
    	str = str.replaceAll("\\,", "&#44;");
    	str = str.replaceAll("\\+", "&#43;");
    	str = str.replaceAll("\\*", "&#42;");
    	str = str.replaceAll("\\)", "&#41;");
    	str = str.replaceAll("\\(", "&#40;");
    	str = str.replaceAll("\\'", "&#39;");
    	str = str.replaceAll("\\&", "&#38;");
    	str = str.replaceAll("\\%", "&#37;");
    	str = str.replaceAll("\\$", "&#36;");
    	str = str.replaceAll("\\#", "&#35");
    	str = str.replaceAll("\\!", "&#33;");
		return str;
	}
	
	
	
	public List<String> getMethodName(Object object){
		Class c = object.getClass();
		List<String> list= new ArrayList<String>();
		Method[] m = c.getDeclaredMethods();
		String name=null;
		for(Method method:m){
			name = method.getName();
			String get = (String) name.subSequence(0, 3);
			if(get.equals("get")){
			    list.add(name);
			}
		}
		return list;
	}
	

	
	public List<Class> getParameterType(Object object, String methodName) throws ClassNotFoundException{
		Class c = object.getClass();
		List<Class> list = new ArrayList<Class>();
		Method[] method = c.getDeclaredMethods();
		for(Method m:method){
			if(m.getName().equals(methodName)){
				Class[] pls = m.getParameterTypes();
				for(int i=0; i<pls.length; i++){	
					    Class p = pls[i];
					    list.add(p);
				}
			}
		}
		return list;
	}
	

	
	public Map<String, Object> getValue(Object object) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, ClassNotFoundException{
		Map<String, Object> map = new HashMap<String, Object>();
		Class c = object.getClass();
		List<String> method_list = getMethodName(object);
        Object[] arge={};
		for(String name : method_list){ 
			List<Class> arge_list = getParameterType(object,name);
			String notGet = name.substring(3, name.length()).toLowerCase();
			if(arge_list.size()==0){
				Method m = c.getMethod(name, null);
		        Object o = m.invoke(object, arge);
		        if(o!=null&&!o.equals("")){
		            map.put(notGet, o);
		        }
			}else{
				for(Class argeType : arge_list){
			        Method m = c.getMethod(name, argeType.getClasses());
			        Object o = m.invoke(object, arge);
			        if(o!=null&&!o.equals("")){
			            map.put(notGet, o);
			        }
				}
			}
		}
		return map;
	} 
}
