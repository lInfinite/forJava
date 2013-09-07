package com.web.action;

import java.util.List;

import com.entity.SellChance;

public class ClientAction extends SuperAction{
  
	
	/**entity**/
	private SellChance sell_chance;
    /**list**/
	private List<SellChance> sell_chance_list;
	/**
	 * 客户信息
	 * **/
	
	
	/**初始化客户信息**/
	public String msg(){
		String result = super.result(sell_chance, "SellChance", "client_msg.jsp");
		sell_chance_list = super.list;
		return result;
	}
    
	
	
	
	
	
	/** entity getter and setter **/
	public SellChance getSell_chance() {
		return sell_chance;
	}

	public void setSell_chance(SellChance sell_chance) {
		this.sell_chance = sell_chance;
	}




    /**list getter and setter**/
	public List<SellChance> getSell_chance_list() {
		return sell_chance_list;
	}

	public void setSell_chance_list(List<SellChance> sell_chance_list) {
		this.sell_chance_list = sell_chance_list;
	}
	
	
  
    
}
