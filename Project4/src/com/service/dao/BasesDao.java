package com.service.dao;

import com.entity.ClintLevel;
import com.entity.Product;
import com.entity.Region;
import com.entity.ServiceType;
import com.entity.Stock;

public interface BasesDao {
    public ClintLevel clint_level(Long id);
    public ServiceType service_type(Long id);
    public Region region(Long id);
    public Product product(Long id);
    public Stock stock(Long id);
}
