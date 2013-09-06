package com.web.action;

import com.entity.SellChance;

public class ClientAction extends SuperAction{
   
	private SellChance sell_chance;
    
	public String msg(){
		String result = super.result(sell_chance, "SellChance", "client_msg.jsp");
		return result;
	}
    
	public SellChance getSell_chance() {
		return sell_chance;
	}

	public void setSell_chance(SellChance sell_chance) {
		this.sell_chance = sell_chance;
	}
    
    
}
