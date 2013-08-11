package aa.web.action;
/**
 * �û���½
 * �û�ע��
 * */
import java.util.List;
import java.util.Map;


import org.apache.struts2.interceptor.SessionAware;

import aa.entity.Users;

import aa.service.dao.impl.UserServiceImpl;
import aa.uitl.StaticHibernate;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport implements SessionAware{
    //ʵ����Ͳ�����
	private Users user;
    private UserServiceImpl usi;
    //session
    private Map<String,Object> session;
    //ҳ�潻��
    private int page=0;
    private int goPage;
    private int backPage;
    private List<Users> user_list;
    /**
     * ע��
     **/
    public String login(){
    	
    	if(usi.findUserName(user.getName())){
    		usi.saveUser(user);    		
    		return "goto_manager2";
    	}else{    		
    		this.addFieldError("NameErorr", "�����û���");
    	}
    	
    	if(user.getPassword().equals("")||user.getPassword()==null){
    		this.addFieldError("PasswordErorr", "���벻��Ϊ��");
    	}
    	
    	if(user.getNames().equals("")||user.getNames()==null){
    		this.addFieldError("NamesErorr", "���ֲ���Ϊ��");
    	}
    	
    	if(user.getPhone().length()!="12345678910".length()){
    		this.addFieldError("PhoneErorr", "�ֻ����Ȳ���");
    	}
    	
    	return "goto_manager3";
    }
    /**
     * ��½
     * */
    public String logon(){
    	Users u = usi.createUser(user.getName(), user.getPassword());
    	if(u!=null){
    		session.put("user", u);
    	    return "goto_index";
    	}else{
    		this.addFieldError("LogonErorr", "�˺Ż�������������µ�½");
    	    return "goto_logon";	
    	}
    	
    }
    /**
     * ��ҳ��ѯ
     * */
    
    public String pageSelect(){
    	user_list = usi.userList(page);
    	return "goto_manager2";
    }
    /**
     * ע��
     * */
    public String loginOut(){
    	session.remove("user");
    	return "jump_logon";
    }
    
    /**
     * ���¸�����Ϣ
     * */
    public String update(){
    	Users u = (Users) session.get("user");
    	usi.updateUser(u, user);
    	session.put("user", u);
    	return "update";
    }
    /**
     * �޸��û���������
     * */ 
    public String change(){
    	Users u = (Users) session.get("user");
    	usi.changeUser(u, user);
    	session.put("user", u);
    	return "change";
    }
    
/**
 * ��֤
 * */
/*	public void validate() {

	}*/
	

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

/**
 * getter��setter
 */
	
	public List<Users> getUser_list() {
    	return user_list;
    }
	public void setUser_list(List<Users> user_list) {
		this.user_list = user_list;
	}
	
	
	public UserServiceImpl getUsi() {
		return usi;
	}
	public void setUsi(UserServiceImpl usi) {
		this.usi = usi;
	}
	
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	public int getGoPage() {
		/*return goPage;*/
		return page+StaticHibernate.maxPage;
	}
	public void setGoPage(int goPage) {
		this.goPage = goPage;
	}
	
	public int getBackPage() {
		/*return backPage;*/
		return page-StaticHibernate.maxPage;
	}
	public void setBackPe(int backPage) {
		this.backPage = backPage;
	}

	
}
