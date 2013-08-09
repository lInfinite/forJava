package com.dao;

import java.util.List;
import java.util.Map;

public interface BaseDao {
	public void add(Object object);
	public void delete(Object object);
	public void update(Object object);
	public List query(String entityName);
	public List query(String entityName,int page, int max_results);
	public List query(String entityName, Map<String,Object> value);
	public List query(String entityName, Map<String,Object> value, int page, int max_results);
    public Object object(String entityName, long id);
    public String where(Map valueName);
}
