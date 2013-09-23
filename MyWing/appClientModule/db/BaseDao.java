package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.impl.BaseUtil.sdu;


public interface BaseDao {
    public Connection getConnerction();
    public void update(String sql, Object[] value);
    public ResultSet query(String sql, Object[] value);
    public void update(Object obj, sdu em);
    public List list(String sql, Object[] value,Object obj);
    public void allClose();
}
