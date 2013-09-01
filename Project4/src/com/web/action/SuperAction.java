package com.web.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.dao.BaseDao;
import com.dao.impl.BaseImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.util.Page;
import com.util.Util;

public class SuperAction  extends ActionSupport implements SessionAware{
	
	public ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext());
	public BaseDao base = (BaseImpl)context.getBean("BaseImpl");;
	public Page page = (Page)context.getBean("Page");
	public Util util = (Util)context.getBean("Util");
	
	public List list;
	
	public Map<String, Object> session;
	
	
	
    public String result(Object obj, String entity, String result){
    	list=null;
    	if(obj==null){
    		list = base.query(entity,null, page.getPage(), page.getMax_results());
    		page.setList_size_and_End(base.query(entity));
    	}else{
    		list = base.query(entity, util.getValue(obj), page.getPage(), page.getMax_results());
    		page.setList_size_and_End(base.query(entity, util.getValue(obj)));
    	}
    	return result;
    }
    
    
	@Override
    public void setSession(Map<String, Object> session) {
    	this.session = session;
    }
    
	
    public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
}
