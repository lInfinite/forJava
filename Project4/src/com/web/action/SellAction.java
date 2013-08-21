package com.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.dao.BaseDao;
import com.dao.impl.BaseImpl;
import com.entity.*;
import com.opensymphony.xwork2.ActionSupport;
import com.service.dao.SellDao;
import com.service.dao.impl.SellImpl;
import com.util.Page;

public class SellAction extends ActionSupport{
	
	
	private ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext());
	private SellDao sell_dao = (SellImpl)context.getBean("SellImpl");
	private SellChance sell_chance;
	private BaseDao base = (BaseImpl)context.getBean("BaseImpl");;
	private Page page = (Page)context.getBean("Page");
	
	private List<SellChance> sell_list;
	private List<ClintLevel> client_level_list;
	private List<Region> region_list;
	
	
    public String chance_manage(){
    	sell_list = sell_dao.query(page.getPage());
    	return "_init_sell_chance";
    }

    
    public String create(){
    	
    	return "_init_create_sell_chance";
    }
    
    
    
    
    
    public Page getPage() {
		return page;
	}


	public void setPage(Page page) {
		this.page = page;
	}


	public SellDao getSell_dao() {
		return sell_dao;
	}
	public void setSell_dao(SellDao sell_dao) {
		this.sell_dao = sell_dao;
	}


	public SellChance getSell_chance() {
		return sell_chance;
	}
	public void setSell_chance(SellChance sell_chance) {
		this.sell_chance = sell_chance;
	}

	
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


	public BaseDao getBase() {
		return base;
	}
	public void setBase(BaseDao base) {
		this.base = base;
	}
	
	
}
