package aa.base.dao.impl;
/**
 * 根据实体类名超找
 * 根据实体类名和字段名和字段值查找内容
 * */
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import aa.base.dao.BaseDao;
import aa.uitl.StaticHibernate;

public class BaseImpl implements BaseDao{
	
	private Session session;
	


	@Override
	public List selectAll(String ClassName) {
		try{
			session = StaticHibernate.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			String HQL = "from "+ClassName;
			Query query = session.createQuery(HQL);
			return query.list();
		}catch(HibernateException he){
			he.printStackTrace();
			return null;
		}finally{
			session.clear();
		}
	}


	@Override
	public List selectCriteria(String ClassName,String[] ValueName, Object[] obj) {
		if(ValueName.length==obj.length){	
    	}else{
    		System.out.println("出错！不匹配！");
    		return null;
    	}
		
    	int len = ValueName.length;
    	String hql =StaticHibernate.changeHQL(ValueName);
		try{
			session = StaticHibernate.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			String HQL = "from "+ClassName+" where "+hql;
			System.out.println(HQL);
			Query query = session.createQuery(HQL);
			for(int i=0;i<obj.length;i++){
			    query.setParameter(ValueName[i], obj[i]);
			}
			return query.list();
		}catch(HibernateException he){
			he.printStackTrace();
			return null;
		}finally{
			session.clear();
		}
	}

	@Override
	public List selectForPage(String ClassName, int page) {
		Query query;
		try{
			session = StaticHibernate.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			String hql = "from "+ClassName;
			query = session.createQuery(hql);
			query.setFirstResult(page);
			query.setMaxResults(StaticHibernate.maxPage);
			return query.list();
		}catch(HibernateException he){
			he.printStackTrace();
			return null;
		}finally{
			session.clear();
		}
		
	}

	@Override
	public List selectForPageAndCriteria(String ClassName, int page,String[] ValueName, Object[] value) {
		if(ValueName.length==value.length){	
    	}else{
    		System.out.println("出错！不匹配！");
    		return null;
    	}
		
    	int len = ValueName.length;
    	String hql =StaticHibernate.changeHQL(ValueName);
		try{
			session = StaticHibernate.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			String HQL = "from "+ClassName+" where "+hql;
			System.out.println(HQL);
			Query query = session.createQuery(HQL);
			for(int i=0;i<value.length;i++){
			    query.setParameter(ValueName[i],value[i]);
			}
			query.setFirstResult(page);
			query.setMaxResults(StaticHibernate.maxPage);
			return query.list();
		}catch(HibernateException he){
			he.printStackTrace();
			return null;
		}finally{
			session.clear();
		}
	}

	
	
}
