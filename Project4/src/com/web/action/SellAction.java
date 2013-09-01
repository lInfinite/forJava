package com.web.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.dao.BaseDao;
import com.dao.impl.BaseImpl;
import com.entity.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.dao.SellDao;
import com.service.dao.impl.SellImpl;
import com.util.Page;
import com.util.Util;

public class SellAction extends SuperAction implements SessionAware{

	//service
	private SellDao sell_dao = (SellImpl)context.getBean("SellImpl");
    //entity
	private SellChance sell_chance;
	private CreateClinet create_clinet;
	//list
	private List<SellChance> sell_list;
	private List<ClintLevel> client_level_list;
	private List<Region> region_list;
	private List<User> user_list;
	private List<CreateClinet> clinet_list;
	//
	private Long clinet_manage_id;
	private Map<String,Object> session;
	
	
	
	//初始化action
	public SellAction(){
		page.setMax_results(5);
	}
	
	
	//初始化销售机会管理
    public String sell_chance(){
    	String result = super.result(sell_chance, "SellChance", "sell_chance.jsp");
    	sell_list = super.list;
    	return result;
    }

    
    //初始化创建销售机会
    public String create_sell(){
    	client_level_list = base.query("ClintLevel");
    	region_list = base.query("Region");
    	
    	User user = new User();
    	Role role = new Role();
    	role.setName("客户经理");
    	try{
    	role = (Role)base.query("Role", util.getValue(role)).get(0);
    	user.setRole(role);
    	}catch(IndexOutOfBoundsException e){
    		e.printStackTrace();
    	}
    	user_list = base.query("User", util.getValue(user));
    	return "sell_chance_add.jsp";
    }
    
    
    //添加销售机会
    public String createSell(){
    	
    	if(clinet_manage_id==null || clinet_manage_id<1){
    		sell_chance.setState("未分配");
    	}else{
    		sell_chance.setState("已指派");
    		User manage = (User)base.object(User.class, clinet_manage_id);
    		sell_chance.setClinet_manage(manage);
    	}
    	User user = (User)session.get("user");
    	System.out.println(user);
    	sell_chance.setCreate_man(user);
    	base.add(sell_chance);
    	sell_chance=null;
    	return sell_chance();
    }
    
    
    //初始化编辑销售机会
    public String update_sell(){
    	sell_chance = sell_dao.sellChance(sell_chance.getId());
    	create_sell();
    	return "sell_chance_update.jsp";
    }
    
    
    //编辑销售机会
    public String updateSell(){
    	if(clinet_manage_id==null || clinet_manage_id<1){
    		sell_chance.setState("未分配");
    	}else{
    		sell_chance.setState("已指派");
    		User manage = (User)base.object(User.class, clinet_manage_id);
    		sell_chance.setClinet_manage(manage);
    	}
    	base.update(sell_chance);
    	sell_chance=null;
    	return sell_chance();
    }
    
    
    //删除销售机会
    public String deleteSell(){
    	SellChance sc = sell_dao.sellChance(sell_chance.getId());
    	
    	if(sc.getState().equals("未分配")){
    		base.delete(sell_chance);
    	}
    	sell_chance=null;
    	return sell_chance();
    }
    
    
    //初始化指派
    public String appoint(){
    	update_sell();
    	return "sell_chance_appoint.jsp";
    }
    
    
    /**
     * 客户开发管理
     * **/
    
    //初始化客户开发
    public String client(){
    	return super.result(create_clinet, "CreateClinet", "sell_client.jsp");
    }
    
    
    //初始化添加
    public String create_client(){
    	
    	return "";
    }
    
    
    //初始化编辑
    public String update_client(){
    	
    	return "";
    }
    
    
    
    
    //entity getter and setter
	public SellChance getSell_chance() {
		return sell_chance;
	}
	
	public void setSell_chance(SellChance sell_chance) {
		this.sell_chance = sell_chance;
	}
	

	public SellDao getSell_dao() {
		return sell_dao;
	}
	
	public void setSell_dao(SellDao sell_dao) {
		this.sell_dao = sell_dao;
	}


	public CreateClinet getCreate_clinet() {
		return create_clinet;
	}

	public void setCreate_clinet(CreateClinet create_clinet) {
		this.create_clinet = create_clinet;
	}


	public List<CreateClinet> getClinet_list() {
		return clinet_list;
	}

	public void setClinet_list(List<CreateClinet> clinet_list) {
		this.clinet_list = clinet_list;
	}


	//list getter and setter
	public List<SellChance> getSell_list() {
		return sell_list;
	}


	public void setSell_list(List<SellChance> sell_list) {
		this.sell_list = sell_list;
	}


	public List<ClintLevel> getClient_level_list() {
		return client_level_list;
	}
	
	public void setClient_level_list(List<ClintLevel> client_level_list) {
		this.client_level_list = client_level_list;
	}

	
	public List<Region> getRegion_list() {
		return region_list;
	}
	
	public void setRegion_list(List<Region> region_list) {
		this.region_list = region_list;
	}


	public List<User> getUser_list() {
		return user_list;
	}

	public void setUser_list(List<User> user_list) {
		this.user_list = user_list;
	}


	
    //
	public Long getClinet_manage_id() {
		return clinet_manage_id;
	}


	public void setClinet_manage_id(Long clinet_manage_id) {
		this.clinet_manage_id = clinet_manage_id;
	}


	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	
	
    public Page getPage() {
		return super.page;
	}

	public void setPage(Page page) {
		super.page = page;
	}

	
	
}
