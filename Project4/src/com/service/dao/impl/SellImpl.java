package com.service.dao.impl;




import com.dao.BaseDao;
import com.entity.CreateClinet;
import com.entity.SellChance;
import com.service.dao.SellDao;

public class SellImpl implements SellDao{
	
	private SellChance sell;
    private BaseDao base;
   
	@Override
	public SellChance sellChance(long id) {
		return (SellChance)base.object(SellChance.class, id);
	}


	@Override
	public CreateClinet createClient(long id) {
		return (CreateClinet)base.object(CreateClinet.class, id);
	}

	

	


	

	public BaseDao getBase() {
		return base;
	}

	public void setBase(BaseDao base) {
		this.base = base;
	}

	

	
	
}
