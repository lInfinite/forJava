package aa.service.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import aa.base.dao.impl.BaseImpl;
import aa.entity.Days;
import aa.entity.Users;
import aa.service.dao.DaysSericeDao;
import aa.uitl.StaticHibernate;

public class DaysSericeImpl implements DaysSericeDao{
    
	private BaseImpl baseImpl;
	private Session session;
	private Transaction t;
	
	@Override
	public Days createDays(int id) {
		String[] ValueName ={"id"};
		Object[] value = {id};
		List<Days> days_list = baseImpl.selectCriteria("Days", ValueName, value);
		Days days = days_list.get(0);
		return days;
	}

	
	@Override
	public List<Days> selectAllDays(int page) {
		List<Days> list = baseImpl.selectForPage("Days", page);
		return list;
	}

	
	@Override
	public List<Days> selectIdDays(int id,int page) {
		String[] ValueName = {"read_id"};
		Object[] value = {id};
		return baseImpl.selectForPageAndCriteria("Days", page, ValueName, value);
	}

	
	@Override
	public void saveDays(Days days) {
		try{
			session = StaticHibernate.getSessionFactory().getCurrentSession();
			t = session.beginTransaction();
		    session.save(days);
		    t.commit();
		}catch(HibernateException he){
			t.rollback();
			he.printStackTrace();
		}
	}


	@Override
	public void updateDays(Days days) {
		try{
			session = StaticHibernate.getSessionFactory().getCurrentSession();
			t = session.beginTransaction();
		    session.update(days);
		    t.commit();
		}catch(HibernateException he){
			t.rollback();
			he.printStackTrace();
		}
	}


	@Override
	public List<Users> selectUsers() {
		List<Users> list= baseImpl.selectAll("Users");
		return list;
	}


	/**
	 * getter and setter
	 * */

	public BaseImpl getBaseImpl() {
		return baseImpl;
	}


	public void setBaseImpl(BaseImpl baseImpl) {
		this.baseImpl = baseImpl;
	}
    
	
	
}
