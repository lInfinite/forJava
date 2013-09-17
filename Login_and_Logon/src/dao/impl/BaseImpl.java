package dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import util.Page;

import dao.BaseDao;

public class BaseImpl implements BaseDao{


	private SessionFactory factory;
  
	@Override
	public void save_delete_update(Object obj, Operation o) {
		Session session = factory.getCurrentSession();
		Transaction t = session.beginTransaction();
		try{
			switch(o){
			    case SAVE:
			    	session.save(obj);
			        break;
			    case DELETE:
			    	session.delete(obj);
			        break;
			    case UPDATE:
			    	session.update(obj);
			        break;
			    default:
		   }
			t.commit();
		}catch(HibernateException he){
			t.rollback();
			he.printStackTrace();
		}
	}

	
	@Override
	public List queryAll(String entityName) {
		Session session = factory.getCurrentSession();
		Transaction t = session.beginTransaction();
		Query query = session.createQuery("from "+entityName);
		return query.list();
	}

	
	@Override
	public List query(String entityName, Object obj, Page page) {
        Session session = factory.getCurrentSession();
        Transaction t = session.beginTransaction();
        Map map = hasValue(obj);//obj中有值的get方法
        Query query = session.createQuery("from "+entityName + where(map));
        Iterator it = map.entrySet().iterator();
        while(it.hasNext()){
    		Entry<String,Object> entry = (Entry)it.next();
    		query.setParameter(entry.getKey(), entry.getValue());
        }
        //判断分不分页
        if(page!=null){
            query.setFirstResult(page.getPage());
            query.setMaxResults(page.getMax());
        }
		return query.list();
	}


	@Override
	public Object object(Class className, Long id) {
        Session session = factory.getCurrentSession();
        Transaction t = session.beginTransaction();
		return session.get(className, id);
	}

	@Override
	public Object object(Class className, String id) {
        Session session = factory.getCurrentSession();
        Transaction t = session.beginTransaction();
		return session.get(className, id);
	}

	
	public enum Operation {
	    SAVE,DELETE,UPDATE;
	}

    public Map<String,Object> hasValue(Object obj){
    	Map<String,Object> values = new HashMap<String, Object>();
    	Class c = obj.getClass();
    	Method[] methods = c.getMethods();
    	String key = null;
    	Object value = null;
    	String[] args={};
    	for(Method method : methods){
    		String name = method.getName();
            //获取get开头的方法
    		if(name.substring(0,3).equals("get")){
    			try {
					value = method.invoke(obj, args);
				} catch (IllegalArgumentException e) {
					value = null;
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					value = null;
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					value = null;
					e.printStackTrace();
				}
    			key = name.substring(3, name.length()).toLowerCase();
    			//过滤不是集成Object的getClass方法
    			if(key!=null && !key.equals("class")){    				
    				//过滤值不为null
    				if(value!=null){
    					values.put(key, value);
    				}
    			}
    			
    		}
    		
    	}
    	return values;
    }
	
    public String where(Map<String,Object> key){
    	Iterator it = key.entrySet().iterator();
    	String where = "";
    	//如果map的大小大于零就开始生成where语句
    	int len = key.size();
    	if(len>0){
	    	for(int i=0;it.hasNext();i++){
	    		Entry entry = (Entry)it.next();
	    		if(i<len-1){
		    		where += entry.getKey()+"=:"+entry.getKey()+" and ";
	    		}else if(i==len-1){
	    			where += entry.getKey()+"=:"+entry.getKey();
	    		}
	    	}
		    return " where "+where;
    	}else{
    		return "";
    	}
    }


	public SessionFactory getFactory() {
		return factory;
	}


	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}





    
    
}
