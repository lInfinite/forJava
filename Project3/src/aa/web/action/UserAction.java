package aa.web.action;
/**
 * 用户登陆
 * 用户注册
 * */
import java.util.List;
import java.util.Map;


import org.apache.struts2.interceptor.SessionAware;

import aa.entity.Users;

import aa.service.dao.impl.UserServiceImpl;
import aa.uitl.StaticHibernate;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport implements SessionAware{
    //实体类和操作类
	private Users user;
    private UserServiceImpl usi;
    //session
    private Map<String,Object> session;
    //页面交互
    private int page=0;
    private int goPage;
    private int backPage;
    private List<Users> user_list;
    /**
     * 注册
     **/
    public String login(){
    	
    	if(usi.findUserName(user.getName())){
    		usi.saveUser(user);    		
    		return "goto_manager2";
    	}else{    		
    		this.addFieldError("NameErorr", "已有用户名");
    	}
    	
    	if(user.getPassword().equals("")||user.getPassword()==null){
    		this.addFieldError("PasswordErorr", "密码不能为空");
    	}
    	
    	if(user.getNames().equals("")||user.getNames()==null){
    		this.addFieldError("NamesErorr", "名字不能为空");
    	}
    	
    	if(user.getPhone().length()!="12345678910".length()){
    		this.addFieldError("PhoneErorr", "手机长度不对");
    	}
    	
    	return "goto_manager3";
    }
    /**
     * 登陆
     * */
    public String logon(){
    	Users u = usi.createUser(user.getName(), user.getPassword());
    	if(u!=null){
    		session.put("user", u);
    	    return "goto_index";
    	}else{
    		this.addFieldError("LogonErorr", "账号或密码错误，请重新登陆");
    	    return "goto_logon";	
    	}
    	
    }
    /**
     * 分页查询
     * */
    
    public String pageSelect(){
    	user_list = usi.userList(page);
    	return "goto_manager2";
    }
    /**
     * 注销
     * */
    public String loginOut(){
    	session.remove("user");
    	return "jump_logon";
    }
    
    /**
     * 更新个人信息
     * */
    public String update(){
    	Users u = (Users) session.get("user");
    	usi.updateUser(u, user);
    	session.put("user", u);
    	return "update";
    }
    /**
     * 修改用户名和密码
     * */ 
    public String change(){
    	Users u = (Users) session.get("user");
    	usi.changeUser(u, user);
    	session.put("user", u);
    	return "change";
    }
    
/**
 * 验证
 * */
/*	public void validate() {

	}*/
	

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

/**
 * getter和setter
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
