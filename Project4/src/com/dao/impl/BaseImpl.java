package com.dao.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dao.BaseDao;
import com.util.Util;

public class BaseImpl implements BaseDao {
    private Util util;
    
    
	@Override
	public void add(Object object) {
         Session session = util.getSessionFactory().getCurrentSession();
         Transaction t = session.beginTransaction();
         try{
	         session.save(object);
	         t.commit();
         }catch(HibernateException he){
        	 t.rollback();
        	 he.printStackTrace();
         }
	}

	@Override
	public void delete(Object object) {
        Session session = util.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        try{
	         session.delete(object);
	         t.commit();
        }catch(HibernateException he){
       	 t.rollback();
       	 he.printStackTrace();
        }
	}

	@Override
	public void update(Object object) {
        Session session = util.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        try{
	         session.update(object);
	         t.commit();
        }catch(HibernateException he){
       	 t.rollback();
       	 he.printStackTrace();
        }
	}
	
	@Override
	public List query(String entityName) {
		Session session = util.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "from "+entityName;
		Query query = session.createQuery(hql);
		return query.list();
	}
	
	@Override
	public List query(String entityName, int page ,int  max_results) {
		Session session = util.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "from "+entityName;
		Query query = session.createQuery(hql);
		query.setFirstResult(page);
		query.setMaxResults(max_results);
		return query.list();
	}
	
	@Override
	public List query(String entityName, Map<String,Object> value){
		Session session = util.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "from "+entityName+where(value);
    	Iterator iterator = value.entrySet().iterator();
        Query query = session.createQuery(hql);
    	for(;iterator.hasNext();){
    		Entry<String,Object> entry = (Entry)iterator.next();
    		query.setParameter(entry.getKey(), entry.getValue());
    	}
		return query.list();
	}
	@Override
	public List query(String entityName, Map<String,Object> value, int page, int max_results){
		Session session = util.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "from "+entityName+where(value);
    	Iterator iterator = value.entrySet().iterator();
        Query query = session.createQuery(hql);
    	for(;iterator.hasNext();){
    		Entry<String,Object> entry = (Entry)iterator.next();
    		query.setParameter(entry.getKey(), entry.getValue());
    	}
    	query.setMaxResults(max_results);
    	query.setFirstResult(page);
		return query.list();
	}
	
	@Override
	public Object object(String entityName, long id) {
        Session session = util.getSessionFactory().getCurrentSession();
        session.beginTransaction();
		return session.get(entityName,id);
	}

	@Override
    public String where(Map valueName){
    	Iterator it = valueName.entrySet().iterator();
		int len = valueName.size();
    	String where = "";
    	if(len!=0){
	    	for(int i=0;it.hasNext();i++){
	    		Entry entry = (Entry)it.next();
	    		if(entry.getValue()==null || entry.getValue().equals("")|| entry.getKey()==null|| entry.getKey().equals("")){
	    			
	    		}else{
	    			if(i<len-1){
		    		    where += entry.getKey()+"=:"+entry.getKey()+" and ";
		    		}else if(i==len-1){
		    			where += entry.getKey()+"=:"+entry.getKey();
		    		}
	    		}
	    	}
		    return " where "+where;
    	}else{
    		return "";
    	}
	}
	
	public Util getUtil() {
		return util;
	}

	public void setUtil(Util util) {
		this.util = util;
	}

}
