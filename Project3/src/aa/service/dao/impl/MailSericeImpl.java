package aa.service.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aa.base.dao.BaseDao;
import aa.base.dao.impl.BaseImpl;
import aa.entity.Mail;
import aa.entity.Users;
import aa.service.dao.MailSericeDao;
import aa.uitl.StaticHibernate;

public class MailSericeImpl implements MailSericeDao {
	
	private BaseImpl baseImpl;
	private Session session = null;
	private Transaction t = null;
	@Override
	
	
	
	public void saveMail(Mail mail) {
		try{
			session = StaticHibernate.getSessionFactory().getCurrentSession();
			t = session.beginTransaction();
		    session.save(mail);
		    t.commit();
		}catch(HibernateException he){
			t.rollback();
			he.printStackTrace();
		}
	}
    
	
	public Users findUser(String userName){
        String[] valueName = {"name"};
        Object[] value = {userName};
		Users user = (Users)baseImpl.selectCriteria("Users", valueName, value).get(0);
		return user;
	}
	
	
	public List<Users> selectUsers(){
		List<Users> list= baseImpl.selectAll("Users");
		return list;
	}
	
	
	@Override
	public Mail createMail(int id) {
		String[] ValueName={"id"};
		Object[] obj = {id};
		List<Mail> list = baseImpl.selectCriteria("Mail", ValueName, obj);
		Mail mail = list.get(0);
		return mail;
	}

	
	@Override
	public List<Mail> selectMail(int id,int page,int dele) {
		String[] ValueName = {"read_id","dele"};
		Object[] value = {id,dele};
		List<Mail> list = baseImpl.selectForPageAndCriteria("Mail", page, ValueName, value);
		return list;
	}
	
	
	@Override
	public void updateMail(Mail mail) {
		try{
			session = StaticHibernate.getSessionFactory().getCurrentSession();
			t = session.beginTransaction();
			session.update(mail);
			t.commit();
		}catch(HibernateException he){
			t.rollback();
			he.printStackTrace();
		}
	}
	
	
	@Override
	public List<Mail> selectDele(int id, int page) {
		String[] ValueName = {"read_id","dele"};
		Object[] value = {id,1};
		List<Mail> list =baseImpl.selectForPageAndCriteria("Mail", page, ValueName, value);
		return list;
	}


	@Override
	public void deleteMail(Mail mail) {
		try{
			session = StaticHibernate.getSessionFactory().getCurrentSession();
			t = session.beginTransaction();
			session.delete(mail);
		    t.commit();
		}catch(HibernateException he){
			t.rollback();
			he.printStackTrace();
		}
		
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
