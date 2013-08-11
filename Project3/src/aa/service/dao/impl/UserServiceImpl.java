package aa.service.dao.impl;



import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aa.base.dao.BaseDao;
import aa.base.dao.impl.BaseImpl;
import aa.entity.Users;
import aa.service.dao.UserServiceDao;
import aa.uitl.StaticHibernate;

public class UserServiceImpl implements UserServiceDao{


	private BaseImpl baseImpl;
	private Session session = null;
	private Transaction t = null;

	@Override
	public void saveUser(Users user) {
		try{
		    session = StaticHibernate.getSessionFactory().getCurrentSession();
		    t = session.beginTransaction();
		    session.save(user);
		    t.commit();
		}catch(HibernateException he){
			t.rollback();
			he.printStackTrace();
		}
	}
	
	
	@Override
	public Boolean findUserName(String name) {
		String[] column ={"name"};
		Object[] value ={name}; 
		List<Users> list = baseImpl.selectCriteria("Users", column, value);
		if(list.size()==0){
		    return true;
		}else{
		    return false;
		}
	}


	@Override
	public Users createUser(String name,String password) {
		String[] column ={"name","password"};
		Object[] value ={name,password}; 
		List<Users> list = baseImpl.selectCriteria("Users", column, value);
		if(list.size()==1){
			Users user = list.get(0);
			return user;
		}else{
		    return null;
		}
	}
	
	
    @Override
	public void updateUser(Users u, Users user) {
    	u.setNames(user.getNames());
    	u.setAge(user.getAge());
    	u.setSex(user.getSex());
    	u.setPhone(user.getPhone());
    	u.setAddress(user.getAddress());
    	try{
    	    session = StaticHibernate.getSessionFactory().getCurrentSession();
    	    t = session.beginTransaction();
    	    session.update(u);
    	    t.commit();
    	}catch(HibernateException he){
    		t.rollback();
    		he.printStackTrace();
    	}
	}

	@Override
	public void changeUser(Users u, Users user) {
		u.setName(user.getName());
		u.setPassword(user.getPassword());
		try{
		    Session session = StaticHibernate.getSessionFactory().getCurrentSession();
		    session.beginTransaction();
		    session.update(u);
		    t.commit();
		}catch(HibernateException he){
			t.rollback();
			he.printStackTrace();
		}	
	}

	@Override
	public List<Users> userList(int page) {
		return baseImpl.selectForPage("Users", page);
	}


	//getter and setter
	public BaseImpl getBaseImpl() {
		return baseImpl;
	}


	public void setBaseImpl(BaseImpl baseImpl) {
		this.baseImpl = baseImpl;
	}

}
