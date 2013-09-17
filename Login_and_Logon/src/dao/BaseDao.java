package dao;

import java.util.List;

import util.Page;

import dao.impl.BaseImpl.Operation;

public interface BaseDao {
    public void save_delete_update(Object obj, Operation o);
    public List queryAll(String entityName);
    public List query(String entityName,Object obj, Page page);
    public Object object(Class className, Long id);
    public Object object(Class className, String id);
}
