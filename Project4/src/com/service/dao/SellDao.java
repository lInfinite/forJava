package com.service.dao;

import java.util.List;

import com.entity.SellChance;

public interface SellDao {
	public List<SellChance> query();
    public List<SellChance> query(int page);
    public List<SellChance> query(SellChance sell_chanc);
    public List<SellChance> query(SellChance sell_chanc, int page);
    public SellChance sellChance(long id);
    
}
