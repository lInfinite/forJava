package com.web.action;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.entity.ClientMsg;
import com.entity.ClintLevel;
import com.entity.LinkMan;
import com.entity.Region;
import com.entity.SellChance;
import com.service.dao.SellDao;
import com.service.dao.impl.SellImpl;

public class ClientAction extends SuperAction{
  
	
	/**entity**/
	private SellChance sell_chance;
	private ClientMsg client_msg;
	private LinkMan linkman;
    /**list**/
	private List<SellChance> sell_chance_list;
	private List<ClintLevel> client_level_list;
	private List<Region> region_list;
	private List<LinkMan> link_man_list;
	/**service**/
	private SellDao sell_dao = (SellImpl)context.getBean("SellImpl");
	
	
	
	/**
	 * 客户信息
	 * **/
		
	/**初始化客户信息**/
	public String msg(){
		client_level_list = base.query("ClintLevel");
		region_list = base.query("Region");
		if(sell_chance == null){
			sell_chance = new SellChance();
			sell_chance.setState("成功");
		}
		String result = super.result(sell_chance, "SellChance", "client_msg.jsp");
		sell_chance_list = super.list;
		return result;
	}
    
	
	/**初始化客户信息编辑**/
	public String update_msg(){
		client_level_list = base.query("ClintLevel");
		sell_chance = sell_dao.sellChance(sell_chance.getId());
		region_list = base.query("Region");
		return "client_msg_update.jsp";
	}
	
	
	
	/**添加或修改客户信息**/
	public String updateMsg(){
		client_msg.setSell_chance(sell_chance);
		base.add(client_msg);
		sell_chance = null;
		return msg();
	}

	
	/**初始化linkman**/
	public String link_man(){
		sell_chance = (SellChance)base.object(SellChance.class, sell_chance.getId());
		link_man_list = util.list_for_OneToMany(sell_chance.getLinkman());
	    return "client_msg_linkman.jsp";	
	}
	
	
	/**初始化创建联系人**/
	public String create_linkman(){
		return "client_msg_linkman_create.jsp";
	}
	
	
	/**保存联系人**/
	public String createLinkman(){
		sell_chance = (SellChance)base.object(SellChance.class, sell_chance.getId());
		linkman.setSell_chance(sell_chance);
		base.add(linkman);
		linkman = null;
		return link_man();
	}
	
	
	/**初始化编辑联系人**/
	public String update_linkman(){
		linkman = (LinkMan)base.object(LinkMan.class, linkman.getId());
		return "client_msg_linkman_update.jsp";
	}
	
	
	/**编辑联系人**/
	public String updateLikman(){
		sell_chance = (SellChance)base.object(SellChance.class, sell_chance.getId());
		linkman.setSell_chance(sell_chance);
		base.update(linkman);
		linkman = null;
		return link_man();
	}
	
	
	/**删除联系人**/
	public String delteLinkman(){
		base.delete(linkman);
		return link_man();
	} 
	
	
	/** entity getter and setter **/
	public SellChance getSell_chance() {
		return sell_chance;
	}

	public void setSell_chance(SellChance sell_chance) {
		this.sell_chance = sell_chance;
	}

	
	public ClientMsg getClient_msg() {
		return client_msg;
	}

	public void setClient_msg(ClientMsg client_msg) {
		this.client_msg = client_msg;
	}

	
	public LinkMan getLinkman() {
		return linkman;
	}

	public void setLinkman(LinkMan linkman) {
		this.linkman = linkman;
	}

    /**list getter and setter**/
	public List<SellChance> getSell_chance_list() {
		return sell_chance_list;
	}

	public void setSell_chance_list(List<SellChance> sell_chance_list) {
		this.sell_chance_list = sell_chance_list;
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


	public List<LinkMan> getLink_man_list() {
		return link_man_list;
	}

	public void setLink_man_list(List<LinkMan> link_man_list) {
		this.link_man_list = link_man_list;
	}


}
