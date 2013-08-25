package com.service.dao.impl;

import java.util.List;
import java.util.Map;

import com.entity.ClintLevel;
import com.entity.Product;
import com.entity.Region;
import com.entity.ServiceType;
import com.entity.Stock;
import com.service.dao.BasesDao;
import com.dao.BaseDao;

public class BasesImpl implements BasesDao {
    
	private BaseDao base;
	
	
	@Override
	public ClintLevel clint_level(Long id) {
		return (ClintLevel)base.object(ClintLevel.class, id);
	}


	@Override
	public ServiceType service_type(Long id) {
		return (ServiceType)base.object(ServiceType.class, id);
	}


	@Override
	public Region region(Long id) {
		return (Region)base.object(Region.class, id);
	}
	

	@Override
	public Product product(Long id) {
		return (Product)base.object(Product.class, id);
	}


	@Override
	public Stock stock(Long id) {
		return (Stock)base.object(Stock.class, id);
	}


	public BaseDao getBase() {
		return base;
	}


	public void setBase(BaseDao base) {
		this.base = base;
	}
	
	
}
