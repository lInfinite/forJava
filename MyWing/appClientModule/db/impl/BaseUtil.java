package db.impl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 使用values得出两个List！value_name（保存key）和value（保存值）自身方法是返回Map<String,Object> 也保存了key and value
 * sql方法是用values得出的value_name以及table_name和枚举(选择添加、删除、修改用)生成sql语句
 * **/
public class BaseUtil {
    
	private List<String> value_name;
	private List<Object> value;
	
    public Map<String,Object> values(Object obj){
    	Map<String,Object> map = new HashMap();
    	this.value_name = new ArrayList<String>();
        this.value = new ArrayList<Object>();
        Object[] args = {};
    	Class c = obj.getClass();
    	Method[] method = c.getMethods();
    	for(Method m:method){
           String names = m.getName().toLowerCase();
           if(names.substring(0, 3).equals("get")){
        	   String name = names.substring(3, names.length());
        	   if(!name.equals("class")&&!name.equals("id")){
        		    Object value;
					try {
						value = m.invoke(obj, args);
					} catch (IllegalArgumentException e) {
						value=null;
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						value=null;
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						value=null;
						e.printStackTrace();
					}
        		    if(value!=null){
        		    	map.put(name, value);
        		    	this.value_name.add(name);
        		    	this.value.add(value);
        		    }
        	   }
           }
    	}
    	return map;
    }
    
    
    public void setterValue(Object obj, String methodName, Object value){
     	Class c = obj.getClass();
     	String top = methodName.substring(0, 1).toUpperCase();
     	String ethod = methodName.substring(1, methodName.length());
     	
     		try {
     			Field filed = c.getDeclaredField(methodName);
     			filed.setAccessible(true);
				Method method = c.getMethod("set"+top+ethod,filed.getType());
				method.invoke(obj, value);
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			}
    }
    
    
    public List<String> entityNames(Object obj){
    	List<String> list = new ArrayList<String>();
    	Class c = obj.getClass();
    	Field[] fileds = c.getDeclaredFields();
    	for(int i=0; i<fileds.length; i++){
    		list.add(fileds[i].getName());
    	}
    	return list;
    }
    

    public String sql(String tableName,List<String> value_name, sdu em){
    	String sqls = "";
    	switch (em) {
			case SAVE:
		    	String save_names = null;
		    	String qs = null;
		    	int len = value_name.size();
		    	int save_i = 0;
		    	if(len>0){
			    	for(String value : value_name){
			    		if(save_i==0){
			    			save_names = value;
			    			qs="?";
			    		}else{
			    			save_names += ","+value;
				    		qs += ",?";
			    		}
			    		save_i++;
			    	}
		    	}
				sqls = "INSERT INTO "+tableName+"("+save_names+")VALUES("+qs+")";
				break;
				
	        case DELETE:
	        	sqls = "DELETE FROM "+tableName+" where id=?";
	            break;
	            
		    case UPDATE:
		    	int update_i = 0;
		    	String update_names = null;
		    	for(String name : value_name){
	        		if(update_i==0){
	        			update_names = name+"=?";
	        		}else{
	        			update_names += ","+name+"=?";
	        		}
		    		update_i++;
		    	}
		    	sqls = "UPDATE "+tableName+" set "+update_names+" where id=?";
				break;
			default:
				System.out.println("How did you do it？");
				break;
			}
    	return sqls;
    }
    
    
    public String entityName(Object obj){
    	Class c = obj.getClass();
    	Package packages = c.getPackage();
    	String packages_str = packages.getName();
    	int len = packages_str.length();
    	String entity = c.getName();
    	return entity.substring(len+1, entity.length()).toLowerCase();
    }
    
    
    
    
    public List<String> getValue_name(){
    	return this.value_name;
    }
    
    
    public List<Object> getValue(){
    	return this.value;
    }

    



	public enum sdu{
    	SAVE,DELETE,UPDATE;
    }
}
