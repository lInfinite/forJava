package com.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.dao.BaseDao;
import com.dao.impl.BaseImpl;
import com.entity.ClintLevel;
import com.opensymphony.xwork2.ActionSupport;
import com.service.dao.BasesDao;
import com.service.dao.impl.BasesImpl;
import com.util.Page;
import com.util.Util;

public class BaseAction  extends ActionSupport{

	private ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext());
	private BaseDao base = (BaseImpl)context.getBean("BaseImpl");
	private Util util = (Util)context.getBean("Util");
	private Page page = (Page)context.getBean("Page");
	private BasesDao bases_dao = (BasesImpl)context.getBean("BasesImpl");
	private ClintLevel clint_level;
	
	private List<ClintLevel> clint_level_list;
	
	/**
	 * 客户等级
	 * **/
	//初始客户等级
	public String clintlevel(){
		clint_level_list = base.query("ClintLevel", page.getPage(), 5);
		return "base_client_level.jsp";
	}
	
	
    //初始添加页面
    public String create_clintlevel(){
    	return "base_client_level_create.html";
    }
    
    
    //初始编辑页面
	public String update_clintlevel(){
		clint_level = bases_dao.clint_level(clint_level.getId());
		return "base_client_level_update.jsp";
	}
    
    
	//条件查询
    public String queryClintLevel(){
    	clint_level_list = base.query("ClintLevel", util.getValue(clint_level), page.getPage(), 5);
    	return "base_client_level.jsp";
    }

    
    //创建客户等级
    public String createClintLevel(){
    	base.add(clint_level);
    	return clintlevel();
    }
    
    
    //编辑客户等级
    public String updateClintLevel(){
    	base.update(clint_level);
    	return clintlevel();
    }
    
    
    //删除客户等级
    public String deleteClintLevel(){
    	base.delete(clint_level);
    	return clintlevel();
    }
    
    
    /**
     * 服务类型
     * **/
    
    //初始化服务类型 
    public String base_service(){
    	base.query("", page.getPage(), 5);
    	return "base_service.jsp";
    }
    
    //初始化添加服务类型
    public String create_service(){
    	return "base_service_create.html";
    }
    
    
    //初始化编辑服务类型
    public String update_service(){
    	return "base_service_update.jsp";
    }
    
    
    //条件查询服务类型
    public String queryService(){
    	base.query("", util.getValue(null), page.getPage(), 5);
    	return "base_service.jsp";
    }
    
    
    //添加服务类型
    public String createService(){
    	return base_service();
    }
    
    
    //编辑服务类型
    
    
    
    //删除服务类型
    
    
    /**
     *地区
     * **/
    
    
    
	public ClintLevel getClint_level() {
		return clint_level;
	}

	public void setClint_level(ClintLevel clint_level) {
		this.clint_level = clint_level;
	}


	public List<ClintLevel> getClint_level_list() {
		return clint_level_list;
	}


	public void setClint_level_list(List<ClintLevel> clint_level_list) {
		this.clint_level_list = clint_level_list;
	}
	
	
	
}
