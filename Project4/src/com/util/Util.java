package com.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Util {
	
	
    //hibernate
	public SessionFactory getSessionFactory(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		return (SessionFactory)context.getBean("SessionFactory");
	}
    
    
    //sha1
    public String eccryptForSHA1(String str){
    	str = DigestUtils.sha1Hex(str);
    	return str;
    }
    
	//系统时间
    public String systemTime(){
    	Date date=new Date();
    	String dt = new String(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date));
    	String now = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
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
	
	
	//把Set类型转换成List类型 与页面交互
	public List list_for_OneToMany(Set one_to_many) {
		if(one_to_many == null){
			return null;
		}
		List list = new ArrayList();
		for(Object obj : one_to_many){
			list.add(obj);
		}
		return list;
	}
	
	
	//获取类型的方法名
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
	

	//
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
	

	//获取对象的get里有参数的值
	public Map<String, Object> getValue(Object object){
		Map<String, Object> map = new HashMap<String, Object>();
		Class c = object.getClass();
		List<String> method_list = getMethodName(object);
        Object[] arge={};
        try {
		for(String name : method_list){ 
			List<Class> arge_list;
				arge_list = getParameterType(object,name);
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
        } catch (ClassNotFoundException e) {
        	e.printStackTrace();
        } catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return map;
	} 
}
