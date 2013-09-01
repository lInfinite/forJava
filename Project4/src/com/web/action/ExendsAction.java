package com.web.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.dao.BaseDao;
import com.dao.impl.BaseImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.util.Page;
import com.util.Util;

public class ExendsAction  extends ActionSupport{
	
	private ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext());
	private BaseDao base = (BaseImpl)context.getBean("BaseImpl");;
	private Page page = (Page)context.getBean("Page");
	private Util util = (Util)context.getBean("Util");
	
    public String result(Object obj,String entity,String result){
    	if(obj==null){
    		obj = base.query(entity,null, page.getPage(), page.getMax_results());
    		page.setList_size_and_End(base.query(entity));
    	}else{
    		obj = base.query(entity, util.getValue(obj), page.getPage(), page.getMax_results());
    		page.setList_size_and_End(base.query(entity, util.getValue(obj)));
    	}
    	return result;
    }
    
    
}
